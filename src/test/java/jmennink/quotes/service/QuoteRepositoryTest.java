package jmennink.quotes.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import jmennink.quotes.Application;
import jmennink.quotes.domain.Quote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * The Class QuoteRepositoryTest.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 14, 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class QuoteRepositoryTest {

  /** The repository. */
  @Autowired
  QuoteRepository repository;

  /**
   * Finds first page of qoutes.<br>
   * <br>
   */
  @Test
  public void findsFirstPageOfQoutes() {

    final Page<Quote> quotes = this.repository.findAll(new PageRequest(0, 10));
    assertThat(quotes.getTotalElements(), is(greaterThan(20L)));
  }
}
