package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book item1 = new Book(1, "Lord of the Rings", 2000, "John R R Tolkien");
    private Book item2 = new Book(2, "Harry Potter", 1000, "Joanne Rowling");
    private Book item3 = new Book(3, "dot com testing", 800, "Roman Savin");
    private Book item8 = new Book(8, "", 800, "");
    private Smartphone item4 = new Smartphone(4, "Honor", 4000, "Chine");
    private Smartphone item5 = new Smartphone(5, "Samsung", 2500, "Korea");
    private Smartphone item6 = new Smartphone(6, "Nokia", 10000, "Finland");
    private Smartphone item7 = new Smartphone(7, "xiaomi", 6000, "Finland");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
    }

    @Test
    public void shouldName() {
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = new Product[]{item2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAuthor() {
        Product[] actual = manager.searchBy("Roman Savin");
        Product[] expected = new Product[]{item3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldManufacturer() {
        Product[] actual = manager.searchBy("Korea");
        Product[] expected = new Product[]{item5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldForTwoManufacturer() {
        Product[] actual = manager.searchBy("Finland");
        Product[] expected = new Product[]{item6, item7};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSampleEmptySet() {
        Product[] actual = manager.searchBy("Null");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}