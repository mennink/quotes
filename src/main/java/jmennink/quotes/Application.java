package jmennink.quotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * The Class Application.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableAutoConfiguration
public class Application {

  /*
   * 
   */
  /**
   * The Spring Bootstrap main.
   * 
   * @param args the arguments
   */
  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);

  }



}
