FROM couchbase
MAINTAINER Eyup Erhan KARAASLAN <eyuperhankaraaslan94@gmail.com>

RUN chmod +x /entrypoint.sh
COPY configure-node.sh /opt/couchbase
RUN chmod +x /opt/couchbase/configure-node.sh

CMD ["/opt/couchbase/configure-node.sh"]