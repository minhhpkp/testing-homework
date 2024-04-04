package testing.homework;

public class Ecommerce {
    public static double calculateTotalPrice(CartItem[] cart, double taxRate, boolean membershipStatus) {
        double totalPrice = 0.0;

        for (CartItem item : cart) {
            totalPrice += item.unitPrice * item.quantity;
        }

        double discount = 0.0;

        // Apply discount based on total price and membership status
        if (totalPrice > 100.0 && membershipStatus) {
            discount = 0.15;
        } else if (totalPrice > 50.0) {
            if (membershipStatus)
                discount = 0.1;
            else
                discount = 0.05;
        }

        totalPrice *= 1.0 + taxRate;

        totalPrice *= 1.0 - discount;

        return Math.round(totalPrice * 100.0) / 100.0;
    }

    public static class CartItem {
        public String itemName;
        public int quantity;
        public double unitPrice;

        public CartItem(String itemName, int quantity, double unitPrice) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }
    }
}
