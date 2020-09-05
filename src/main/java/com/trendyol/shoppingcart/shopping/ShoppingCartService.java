package com.trendyol.shoppingcart.shopping;

import com.trendyol.shoppingcart.delivery.DeliveryCost;
import com.trendyol.shoppingcart.model.Category;
import com.trendyol.shoppingcart.model.Product;

import java.util.HashMap;

/**
 * It is the class that Shopping Cart Service
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class ShoppingCartService implements IShoppingCartService {

  /**
   * This method is shopping cart checkout
   *
   * @param products This is the first parameter to products list.
   */
  @Override
  public void checkout(HashMap<Product, Integer> products) {
    products.forEach(
        (k, v) -> System.out.println(k.getTitle() + " >> " + v + " x " + k.getPrice() + " =  " + k.getPrice() * v)
    );
  }


  /**
   * This method is shopping products for delivery cost
   *
   * @param cart This is the first parameter to shopping cart
   * @return double delivery cost
   */
  @Override
  public double getDeliveryCost(ShoppingCartController cart) {
    DeliveryCost deliveryCost =
        new DeliveryCost(1.0, 1.0, 0.99);
    double t = deliveryCost.calculate(cart);
    System.out.println("<< Delivery Cost: " + t + "        >>");
    return t;
  }

  /**
   * This method is shopping products for total amount after discount
   *
   * @param totalPrice       This is the first parameter to total price
   * @param couponDiscount   This is the second parameter to coupon discount
   * @param campaignDiscount This is the third parameter to campaign discount
   */
  @Override
  public double getTotalAmountAfterDiscounts(double totalPrice, double couponDiscount, double campaignDiscount) {
    double t= (totalPrice - (couponDiscount + campaignDiscount));
    System.out.println("<< Discount Total Cost: " + t+ " >>");
    return t;
  }

  /**
   * This method is shopping products for shopping cart add item
   *
   * @param products This is the first parameter to products
   * @param product  This is the second parameter to product
   * @param quantity This is the third parameter to total quantity
   * @return double add item.
   */
  @Override
  public double addItem(HashMap<Product, Integer> products, Product product, int quantity) {

    if (!products.containsKey(product)) {
      products.put(product, quantity);
    } else {
      products.replace(product, products.get(product) + quantity);
    }

    double totalPrice = 0D;
    totalPrice += product.getPrice() * quantity;
    return totalPrice;

     /*

        calculateQuantitiesByCategories(product, quantity);
        totalNumberOfDeliveries = categoryQuantity.size();

         */
  }

  /**
   * This method is shopping products for calculate category
   *
   * @param product        This is the first parameter to product
   * @param quantity       This is the second parameter to quantity
   * @param categoryPrices This is the third parameter to category prices
   * @return HashMap calculate category list
   */
  @Override
  public HashMap<Category, Double> calculateCategory(Product product, int quantity, HashMap<Category, Double> categoryPrices) {
    if (!categoryPrices.containsKey(product.getCategory())) {
      categoryPrices.put(product.getCategory(), quantity * product.getPrice());
    } else {
      double newPrice = categoryPrices.get(product.getCategory()) + quantity * product.getPrice();
      categoryPrices.replace(product.getCategory(), newPrice);
    }

    return categoryPrices;
  }

  /**
   * This method is shopping products for calculate product quantity
   *
   * @param product          This is the first parameter to product
   * @param quantity         This is the second parameter to quantity
   * @param categoryQuantity This is the third parameter to category quantity
   * @return HashMap calculate category list
   */
  @Override
  public HashMap<Category, Integer> calculateQuantities(Product product, int quantity, HashMap<Category, Integer> categoryQuantity) {
    if (!categoryQuantity.containsKey(product.getCategory())) {
      categoryQuantity.put(product.getCategory(), quantity);
    } else {
      int newQuantity = categoryQuantity.get(product.getCategory()) + quantity;
      categoryQuantity.replace(product.getCategory(), newQuantity);
    }
    return categoryQuantity;
  }
}