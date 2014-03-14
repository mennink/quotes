package jmennink.quotes.service;

import java.util.List;

import jmennink.quotes.domain.Quote;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Interface QuoteRepository.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
interface QuoteRepository extends Repository<Quote, Long> {

  /**
   * Find all.<br>
   * <br>
   * 
   * @param sort Sort the sort
   * @return List<Quote> the list
   */
  List<Quote> findAll(Sort sort);

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
