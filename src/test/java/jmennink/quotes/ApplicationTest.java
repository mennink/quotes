package jmennink.quotes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * The Class ApplicationTest.<br>
 * <br>
 * Used to set up the WebApplicationContext
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("scratch")
// Separate profile for web tests to avoid clashing databases
public class ApplicationTest {

  /** The context. */
  @Autowired
  private WebApplicationContext context;

  /** The mvc. */
  private MockMvc mvc;

  /**
   * Sets up the webapplication context<br>
   * <br>
   */
  @Before
  public void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  /**
   * Test home.<br>
   * <br>
   * 
   * @throws Exception the exception
   */
  @Test
  public void testHome() throws Exception {

    this.mvc.perform(get("/")).andExpect(status().isOk());
  }
}
