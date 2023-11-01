package shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setTitle("apple");
        product1.setCost(10);

        Product product2 = new Product();
        product2.setTitle("peach");
        product2.setCost(9);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        Shop shop = new Shop();
        shop.setProducts(productList);

        quantityOfProducts(shop);
        conformityOfProducts(shop);
        getMostExpensiveProduct(shop);
        sortProductsByPrice(shop);


    }

    public static void quantityOfProducts(Shop shop) {
        assertThat(shop.getProducts().size()).isEqualTo(2);
    }

    public static void conformityOfProducts(Shop shop) {
        for (Product p: shop.getProducts()) {
            assertThat(p.getTitle()).containsAnyOf("apple", "peach");
        }
    }

    public static void getMostExpensiveProduct(Shop shop) {
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(10);
    }

    public static void sortProductsByPrice(Shop shop) {
        List<Product> products = shop.getProducts();
        products.sort(Comparator.comparing(Product::getCost));
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).isEqualTo(products);
    }
}