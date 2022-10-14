package com.karaaslan.todoapp.configuration;

import com.karaaslan.todoapp.entity.TodoItem;
import com.karaaslan.todoapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

/** The type Couchbase configuration. */
@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
  @Autowired private MappingCouchbaseConverter mappingCouchbaseConverter;

  @Value("${app.couchbase.connection}")
  private String connection;

  @Value("${app.couchbase.username}")
  private String username;

  @Value("${app.couchbase.password}")
  private String password;

  @Value("${app.couchbase.bucket.user}")
  private String userBucket;

  @Value("${app.couchbase.bucket.todo}")
  private String todoBucket;

  @Override
  public String getConnectionString() {
    return "couchbase://" + connection;
  }

  @Override
  public String getUserName() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getBucketName() {
    return userBucket;
  }

  @Override
  protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
    mapping.mapEntity(TodoItem.class, todoTemplate());
    mapping.mapEntity(User.class, userTemplate());
  }

  /**
   * Todo template couchbase template.
   *
   * @return the couchbase template
   */
  @Bean
  public CouchbaseTemplate todoTemplate() {
    return customCouchbaseTemplate(customCouchbaseClientFactory(todoBucket));
  }

  /**
   * User template couchbase template.
   *
   * @return the couchbase template
   */
  @Bean
  public CouchbaseTemplate userTemplate() {
    return customCouchbaseTemplate(customCouchbaseClientFactory(userBucket));
  }

  /**
   * Custom couchbase template couchbase template.
   *
   * @param couchbaseClientFactory the couchbase client factory
   * @return the couchbase template
   */
  public CouchbaseTemplate customCouchbaseTemplate(CouchbaseClientFactory couchbaseClientFactory) {
    return new CouchbaseTemplate(couchbaseClientFactory, mappingCouchbaseConverter);
  }

  /**
   * Custom couchbase client factory couchbase client factory.
   *
   * @param bucketName the bucket name
   * @return the couchbase client factory
   */
  public CouchbaseClientFactory customCouchbaseClientFactory(String bucketName) {
    return new SimpleCouchbaseClientFactory(getConnectionString(), authenticator(), bucketName);
  }
}
