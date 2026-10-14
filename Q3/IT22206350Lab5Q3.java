import java.util.Scanner;

public class IT22206350Lab5Q3 {

    public static void main(String[] args) {

        final double ROOM_CHARGE_PER_DAY = 48000.00;
        final int DISCOUNT_3_TO_4_DAYS = 10;
        final int DISCOUNT_5_OR_MORE_DAYS = 20;
        final int MIN_DAY = 1;
        final int MAX_DAY = 31;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Start Date (1-31): ");
        int startDate = input.nextInt();

        System.out.print("Enter End Date (1-31): ");
        int endDate = input.nextInt();

        // Validation 1
        if (startDate < MIN_DAY || startDate > MAX_DAY || endDate < MIN_DAY || endDate > MAX_DAY) {
            System.out.println("Error: Days must be between 1 and 31");
            return;
        }

        // Validation 2
        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            return;
        }

        int daysReserved = endDate - startDate;

        int discountRate;
        if (daysReserved >= 5) {
            discountRate = DISCOUNT_5_OR_MORE_DAYS;
        } else if (daysReserved >= 3) {
            discountRate = DISCOUNT_3_TO_4_DAYS;
        } else {
            discountRate = 0;
        }

        double totalCharge = daysReserved * ROOM_CHARGE_PER_DAY;
        double totalAmount = totalCharge - (totalCharge * discountRate / 100);

        System.out.println();
        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);
    }
}
