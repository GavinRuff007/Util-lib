package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MobileValidatorTest {

    @Test
    public void testIsValidMobileNumber() {
        assertTrue(MobileValidator.isValidMobileNumber("1234567890"));
        assertTrue(MobileValidator.isValidMobileNumber("9876543210"));
        assertFalse(MobileValidator.isValidMobileNumber("12345"));
        assertFalse(MobileValidator.isValidMobileNumber("abcdefghij"));
        assertFalse(MobileValidator.isValidMobileNumber("987654321"));
    }

    @Test
    public void testNormalizeMobileNumber() {
        assertEquals("1234567890", MobileValidator.normalizeMobileNumber("123-456-7890"));
        assertEquals("9876543210", MobileValidator.normalizeMobileNumber("(987) 654-3210"));
        assertEquals("12345", MobileValidator.normalizeMobileNumber("12a34b5"));
        assertEquals("", MobileValidator.normalizeMobileNumber(""));
    }

    @Test
    public void testFormatMobileNumber() {
        assertEquals("123-456-7890", MobileValidator.formatMobileNumber("1234567890"));
        assertEquals("987-654-3210", MobileValidator.formatMobileNumber("9876543210"));
        assertEquals("123-456-7890", MobileValidator.formatMobileNumber("(123) 456-7890"));
        assertEquals("123-456-7890", MobileValidator.formatMobileNumber("12a34b5678c90"));
        assertEquals("", MobileValidator.formatMobileNumber(""));
    }

    @Test
    public void testStartsWithPrefix() {
        assertTrue(MobileValidator.startsWithPrefix("1234567890", "123"));
        assertTrue(MobileValidator.startsWithPrefix("9876543210", "987"));
        assertFalse(MobileValidator.startsWithPrefix("1234567890", "456"));
        assertFalse(MobileValidator.startsWithPrefix("", "123"));
    }
}
