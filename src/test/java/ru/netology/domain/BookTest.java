package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
    private Book book = new Book(1, "Война и мир", 100, "Толстой", 2000, 1850);

    @Test
    void matchesName() {
        boolean result = book.matches("Война и мир");
        assertTrue(result);
    }

    @Test
    void matchesAuthor() {
        boolean result = book.matches("Толстой");
        assertTrue(result);
    }

    @Test
    void matchesNone() {
        boolean result = book.matches("Muzh");
        assertFalse(result);
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }

    @Test
    public void shouldNotCastToDifferentClass() {
        Product product = new Book();
        Assertions.assertThrows(ClassCastException.class, () -> {
            Smartphone shirt = (Smartphone) product;
        });
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }


}
