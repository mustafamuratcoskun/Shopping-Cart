package com.trendyol.shoppingcart.coupon;

import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.model.Coupon;

/**
 * It is the class that provides discounts calculate.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class CouponDiscountService implements ICouponDiscount {


  /**
   * This method is price discount apply by coupon
   *
   * @param coupon           This is the first parameter to discount coupon
   * @param campaignDiscount This is the second  parameter camping discount
   * @param totalPrice       This is the third totalPrice variable parameter to checkout total price
   */
  @Override
  public double applyCoupon(Coupon coupon, double campaignDiscount, double totalPrice) {
    return coupon.getDiscountType() == DiscountType.RATE ?
        (totalPrice - campaignDiscount) * coupon.getDiscount() :
        coupon.getDiscount();
  }

}
