#!/usr/bin/env bash
set -m

/entrypoint.sh couchbase-server &

sleep 15

# Setup index and memory quota
curl -v -X POST http://127.0.0.1:8091/pools/default -d memoryQuota=512 -d indexMemoryQuota=512 -d ftsMemoryQuota=256 -d cbasMemoryQuota=1024 -d eventingMemoryQuota=256

# Setup services
curl -v http://127.0.0.1:8091/node/controller/setupServices -d services=kv%2Cn1ql%2Cindex

# Setup credentials
curl -v http://127.0.0.1:8091/settings/web -d port=8091 -d username=admin -d password=password

#Setup indexes
curl -v -X POST http://127.0.0.1:8091/settings/indexes -u admin:password -d indexerThreads=4 -d logLevel=verbose -d maxRollbackPoints=2 -d storageMode=plasma -d redistributeIndexes=false -d numReplica=0 -d enablePageBloomFilter=false

#Create buckets
curl -v -X POST -u admin:password -d name=user -d ramQuotaMB=200 -d authType=none  -d flushEnabled=1  -d proxyPort=11216 http://localhost:8091/pools/default/buckets
curl -v -X POST -u admin:password -d name=todo -d ramQuotaMB=200 -d authType=none  -d flushEnabled=1  -d proxyPort=11216 http://localhost:8091/pools/default/buckets


echo "Type: $TYPE"


if [ "$TYPE" = "WORKER" ]; then
  sleep 15

  IP=`hostname -I`

  echo "Auto Rebalance: $AUTO_REBALANCE"
  if [ "$AUTO_REBALANCE" = "true" ]; then
    couchbase-cli rebalance --cluster=$COUCHBASE_MASTER:8091 --user=admin --password=password --server-add=$IP --server-add-username=admin --server-add-password=password
  else
    couchbase-cli server-add --cluster=$COUCHBASE_MASTER:8091 --user=admin --password=password --server-add=$IP --server-add-username=admin --server-add-password=password
  fi;
fi;


sleep 20
##Create indexes
curl -v -X POST -u admin:password -d statement=CREATE%20PRIMARY%20INDEX%20ON%20%60user%60 http://localhost:8093/query/service
curl -v -X POST -u admin:password -d statement=CREATE%20PRIMARY%20INDEX%20ON%20%60todo%60 http://localhost:8093/query/service

fg 1

