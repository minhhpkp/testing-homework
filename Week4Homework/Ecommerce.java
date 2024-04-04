package Week4Homework;

/**
 * A hypothetical e-commerce website.
 */
class Ecommerce {
    /**
     * Calculates the total price of items in a shopping cart, including taxes and
     * discounts.
     * 
     * Rules:
     * 1. The Items list must not be empty.
     * 2. Quantity for each item must be greater than zero.
     * 3. Unit price for each item must be greater than zero.
     * 4. Tax rate must be a non-negative value.
     * 5. Discount amount must be a non-negative value.
     * 6. Return value of total price should be rounded to the second decimal place.
     * 
     * @param cart     List of cart items, each item contains the following
     *                 information: item name, quantity, unit price.
     * @param taxRate  The tax rate in % to be applied to the total price (0 - 100).
     * @param discount The discount amount to be subtracted from the total price.
     * @return Total price of the cart.
     */
    public static double calculateTotalPrice(CartItem[] cart, double taxRate, double discount) {
        if (cart.length == 0) {
            throw new IllegalArgumentException("cart is empty");
        }
        double totalPrice = 0;
        for (CartItem item : cart) {
            totalPrice += item.unitPrice * item.quantity;
        }
        totalPrice *= 1.0 + taxRate / 100.0;
        totalPrice -= discount;
        return totalPrice;
    }

    /**
     * Run an input sample.
     * 
     * @param args
     */
    public static void main(String[] args) {
        CartItem[] cart = {
                new CartItem("item 1", 5, 20.0),
                new CartItem("item 2", 10, 30.0)
        };
        double taxRate = 5.0;
        double discount = 5.0;
        System.out.println(calculateTotalPrice(cart, taxRate, discount));
    }
}