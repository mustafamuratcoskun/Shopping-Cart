package com.trendyol.shoppingcart.model;


import com.trendyol.shoppingcart.discount.DiscountCalculatorService;
import com.trendyol.shoppingcart.enums.DiscountType;

/**
 * It is the class that provides discounts by using coupons in the cart.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class Coupon {

  private final int minPurchase;
  private final double discount;
  private final DiscountType discountType;

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param minPurchase  This is the first parameter to constructor method
   * @param discount     This is the second  parameter to constructor method
   * @param discountType This is the third DiscountType variable parameter to constructor method
   */
  public Coupon(int minPurchase, int discount, DiscountType discountType) {
    DiscountCalculatorService discountCalculator = new DiscountCalculatorService();
    this.minPurchase = minPurchase;
    this.discount = discountCalculator.discount(discount, discountType);
    this.discountType = discountType;
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
   * This method is getter value for discount type value
   */
  public DiscountType getDiscountType() {
    return discountType;
  }
}
