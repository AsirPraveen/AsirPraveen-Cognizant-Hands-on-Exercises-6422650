import java.util.HashMap;

public class FinancialForecasting {

    private static HashMap<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public static double calculateFutureValueMemoized(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        int key = years;
        if (memo.containsKey(key)) {
            return memo.get(key) * presentValue;
        }
        double result = calculateFutureValueMemoized(presentValue, rate, years - 1) * (1 + rate);
        memo.put(years, result / presentValue);
        return result;
    }

    public static double calculateFutureValueIterative(double presentValue, double rate, int years) {
        double result = presentValue;
        for (int i = 0; i < years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    public static void main(String[] args) {
        
        double[] presentValues = {10000, 5000};
        double[] rates = {0.07, 0.05};
        int[] years = {10, 15};

        for (int i = 0; i < presentValues.length; i++) {
            double pv = presentValues[i];
            double rate = rates[i];
            int yrs = years[i];

            System.out.printf("\nTest Case %d: Present Value = Rs. %.2f, Rate = %.2f%%, Years = %d%n", 
                i + 1, pv, rate * 100, yrs);

            // Recursive
            long startTime = System.nanoTime();
            double recursiveResult = calculateFutureValue(pv, rate, yrs);
            long endTime = System.nanoTime();
            System.out.printf("Recursive Forecast: Rs. %.2f (Time: %d ns)%n", 
                recursiveResult, endTime - startTime);

            // Memoized Recursive
            memo.clear();
            startTime = System.nanoTime();
            double memoizedResult = calculateFutureValueMemoized(pv, rate, yrs);
            endTime = System.nanoTime();
            System.out.printf("Memoized Recursive Forecast: Rs. %.2f (Time: %d ns)%n", 
                memoizedResult, endTime - startTime);

            // Iterative
            startTime = System.nanoTime();
            double iterativeResult = calculateFutureValueIterative(pv, rate, yrs);
            endTime = System.nanoTime();
            System.out.printf("Iterative Forecast: Rs. %.2f (Time: %d ns)%n", 
                iterativeResult, endTime - startTime);
        }
    }
}