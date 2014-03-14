package jmennink.quotes.web;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import jmennink.quotes.domain.Quote;
import jmennink.quotes.service.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


// TODO: Auto-generated Javadoc
/**
 * The Class RootController.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
@Controller
public class RootController {

  /** The quote service. */
  @Autowired
  private QuoteService quoteService;



  /**
   * Quote list.<br>
   * <br>
   * 
   * @param page String the page
   * @param model Model the model
   * @return String the list view
   */
  @RequestMapping("/list")
  public String quoteList(@RequestParam(value = "page", required = false, defaultValue = "0") final String page,
                          final Model model) {
    int pageNumber = 0;

    try {
      pageNumber = Integer.parseInt(page) - 1;
      pageNumber = pageNumber < 0 ? 0 : pageNumber;
    } catch (final NumberFormatException e) {
      pageNumber = 0;
    }
    final Page<Quote> quotes = this.quoteService.findAll(new PageRequest(pageNumber, 10));

    model.addAttribute("page", page);
    model.addAttribute("quotes", quotes);
    model.addAttribute("pagenumber", pageNumber);
    model.addAttribute("max", quotes.getTotalPages());

    return "list";
  }

  /**
   * Quote list all.<br>
   * <br
   * 
   * @param model Model the model
   * @return String lastall view
   */
  @RequestMapping("/listall")
  public String quoteListAll(final Model model) {
    final List<Quote> quotes = this.quoteService.findAll();
    model.addAttribute("quotes", quotes);

    return "listall";
  }

  /**
   * Random quote.<br>
   * <br>
   * 
   * @param name String the name
   * @param model Model the model
   * @return String random view
   */
  @RequestMapping("/")
  public String randomQuote(@RequestParam(value = "name", required = false, defaultValue = "Guest") final String name,
                            final Model model) {
    final List<Quote> quotes = this.quoteService.findAll();
    final Quote quote = quotes.get(new Random().nextInt(quotes.size()));
    model.addAttribute("quote", quote);

    model.addAttribute("quotes", quotes);
    return "random";
  }



  /**
   * Show form.<br>
   * <br>
   * 
   * @param quote Quote the quote
   * @return String form view
   */
  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public static String showForm(final Quote quote) {
    return "form";
  }

  /**
   * Check quote.<br>
   * <br>
   * Checks quote for valid attributes and shows random view with newly created quote
   * 
   * @param quote Quote the quote
   * @param bindingResult BindingResult the binding result
   * @param model Model the model
   * @return String the random view
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String checkQuote(@ModelAttribute @Valid final Quote quote,
                           final BindingResult bindingResult,
                           final Model model) {
    if (bindingResult.hasErrors()) {
      return "form";
    }
    this.quoteService.save(quote);
    model.addAttribute("quote", quote);


    return "random";
  }
}
