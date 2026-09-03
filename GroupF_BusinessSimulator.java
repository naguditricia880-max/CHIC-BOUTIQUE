import java.util.Locale;

/*
 * Group F - Chic Boutique
 * Business Object Oriented Programming - Java Fundamentals
 *
 * Discount rules for this business:
 *   Shirt      -> buy 4 or more -> 5% off the shirt line total
 *   Trousers   -> never discounted, no matter the quantity
 *   Shoes(pair)-> buy 2 or more -> flat UGX 10,000 off the shoes line total
 *   Dress      -> buy 3 or more -> 10% off the dress line total
 */
public class GroupF_BusinessSimulator {

    public static void main(String[] args) {

        // 1. Item names and prices stored in parallel arrays (same order)
        String[] names  = {"Shirt", "Trousers", "Shoes (pair)", "Dress"};
        double[] prices = {25000.00, 40000.00, 60000.00, 55000.00};

        // 3. Quantities set directly in code (matches the brief's check example:
        //    3 Shirt, 2 Trousers, 1 Shoes, 3 Dress -> should total UGX 363,500.00)
        int[] quantities = {3, 2, 1, 3};

        // 2. Display the price list using a loop reading from the arrays
        printPriceList(names, prices);

        // 4-6. Build the receipt: subtotal per item (with discount applied),
        //      then the grand total, printed as an itemised receipt
        printReceipt(names, prices, quantities);
    }

    /**
     * Method 1 of at least two required custom methods.
     * Prints the formatted price list for the boutique using a loop.
     */
    public static void printPriceList(String[] names, double[] prices) {
        System.out.println("==== CHIC BOUTIQUE ====");// header 
        for (int i = 0; i < names.length; i++) {
            System.out.printf(Locale.US, "%d. %-14sUGX %,.2f%n",// ensures to format the decmal with dots %-14s is for left alingment 
                    (i + 1), names[i], prices[i]);
        }
        System.out.println();//Prints output
    }

    /**
     * Method 2 of at least two required custom methods.
     * Works out one item's discounted subtotal (price * quantity, then
     * this item's discount rule applied if it qualifies) and returns it.
     * Also returns, via the boolean array trick below, whether a discount
     * was applied - but to keep it simple we recompute that flag in the
     * receipt loop using the same rule, so each item's logic lives in
     * exactly one place: here.
     */
    public static double calculateDiscountedSubtotal(String itemName, double price, int qty) {
        double subtotal = price * qty;

        if (itemName.equalsIgnoreCase("Shirt")) {
            if (qty >= 4) {
                subtotal = subtotal - (subtotal * 0.05); // if a customer buys 4 or more items they get a 5% off
            }
        } else if (itemName.equalsIgnoreCase("Trousers")) {
            // No deal, ever - subtotal stays as price * qty
        } else if (itemName.equalsIgnoreCase("Shoes (pair)")) {
            if (qty >= 2) {
                subtotal = subtotal - 10000.00; // flat UGX 10,000 off
            }
        } else if (itemName.equalsIgnoreCase("Dress")) {
            if (qty >= 3) {
                subtotal = subtotal - (subtotal * 0.10); // 10% off
            }
        }

        return subtotal;
    }

    /**
     * Small helper so the receipt-printing loop can say in words whether
     * a discount applied to this line, without repeating the discount
     * maths itself.
     */
    public static boolean discountApplies(String itemName, int qty) {// the boolean  returns true or false whether the discount applies or not and the receipt will have discount applied or discount not applied 
        if (itemName.equalsIgnoreCase("Shirt")) {
            return qty >= 4;
        } else if (itemName.equals("Trousers")) {
            return false;
        } else if (itemName.equals("Shoes (pair)")) {
            return qty >= 2;
        } else if (itemName.equals("Dress")) {
            return qty >= 3;
        }
        return false;
    }

    /**
     * Prints the itemised receipt: one line per item (qty, subtotal,
     * whether discounted), then the grand total. Uses a loop to build
     * each line and calls calculateDiscountedSubtotal() to get the value.
     */
    public static void printReceipt(String[] names, double[] prices, int[] quantities) {
        System.out.println("==== RECEIPT ====");

        double grandTotal = 0.0;

        for (int i = 0; i < names.length; i++) {
            double subtotal = calculateDiscountedSubtotal(names[i], prices[i], quantities[i]);
            grandTotal += subtotal;

            String discountNote = discountApplies(names[i], quantities[i])
                    ? "(discount applied)"
                    : "(no discount)";

            System.out.printf(Locale.US, "%-14sx%-3d = UGX %,10.2f   %s%n",
                    names[i], quantities[i], subtotal, discountNote);
        }

        System.out.println("----------------------------------------------------");
        System.out.printf(Locale.US, "TOTAL              = UGX %,10.2f%n", grandTotal);
    }
}