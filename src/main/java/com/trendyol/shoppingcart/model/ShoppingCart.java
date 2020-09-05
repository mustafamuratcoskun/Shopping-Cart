package com.trendyol.shoppingcart.model;

import java.util.HashMap;

/**
 * It is the class that Shopping Cart entity.
 *
 * @author Hasan Burak KUTBAY
 * @version 1.0
 * @since 2020-09-04
 */
public class ShoppingCart {

  private HashMap<Product, Integer> products;
  private HashMap<Category, Integer> categoryQuantity;
  private HashMap<Category, Double> categoryPrices;

  private double totalPrice;

  private double couponDiscount;
  private double campaignDiscount;

  private int totalProducts;
  private int totalDeliveries;

  public ShoppingCart() {
    products = new HashMap<>();
    categoryQuantity = new HashMap<>();
    categoryPrices = new HashMap<>();
    totalPrice = 0D;
    totalProducts = 0;
    totalDeliveries = 0;
    couponDiscount = 0D;
  }

  /**
   * This method is constructor method and discount value set discountCalculator method
   *
   * @param products         This is the first parameter to products
   * @param categoryQuantity This is the second parameter to category quantity
   * @param categoryPrices   This is the third parameter to category prices
   * @param totalPrice       This is the fourth parameter to total price
   * @param couponDiscount   This is the fifth parameter to coupon discount
   * @param campaignDiscount This is the sixth parameter to campaign discount
   * @param totalProducts    This is the seventh parameter to total products
   * @param totalDeliveries  This is the first parameter to total deliveries
   */
  public ShoppingCart(HashMap<Product, Integer> products, HashMap<Category, Integer> categoryQuantity, HashMap<Category, Double> categoryPrices, double totalPrice, double couponDiscount, double campaignDiscount, int totalProducts, int totalDeliveries) {
    this.products = products;
    this.categoryQuantity = categoryQuantity;
    this.categoryPrices = categoryPrices;
    this.totalPrice = totalPrice;
    this.couponDiscount = couponDiscount;
    this.campaignDiscount = campaignDiscount;
    this.totalProducts = totalProducts;
    this.totalDeliveries = totalDeliveries;
  }

  /**
   * This method is getter value for products value
   *
   * @return HashMap products
   */
  public HashMap<Product, Integer> getProducts() {
    return products;
  }

  public void setProducts(HashMap<Product, Integer> products) {
    this.products = products;
  }

  /**
   * This method is getter value for category Quantity value
   *
   * @return HashMap category Quantity
   */
  public HashMap<Category, Integer> getCategoryQuantity() {
    return categoryQuantity;
  }

  public void setCategoryQuantity(HashMap<Category, Integer> categoryQuantity) {
    this.categoryQuantity = categoryQuantity;
  }

  /**
   * This method is getter value for category prices value
   *
   * @return HashMap category prices
   */
  public HashMap<Category, Double> getCategoryPrices() {
    return categoryPrices;
  }

  public void setCategoryPrices(HashMap<Category, Double> categoryPrices) {
    this.categoryPrices = categoryPrices;
  }

  /**
   * This method is getter value for total price value
   *
   * @return double total price
   */
  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  /**
   * This method is getter value for coupon discount value
   *
   * @return double coupon discount
   */
  public double getCouponDiscount() {
    return couponDiscount;
  }

  public void setCouponDiscount(double couponDiscount) {
    this.couponDiscount = couponDiscount;
  }

  /**
   * This method is getter value for campaigns discount value
   *
   * @return double campaing discount
   */
  public double getCampaignDiscount() {
    return campaignDiscount;
  }

  /**
   * This method is getter value for  total products value
   */
  public int getTotalProducts() {
    return totalProducts;
  }

  public void setTotalProducts(int totalProducts) {
    this.totalProducts = totalProducts;
  }

  /**
   * This method is getter value for minimum purchase value
   *
   * @return int total Deliveries
   */
  public int getTotalDeliveries() {
    return totalDeliveries;
  }

  public void setTotalDeliveries(int totalDeliveries) {
    this.totalDeliveries = totalDeliveries;
  }
}
