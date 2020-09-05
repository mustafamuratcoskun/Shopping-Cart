# Trendyol Shopping Cart

Codility sitesindeki 2 numaralı görev seçilmiştir. 

## Proje Tasarımı

Proje S.O.L.I.D prensipleri göz önünde bulundurularak yazıldı. "Observer Design Pattern" ve "Singleton Design Pattern" kullanıldı. Proje Yapısı Model, View, Controller and Service şeklinde tasarlandı. Metodların yönetimi için interfaceler oluşturuldu.

- İndirimler sepete uygulandı.
- Müşterinin kuponu uygulandı.
- Taşıma maliyeti hesaplandı.
- Kampanyalar ürün kategorilerinin hepsine uygulandı. 
- Kupon indirimleri eğer kampanya  varsa kampanya indirimi uygulandıktan sonra aktif olacak şekilde tasarlandı.
- Ürün sayısı ve minimum tutar kontrolleri yapıldı.
- İndirim oranlarının nasıl olacağı ve takibi yapılmıştır.

## Test Driven Development

Proje test edilebilir şekilde yazılmıştır. `ShoppingCartTest.java` Test sınıfıdır. Mockito kullanmaya ihtiyaç duyulmamıştır. JUnit kullanılarak birim testler yazılmıştır.

16/16 Test geçmiştir.


- ShoppingCartTest.discountCostTypeAmount
- ShoppingCartTest.shoppingCartServiceCall
- ShoppingCartTest.addItem
- ShoppingCartTest.discountTotalAmoutnAfterDiscounts
- ShoppingCartTest.discountCostCalculateRate
- ShoppingCartTest.nullShoppingCartException
- ShoppingCartTest.totalPrice
- ShoppingCartTest.campaignDiscount
- ShoppingCartTest.deliverySuccesfullCalculate
- ShoppingCartTest.applyDiscount
- ShoppingCartTest.couponDiscount
- ShoppingCartTest.deliveryCost
- ShoppingCartTest.totalAmountAfterDiscount
- ShoppingCartTest.invalidDeliveryInvalidException
- ShoppingCartTest.applyCoupon
- ShoppingCartTest.invalidProductPrice

## Kod Kalite Ölçümü (Code Coverage)

Kod kalitesi ölçülmüştür.

| Package     | Class, %       | Method, %      | Line, %          |
|-------------|----------------|----------------|------------------|
| all classes | 91,7% (11/ 12) | 67,1% (55/ 82) | 63,3% (162/ 256) |

Metod bazında iyileştirmeler yapılmıştır.

Daha detaylı olarak  sınıf ve metod bazlı ölçüm oranları linktedir.  https://www.burakkutbay.com/shoppingcart/codecoverage/

Kaynak kodlara  ise: **/Codecoverage/Javadoc** klasöründen ulaşabilirsiniz.

## Proje Dokümantasyonu (JavaDoc)

Proje içerisinde metod ve değişken açıklamaları yorum satırları kullanılarak JavaDoc stilinde ayrıntılı olarak yazılmıştır.

Proje dokümantasyonu sayfası için  (JavaDoc): https://www.burakkutbay.com/shoppingcart/javadoc/

Kaynak kodlara ise: **/resources/Javadoc** klasöründen ulaşabilirsiniz.

## Derleme & Çalıştırma

- Proje Java 11'de yazılmıştır.
- Maven projesidir.