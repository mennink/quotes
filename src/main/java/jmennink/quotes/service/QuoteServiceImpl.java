package jmennink.quotes.service;

import java.util.List;

import jmennink.quotes.domain.Quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * The Class QuoteServiceImpl.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
@Component("quoteService")
@Transactional
public class QuoteServiceImpl implements QuoteService {


  /** The quote repository. */
  private final QuoteRepository quoteRepository;


  /**
   * Create a new quote service impl.
   * 
   * @param quoteRepository QuoteRepository the quote repository
   */
  @Autowired
  public QuoteServiceImpl(final QuoteRepository quoteRepository) {
    this.quoteRepository = quoteRepository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Quote> findAll() {
    return this.quoteRepository.findAll(sortByIdDesc());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Page<Quote> findAll(final Pageable pageable) {
    return this.quoteRepository.findAll(pageable);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Quote save(final Quote quote) {
    Assert.notNull(quote, "Criteria must not be null");
    return this.quoteRepository.save(quote);

  }


  private static Sort sortByIdDesc() {
    return new Sort(Sort.Direction.DESC, "id");
  }



}
