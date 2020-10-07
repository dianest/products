package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
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
