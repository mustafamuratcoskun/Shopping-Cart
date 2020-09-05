import com.trendyol.shoppingcart.delivery.DeliveryCost;
import com.trendyol.shoppingcart.discount.DiscountCalculatorService;
import com.trendyol.shoppingcart.enums.DiscountType;
import com.trendyol.shoppingcart.exception.InvalidException;
import com.trendyol.shoppingcart.model.Campaign;
import com.trendyol.shoppingcart.model.Category;
import com.trendyol.shoppingcart.model.Coupon;
import com.trendyol.shoppingcart.model.Product;
import com.trendyol.shoppingcart.shopping.ShoppingCartController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


public class ShoppingCartTest {

  Category food;
  Product apple, almond;
  ShoppingCartController cart;
  Campaign campaign1, campaign2;
  Coupon coupon;

  @Before
  public void init() {

    food = new Category("food");

    apple = new Product("Apple", 100.0, food);
    almond = new Product("Almonds", 150.0, food);

    cart = new ShoppingCartController();

    cart.addItem(apple, 3);
    cart.addItem(almond, 1);

    campaign1 = new Campaign(food, 20.0, 3, DiscountType.RATE);
    campaign2 = new Campaign(food, 5.0, 5, DiscountType.AMOUNT);

    coupon = new Coupon(100, 10, DiscountType.RATE);
  }

  @Test
  public void addItem() {
    HashMap<Product, Integer> products = new HashMap<>();
    products.put(apple, 3);
    products.put(almond, 1);


    assertEquals(products, cart.getShoppingCartDto().getProducts());
  }

  @Test
  public void applyDiscount() {
    cart.applyDiscount(campaign1, campaign2);
    assertEquals("15.0", String.valueOf(cart.applyCoupon(coupon)));
  }

  @Test
  public void totalPrice() {
    assertEquals("150.0", String.valueOf(cart.getShoppingCartDto().getTotalPrice()));
  }

  @Test
  public void applyCoupon() {
    cart.applyCoupon(coupon);

    assertEquals("15.0", String.valueOf(cart.getShoppingCartDto().getCouponDiscount()));
  }

  @Test
  public void totalAmountAfterDiscount() {
    cart.applyDiscount(campaign1, campaign2);
    cart.applyCoupon(coupon);
    assertEquals("135.0", String.valueOf(cart.getTotalAmountAfterDiscounts()));
  }

  @Test
  public void couponDiscount() {
    cart.applyCoupon(coupon);
    assertEquals("15.0", String.valueOf(cart.getShoppingCartDto().getCouponDiscount()));
  }

  @Test
  public void campaignDiscount() {

    assertEquals("90.0", String.valueOf(cart.applyDiscount(campaign1, campaign2)));
  }

  @Test
  public void deliveryCost() {
    assertEquals("3.99", String.valueOf((float) cart.deliveryCost()));
  }

  @Test
  public void shoppingCartServiceCall() {
    assertNotNull(cart.getShoppingCartService());
  }

  @Test
  public void discountCostCalculateRate() {
    DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();
    assertEquals("1.0", String.valueOf(discountCalculatorService.discount(100, DiscountType.RATE)));
  }


  @Test
  public void invalidProductPrice() {

    assertThrows(InvalidException.class, () -> {
      apple=new Product("Apple", -21.0, food);
      ;
    });
  }
  @Test
  public void discountCostTypeAmount() {
    DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();
    assertEquals("100.0", String.valueOf(discountCalculatorService.discount(100, DiscountType.AMOUNT)));
  }

  @Test
  public void nullShoppingCartException() {

    assertThrows(NullPointerException.class, () -> {
      cart.addItem(null, 1);
    });
  }

  @Test
  public void invalidDeliveryInvalidException() {
  DeliveryCost deliveryCost =
        new DeliveryCost(-1.0, -1.0, -0.99);

    assertThrows(InvalidException.class, () -> {
      deliveryCost.calculate(cart);
      ;
    });
  }



  @Test
  public void discountTotalAmoutnAfterDiscounts(){
    cart.addItem(almond, 1);
    cart.addItem(apple, 3);

    Campaign campaign1 = new Campaign(food, 20.0, 1, DiscountType.RATE);
    Campaign campaign2 = new Campaign(food, 20.0, 1, DiscountType.RATE);
    Campaign campaign3 = new Campaign(food, 20.0, 1, DiscountType.RATE);

    cart.applyDiscount(campaign1,campaign2,campaign3);

    assertEquals("300.0",String.valueOf(cart.getShoppingCartService().getTotalAmountAfterDiscounts(cart.getShoppingCartDto().getTotalPrice(), cart.getShoppingCartDto().getCouponDiscount(),cart.getShoppingCartDto().getCampaignDiscount())));
  }

  @Test
  public void deliverySuccesfullCalculate() {
    cart.addItem(almond, 1);
    cart.addItem(apple, 3);

    DeliveryCost deliveryCost =
        new DeliveryCost(1.0, 1.0, 0.99);

    assertEquals("3.99",String.valueOf(deliveryCost.calculate(cart)));
  }

}