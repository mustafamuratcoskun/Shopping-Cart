package com.trendyol.shoppingcart.discount;

import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.model.Campaign;
import com.trendyol.shoppingcart.model.Category;

import java.util.HashMap;

/**
 * It is the interface that product discount  calculate service.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public interface IDiscountCalculator {

  /**
   * This method is discount
   *
   * @param discount     This is the first parameter to discount calculate
   * @param discountType This is the second parameter to discount type
   * @return double discount rate
   */
  double discount(double discount, DiscountType discountType);

  /**
   * This method is calculate category for apply discount
   *
   * @param quantityByCategories This is the first parameter to categories quantity
   * @param priceByCategories    This is the second parameter to discount categories price
   * @param campaigns            This is the third parameter to discount product campings
   * @return double  campaings discount
   */
  double applyDiscount(HashMap<Category, Integer> quantityByCategories, HashMap<Category, Double> priceByCategories, Campaign... campaigns);
}
