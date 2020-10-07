package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(5, "Blackview PV9500", 220, "Blackview");

    @Test
    void matchesName() {
        boolean result = smartphone.matches("Blackview PV9500");
        assertTrue(result);
    }

    @Test
    void matchesVendor() {
        boolean result = smartphone.matches("Blackview");
        assertTrue(result);
    }

    @Test
    void matchesNone() {
        boolean result = smartphone.matches("Muzhik");
        assertFalse(result);
    }

}