package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
  private String vendor;

  public Smartphone(int id, String name, int price, String vendor) {
    super(id, name, price);
    this.vendor = vendor;
  }

  @Override
  public boolean matches(String search) {
    if (super.matches(search)) {
      return true;
    } else {
      return getVendor().equalsIgnoreCase(search);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Smartphone)) return false;
    if (!super.equals(o)) return false;
    Smartphone that = (Smartphone) o;
    return vendor.equals(that.vendor);
  }

  public String getVendor() {
    return vendor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), vendor);
  }
}
