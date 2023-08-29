import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(01, "Мыло", 123);
        Product product2 = new Product(02, "Карандаш", 66);
        Product product3 = new Product(03, "Жевачка", 12);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(02);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(01, "Мыло", 123);
        Product product2 = new Product(02, "Карандаш", 66);
        Product product3 = new Product(03, "Жевачка", 12);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(23)
        );
    }

}