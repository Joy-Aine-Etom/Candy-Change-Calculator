import java.util.Scanner;

public class CandyChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the number of data sets
        int n = scanner.nextInt();

        // array to store the results
        int[] results = new int[n];

        // loop through each data set
        for (int i = 0; i < n; i++) {
            // read the amount of change to make
            int change = scanner.nextInt();

            // read the number of coins available for each denomination
            int tenPesoCoins = scanner.nextInt();
            int fivePesoCoins = scanner.nextInt();
            int onePesoCoins = scanner.nextInt();
            int twentyfiveCentavoCoins = scanner.nextInt();

            // initialize the number of candies to zero
            int candies = 0;

            // check if there are enough 10-peso coins to cover the change
            if (change >= 10 && tenPesoCoins > 0) {
                // calculate the maximum number of 10-peso coins that can be used
                int maxTen = Math.min(change / 10, tenPesoCoins);
                // subtract the value of the 10-peso coins from the change
                change -= maxTen * 10;
            }

            // check if there are enough 5-peso coins to cover the change
            if (change >= 5 && fivePesoCoins > 0) {
                // calculate the maximum number of 5-peso coins that can be used
                int maxFive = Math.min(change / 5, fivePesoCoins);
                // subtract the value of the 5-peso coins from the change
                change -= maxFive * 5;
            }

            // check if there are enough 1-peso coins to cover the change
            if (change >= 1 && onePesoCoins > 0) {
                // calculate the maximum number of 1-peso coins that can be used
                int maxOne = Math.min(change, onePesoCoins);
                // subtract the value of the 1-peso coins from the change
                change -= maxOne;
            }

            // check if there are enough 25-centavo coins to cover the change
            if (change > 0 && twentyfiveCentavoCoins > 0) {
                // calculate the maximum number of 25-centavo coins that can be used
                int maxQuarter = Math.min(change * 4, twentyfiveCentavoCoins);
                // subtract the value of the 25-centavo coins from the change
                change -= maxQuarter * 1/4;
            }

            // if the available coins cannot make up the exact amount
            if (change > 0) {
                // calculate the number of candies needed to cover the change
                candies = (int) Math.ceil(change);
            }

            results[i] = candies;
        }

        for (int i = 0; i < n; i++) {
            if (results[i] == 0) {
                System.out.println("none");
            } else {
                System.out.println(results[i]);
            }
        }

        scanner.close();
    }
}













