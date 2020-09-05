package com.trendyol.shoppingcart.delivery;

import com.trendyol.shoppingcart.shopping.ShoppingCartController;

/**
 * It is the interface that provides delivery cost calculate.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public interface DeliveryCostCalculate {
  /**
   * This method is shopping delivery cost calculate.
   *
   * @param cart ShoppingCart is product delivery price's calculate
   * @return double This return value is calculate delivery cost.
   */
  double calculate(ShoppingCartController cart);

}
