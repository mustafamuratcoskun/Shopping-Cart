package com.trendyol.shoppingcart.model;

import com.trendyol.shoppingcart.discount.DiscountCalculatorService;
import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.exception.InvalidException;

/**
 * It is the class that Campaign entity.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class Campaign {
  private final Category category;
  private final double discount;
  private final int minimumQuantity;
  private final DiscountType discountType;
  DiscountCalculatorService discountCalculator = new DiscountCalculatorService();

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param category        This is the first parameter to product category
   * @param discount        This is the second parameter to campaign discount
   * @param minimumQuantity This is the third parameter to minimum product quantity
   * @param discountType    This is the fourth parameter to product discount type
   * @throws InvalidException It is null exception handle control.
   * @see IllegalArgumentException Exception handler.
   */
  public Campaign(Category category, double discount, int minimumQuantity, DiscountType discountType) {
    this.category = category;
    this.discount = discountCalculator.discount(discount, discountType);
    this.minimumQuantity = minimumQuantity;
    this.discountType = discountType;
    if (category == null || discountType == null)
      throw new InvalidException("Can not be null!");
  }

  /**
   * This method is getter value for category value
   */
  public Category getCategory() {
    return category;
  }

  /**
   * This method is getter value for discount value
   *
   * @return double discount
   */
  public double getDiscount() {
    return discount;
  }

  /**
   * This method is getter value for minimum quantity value
   *
   * @return int minimum quantity
   */
  public int getMinimumQuantity() {
    return minimumQuantity;
  }

  /**
   * This method is getter value for discount type value
   */
  public DiscountType getDiscountType() {
    return discountType;
  }

}
