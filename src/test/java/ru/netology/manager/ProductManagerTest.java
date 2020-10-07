package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Book first = new Book(1, "Война и мир", 100, "Толстой", 2000, 1850);
    Book second = new Book(2, "Код Да Винчи", 200, "Ден Браун", 500, 2000);
    Book third = new Book(3, "Вино из одуванчиков", 300, "Рэй Бредбери", 200, 1970);
    Book fourth = new Book(4, "Цифровая крепость", 400, "Ден Браун", 300, 1913);

    Smartphone firstSmart = new Smartphone(4, "Nokia 6.1", 300, "Nokia");
    Smartphone secondSmart = new Smartphone(5, "Blackview PV9500", 220, "Blackview");
    Smartphone thirdSmart = new Smartphone(6, "iPhone 7 Plus", 600, "Apple");

    @Test
    void searchBy() {
        ProductRepository repository = new ProductRepository();
        repository.saveAll(first, second, third, fourth, firstSmart, secondSmart, thirdSmart);
        ProductManager productManager = new ProductManager(repository);

        Product[] result = productManager.searchBy("Sasha");
        assertArrayEquals(new Product[0], result);

        result = productManager.searchBy("Apple");
        assertArrayEquals(new Product[]{thirdSmart}, result);

        result = productManager.searchBy("Ден Браун");
        assertArrayEquals(new Product[]{second, fourth}, result);

    }

    @Test
    void save() {
    }

    @Test
    void matches() {
    }
}