import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculateTotalPriceBoundaryValueTest {
    
    @Test
    public void normInput() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 1.5 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 50, 5.45), 
            0.001
        );
    }

    @Test
    public void emptyCartShouldThrowIllegalArgumentException() {
        CartItem[] cart = new CartItem[0];
        assertThrows(
            IllegalArgumentException.class, 
            () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45)
        );
    }

    @Test
    public void cartContainingOneItem() {
        CartItem[] cart = {
            new CartItem("item 1", 50, 25.99)
        };
        assertEquals(50 * 25.99 * 1.5 - 5.45, Ecommerce.calculateTotalPrice(cart, 50, 5.45), 0.001);
    }

    @Test
    public void negativeQuantityShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", -10, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45)
        );
    }

    @Test
    public void zeroQuantityShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 0, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45)
        );
    }

    @Test
    public void positiveBoundaryQuantity() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99),
            new CartItem("item 3", 1, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 13 * 49.99) * 1.5 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 50, 5.45), 
            0.001
        );
    }

    @Test
    public void negativeUnitPriceShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, -0.01)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45)
        );
    }

    @Test
    public void zeroUnitPriceShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 0.0),
            new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 50, 5.45)
        );
    }

    @Test
    public void positiveBoundaryUnitPrice() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 0.01)
        };
        assertEquals(
            (5 * 35.25 + 12 * 0.01) * 1.5 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 50, 5.45), 
            0.001
        );
    }

    @Test
    public void negativeTaxRateShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, -0.1, 5.45)
        );
    }

    @Test
    public void zeroTaxRate() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            5 * 35.25 + 12 * 49.99 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 0, 5.45), 
            0.001
        );
    }

    @Test
    public void lowerNearBoundaryTaxRate() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 1.001 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 0.1, 5.45), 
            0.001
        );
    }

    @Test
    public void upperNearBoundaryTaxRate() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 1.999 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 99.9, 5.45), 
            0.001
        );
    }

    @Test
    public void upperBoundaryTaxRate() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 2 - 5.45,
            Ecommerce.calculateTotalPrice(cart, 100.0, 5.45), 
            0.001
        );
    }

    @Test
    public void overUpperBoundaryTaxRateShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 100.1, 5.45)
        );
    }

    @Test
    public void negativeDiscountShouldThrowIllegalArgumentException() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertThrows(
            IllegalArgumentException.class,
            () -> Ecommerce.calculateTotalPrice(cart, 50, -0.01)
        );
    }

    @Test
    public void zeroDiscount() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 1.5,
            Ecommerce.calculateTotalPrice(cart, 50, 0), 
            0.001
        );
    }

    @Test
    public void positiveBoundaryDiscount() {
        CartItem[] cart = {
            new CartItem("item 1", 5, 35.25),
            new CartItem("item 2", 12, 49.99)
        };
        assertEquals(
            (5 * 35.25 + 12 * 49.99) * 1.5 - 0.01,
            Ecommerce.calculateTotalPrice(cart, 50, 0.01), 
            0.001
        );
    }
}
