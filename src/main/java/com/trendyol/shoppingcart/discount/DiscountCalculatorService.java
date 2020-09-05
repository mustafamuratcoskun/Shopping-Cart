package com.trendyol.shoppingcart.discount;

import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.model.Campaign;
import com.trendyol.shoppingcart.model.Category;

import java.util.HashMap;

/**
 * It is the class that product discount  calculate service.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class DiscountCalculatorService implements IDiscountCalculator {

  /**
   * This method is price discount calculate.
   *
   * @param discount     This is the first parameter to discount calculate
   * @param discountType This is the second parameter to discount type
   * @return double discount rate
   */
  @Override
  public double discount(double discount, DiscountType discountType) {
    return discountType == DiscountType.RATE ? discount / 100.0 : discount;
  }

  /**
   * This method is apply discount  for  camping's category
   *
   * @param quantityByCategories This is the first parameter to categories quantity
   * @param priceByCategories    This is the second parameter to discount categories price
   * @param campaigns            This is the third parameter to discount product camping's
   * @return double  camping's discount
   */
  @Override
  public double applyDiscount(HashMap<Category, Integer> quantityByCategories, HashMap<Category, Double> priceByCategories, Campaign... campaigns) {
    double discount = 0D;
    for (Campaign campaign : campaigns) {
      if (quantityByCategories.get(campaign.getCategory()) >= campaign.getMinimumQuantity()) {
        discount = campaign.getDiscountType() == DiscountType.RATE ? priceByCategories.get(campaign.getCategory()) * campaign.getDiscount() :
            campaign.getDiscount();
      }
    }
    return discount;
  }
}
