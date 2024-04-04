package Week4Homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculateTotalPriceTest {

    @Test
    public void normInput() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                1158.75,
                Ecommerce.calculateTotalPrice(cart, 50, 5.45),
                0.001);
    }

    @Test
    public void emptyCartShouldThrowIllegalArgumentException() {
        CartItem[] cart = new CartItem[0];
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45));
    }

    @Test
    public void cartContainingOneItem() {
        CartItem[] cart = {
                new CartItem("item 1", 50, 25.99)
        };
        assertEquals(1943.8, Ecommerce.calculateTotalPrice(cart, 50, 5.45), 0.001);
    }

    @Test
    public void negativeQuantityShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", -10, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45));
    }

    @Test
    public void zeroQuantityShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 0, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45));
    }

    @Test
    public void positiveBoundaryQuantity() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99),
                new CartItem("item 3", 1, 49.99)
        };
        assertEquals(
                1233.73,
                Ecommerce.calculateTotalPrice(cart, 50, 5.45),
                0.001);
    }

    @Test
    public void negativeUnitPriceShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, -0.01)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45));
    }

    @Test
    public void zeroUnitPriceShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 0.0),
                new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45));
    }

    @Test
    public void positiveBoundaryUnitPrice() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 0.01)
        };
        assertEquals(
                259.11,
                Ecommerce.calculateTotalPrice(cart, 50, 5.45),
                0.001);
    }

    @Test
    public void negativeTaxRateShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, -0.1, 5.45));
    }

    @Test
    public void zeroTaxRate() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                770.68,
                Ecommerce.calculateTotalPrice(cart, 0, 5.45),
                0.001);
    }

    @Test
    public void lowerNearBoundaryTaxRate() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                771.46,
                Ecommerce.calculateTotalPrice(cart, 0.1, 5.45),
                0.001);
    }

    @Test
    public void upperNearBoundaryTaxRate() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                1546.03,
                Ecommerce.calculateTotalPrice(cart, 99.9, 5.45),
                0.001);
    }

    @Test
    public void upperBoundaryTaxRate() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                1546.81,
                Ecommerce.calculateTotalPrice(cart, 100.0, 5.45),
                0.001);
    }

    @Test
    public void overUpperBoundaryTaxRateShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 100.1, 5.45));
    }

    @Test
    public void negativeDiscountShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Ecommerce.calculateTotalPrice(cart, 50, -0.01));
    }

    @Test
    public void zeroDiscount() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                1164.2,
                Ecommerce.calculateTotalPrice(cart, 50, 0),
                0.001);
    }

    @Test
    public void positiveBoundaryDiscount() {
        CartItem[] cart = {
                new CartItem("item 1", 5, 35.25),
                new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
                1164.19,
                Ecommerce.calculateTotalPrice(cart, 50, 0.01),
                0.001);
    }
}
