package com.trendyol.shoppingcart.exception;

/**
 * It is the class that exception handler.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class InvalidException extends IllegalArgumentException {
  /**
   * This method is Invalid Exception .
   *
   * @param message This is the first parameter to exception message
   * @see IllegalArgumentException
   */
  public InvalidException(String message) {
    super(message);
  }
}