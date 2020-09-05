package com.trendyol.shoppingcart.shopping;

import com.trendyol.shoppingcart.coupon.CouponDiscountService;
import com.trendyol.shoppingcart.discount.DiscountCalculatorService;
import com.trendyol.shoppingcart.model.Campaign;
import com.trendyol.shoppingcart.model.Coupon;
import com.trendyol.shoppingcart.model.Product;
import com.trendyol.shoppingcart.model.ShoppingCart;

/**
 * It is the class that Shopping Cart Controller
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class ShoppingCartController {
  private final ShoppingCart shoppingCartDto;

  private DiscountCalculatorService discountCalculatorService;
  private CouponDiscountService couponDiscountService;
  private ShoppingCartService shoppingCartService;


  public ShoppingCartController() {

    shoppingCartDto = new ShoppingCart();
    shoppingCartDto.setTotalPrice(0D);
    shoppingCartDto.setCouponDiscount(0D);
    shoppingCartDto.setTotalProducts(0);
    shoppingCartDto.setTotalDeliveries(0);

    initService();
  }

  /**
   * This method is initialize services
   */
  public void initService() {
    shoppingCartService = new ShoppingCartService();
    discountCalculatorService = new DiscountCalculatorService();
    couponDiscountService = new CouponDiscountService();
  }

  /**
   * This method is shopping products for shopping cart add item
   *
   * @param product  This is the first parameter to product
   * @param quantity This is the second parameter to total quantity
   */
  public void addItem(Product product, int quantity) {

    shoppingCartDto.setTotalPrice(shoppingCartService.addItem(shoppingCartDto.getProducts(), product, quantity));
    shoppingCartDto.setTotalProducts(shoppingCartDto.getProducts().size());
    shoppingCartDto.setCategoryPrices(shoppingCartService.calculateCategory(product, quantity, shoppingCartDto.getCategoryPrices()));
    shoppingCartDto.setCategoryQuantity(shoppingCartService.calculateQuantities(product, quantity, shoppingCartDto.getCategoryQuantity()));
    shoppingCartDto.setTotalDeliveries(shoppingCartDto.getCategoryQuantity().size());
  }

  /**
   * This method is apply discount for campaigns
   *
   * @param campaigns This is the first parameter to campaigns
   * @return double discount calculate service value
   */
  public double applyDiscount(Campaign... campaigns) {
    return discountCalculatorService.applyDiscount(shoppingCartDto.getCategoryQuantity(), shoppingCartDto.getCategoryPrices(), campaigns);
  }

  /**
   * This method is apply coupon  for shopping cart
   *
   * @param coupon This is the first parameter to coupon
   * @return double coupon discount
   */
  public double applyCoupon(Coupon coupon) {
    shoppingCartDto.setCouponDiscount(couponDiscountService.applyCoupon(coupon, shoppingCartDto.getCampaignDiscount(), shoppingCartDto.getTotalPrice()));

    return shoppingCartDto.getCouponDiscount();
  }

  /**
   * This method is apply coupon  for delivery cost
   *
   * @return double shopping delivery cost
   */
  public double deliveryCost() {
    return shoppingCartService.getDeliveryCost(this);
  }

  /**
   * This method is apply coupon  for  shopping cart checkout
   */
  public void checkout() {
    shoppingCartService.checkout(shoppingCartDto.getProducts());
    shoppingCartService.getDeliveryCost(this);
    shoppingCartService.getTotalAmountAfterDiscounts(shoppingCartDto.getTotalPrice(), shoppingCartDto.getCouponDiscount(), shoppingCartDto.getCampaignDiscount());
  }

  /**
   * This method is apply coupon  for total amount after discount
   *
   * @return double total amount after discount
   */
  public double getTotalAmountAfterDiscounts() {
    return shoppingCartDto.getTotalPrice() - (shoppingCartDto.getCouponDiscount() + shoppingCartDto.getCampaignDiscount());
  }

  /**
   * This method is getter value for shopping cart services
   *
   * @return ShoppingCartService
   */
  public ShoppingCartService getShoppingCartService() {
    return shoppingCartService;
  }

  /**
   * This method is getter value for shopping cart data transfer object
   *
   * @return ShoppingCart
   */
  public ShoppingCart getShoppingCartDto() {
    return shoppingCartDto;
  }
}