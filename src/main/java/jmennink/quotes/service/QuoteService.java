package jmennink.quotes.service;



import java.util.List;

import jmennink.quotes.domain.Quote;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/**
 * The Interface QuoteService.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
public interface QuoteService {


  /**
   * Find all.<br>
   * <br>
   * 
   * @return List<Quote> the list
   */
  List<Quote> findAll();

  /**
   * Find all.<br>
   * <br>
   * 
   * @param pageable Pageable the pageable
   * @return Page<Quote> the page
   */
  Page<Quote> findAll(Pageable pageable);

  /**
   * Save.<br>
   * <br>
   * 
   * @param quote Quote the quote
   * @return Quote the quote
   */
  Quote save(Quote quote);


}
