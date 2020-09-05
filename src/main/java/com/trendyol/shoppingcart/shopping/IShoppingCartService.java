package com.trendyol.shoppingcart.shopping;

import com.trendyol.shoppingcart.model.Category;
import com.trendyol.shoppingcart.model.Product;

import java.util.HashMap;

/**
 * It is the interface that shopping cart service.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public interface IShoppingCartService {
  /**
   * This method is shopping cart checkout
   *
   * @param products This is the first parameter to products list.
   */
  void checkout(HashMap<Product, Integer> products);

  /**
   * This method is shopping products for delivery cost
   *
   * @param cart This is the first parameter to shopping cart
   * @return double delivery cost
   */
  double getDeliveryCost(ShoppingCartController cart);

  /**
   * This method is shopping products for total amount after discount
   *
   * @param totalPrice       This is the first parameter to total price
   * @param couponDiscount   This is the second parameter to coupon discount
   * @param campaignDiscount This is the third parameter to campaign discount
   */
  double getTotalAmountAfterDiscounts(double totalPrice, double couponDiscount, double campaignDiscount);

  /**
   * This method is shopping products for shopping cart add item
   *
   * @param products This is the first parameter to products
   * @param product  This is the second parameter to product
   * @param quantity This is the third parameter to total quantity
   * @return double add item.
   */
  double addItem(HashMap<Product, Integer> products, Product product, int quantity);

  /**
   * This method is shopping products for calculate category
   *
   * @param product        This is the first parameter to product
   * @param quantity       This is the second parameter to quantity
   * @param categoryPrices This is the third parameter to category prices
   * @return HashMap calculate category list
   */
  HashMap<Category, Double> calculateCategory(Product product, int quantity, HashMap<Category, Double> categoryPrices);

  /**
   * This method is shopping products for calculate product quantity
   *
   * @param product          This is the first parameter to product
   * @param quantity         This is the second parameter to quantity
   * @param categoryQuantity This is the third parameter to category quantity
   * @return HashMap calculate category list
   */
  HashMap<Category, Integer> calculateQuantities(Product product, int quantity, HashMap<Category, Integer> categoryQuantity);


}
