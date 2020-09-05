package com.trendyol.shoppingcart.delivery;

import com.trendyol.shoppingcart.exception.InvalidException;
import com.trendyol.shoppingcart.shopping.ShoppingCartController;

/**
 * It is the class that provides delivery cost calculate.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class DeliveryCost implements DeliveryCostCalculate {

  private final double costDelivery;
  private final double costProduct;
  private final double fixCost;

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param costDelivery This first parameter to constructor method delivery cost
   * @param costProduct  This second parameter to constructor method product cost
   * @param fixCost      This third parameter to constructor method fixed cost
   */
  public DeliveryCost(double costDelivery, double costProduct, double fixCost) {
    this.costDelivery = costDelivery;
    this.costProduct = costProduct;
    this.fixCost = fixCost;
  }

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param costDelivery This is the first parameter to constructor method
   * @param costProduct  This is the second  parameter to constructor method
   * @param fixCost      This is the third DiscountType variable parameter to constructor method
   * @throws InvalidException On input error.
   * @see InvalidException
   */
  public void validate(Double costDelivery, Double costProduct, Double fixCost) {
    if (costDelivery < 0 || costProduct < 0 || fixCost < 0) {
      throw new InvalidException("Cannot have negative value!");
    }
  }

  /**
   * This method is shopping delivery cost calculate.
   *
   * @param cart ShoppingCart is product delivery price's calculate
   * @return double This return value is calculate delivery cost.
   */
  @Override
  public double calculate(ShoppingCartController cart) {

    validate(costDelivery, costProduct, fixCost);
    return (costDelivery * cart.getShoppingCartDto().getTotalDeliveries()) + (costProduct * cart.getShoppingCartDto().getTotalProducts()) + fixCost;
  }

}
