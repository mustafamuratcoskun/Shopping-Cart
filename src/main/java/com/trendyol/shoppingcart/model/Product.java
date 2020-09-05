package com.trendyol.shoppingcart.model;

import com.trendyol.shoppingcart.exception.InvalidException;

/**
 * It is the class that Product  entity.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class Product {

  private String title;
  private Double price;
  private Category category;

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param title    This is the first parameter to product title
   * @param price    This is the second parameter to product price
   * @param category This is the third parameter to minimum product category
   * @throws InvalidException It is null exception handle control.
   * @see IllegalArgumentException Exception handler.
   */
  public Product(String title, Double price, Category category) {

    this.title = title;
    this.price = price;
    this.category = category;

    if (title == null || price == null || category == null)  {
      throw new InvalidException("Can not be null!");
    }
    if (isZero()) {
      throw new InvalidException("Price can not be zero!");
    }
    if (isNegativePrice()) {
      throw new InvalidException("Price can not be zero!");
    }
  }

  /**
   * This method is negative value control
   * @return boolean negative price
   */
  public boolean isNegativePrice() {
    return this.price < 0D;
  }

  public boolean isZero() {
    return this.price < 0D;
  }

  /**
   * This method is getter value for minimum purchase value
   *
   * @return String product title
   */
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  /**
   *  * It method is getter value for price value
   *
   * @return double product price
   * */
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
  /**
   * This method is getter value for minimum purchase value
   *
   * @return category product category
   */
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }
}
