package jmennink.quotes;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * The Class WebXml.<br>
 * <br>
 * This is needed if this application is being deployed as war
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
public class WebXml extends SpringBootServletInitializer {

  /**
   * {@inheritDoc}
   */
  @Override
  protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

}
