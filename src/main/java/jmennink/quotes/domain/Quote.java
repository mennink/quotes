package jmennink.quotes.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// TODO: Auto-generated Javadoc
/**
 * The Class Quote.<br>
 * <br>
 * 
 * @author Jasper Mennink (c) Mar 13, 2014
 */
@Entity
public class Quote implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The id. */
  @Id
  @GeneratedValue
  private Long id;

  /** The text. */
  @Size(min = 10, max = 300)
  @NotNull
  @Column(nullable = false)
  private String text;

  /** The user name. */
  @Size(min = 2, max = 30)
  @NotNull
  @Column(nullable = false)
  private String name;


  /**
   * Create a new quote.
   */
  protected Quote() {}

  /**
   * Create a new quote.
   * 
   * @param name String the name
   * @param text String the text
   */
  public Quote(final String name, final String text) {
    super();
    this.name = name;
    this.text = text;

  }


  /**
   * Gets the text.
   * 
   * @return text as a String
   */
  public String getText() {
    return this.text;
  }

  /**
   * Sets the text.
   * 
   * @param text String the text
   */
  public void setText(final String text) {
    this.text = text;
  }

  /**
   * Gets the user.
   * 
   * @return user as a String
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sets the name.
   * 
   * @param name String the name
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return getName() + "," + getText();
  }
}
