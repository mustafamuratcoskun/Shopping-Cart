package com.trendyol.shoppingcart.model;

/**
 * It is the class that Product Category entity.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class Category {

  private final String title;
  private Category subCategory;

  public Category(String title) {
    this.title = title;
  }
}
