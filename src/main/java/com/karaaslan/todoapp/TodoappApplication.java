package com.karaaslan.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

/** The type Todoapp application. */
@SpringBootApplication
public class TodoappApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(TodoappApplication.class, args);
  }

  @PreDestroy
  public void preDestroy() {
    try {
      Thread.sleep(20 * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
