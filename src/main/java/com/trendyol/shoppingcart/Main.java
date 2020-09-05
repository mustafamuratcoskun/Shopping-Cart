package com.trendyol.shoppingcart;


import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.model.Campaign;
import com.trendyol.shoppingcart.model.Category;
import com.trendyol.shoppingcart.model.Coupon;
import com.trendyol.shoppingcart.model.Product;
import com.trendyol.shoppingcart.shopping.ShoppingCartController;

/**
 * It is the class that Shopping Cart Application for TrendyolCase
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class Main {

  public static void main(String[] args) {

    Category food = new Category("food");
    Product apple = new Product("Apple", 100.0, food);
    Product almond = new Product("Almonds", 150.0, food);
    ShoppingCartController shoppingCart = new ShoppingCartController();
    shoppingCart.addItem(apple, 3);
    shoppingCart.addItem(almond, 2);
    Campaign campaign1 = new Campaign(food, 20.0, 3, DiscountType.RATE);
    Campaign campaign2 = new Campaign(food, 5.0, 5, DiscountType.AMOUNT);
    Coupon coupon = new Coupon(10, 5, DiscountType.RATE);
    shoppingCart.applyDiscount(campaign1, campaign2);
    shoppingCart.applyCoupon(coupon);
    shoppingCart.checkout();
  }
}