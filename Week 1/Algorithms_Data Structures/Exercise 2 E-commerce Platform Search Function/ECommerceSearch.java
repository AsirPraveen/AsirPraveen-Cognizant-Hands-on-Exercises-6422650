import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Keyboard", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(105, "Shoes", "Footwear"),
            new Product(102, "Mouse", "Electronics"),
            new Product(104, "T-shirt", "Clothing")
        };

        int targetIdFound = 105; // Product exists
        int targetIdNotFound = 106; // Product does not exist

        // Linear Search
        System.out.println("Linear Search (Unsorted Array):");
        long startTimeLinear = System.nanoTime();
        Product foundLinear = linearSearch(products, targetIdFound);
        long endTimeLinear = System.nanoTime();
        System.out.println("Target ID: " + targetIdFound + " -> " + 
            (foundLinear != null ? foundLinear : "Product not found"));
        System.out.println("Time taken: " + (endTimeLinear - startTimeLinear) + " ns");

        foundLinear = linearSearch(products, targetIdNotFound);
        System.out.println("Target ID: " + targetIdNotFound + " -> " + 
            (foundLinear != null ? foundLinear : "Product not found"));
        System.out.println();

        // Binary Search (requires sorted array)
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(p -> p.productId));
        System.out.println("Binary Search (Sorted Array):");
        System.out.println("Sorted Products:");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }

        long startTimeBinary = System.nanoTime();
        Product foundBinary = binarySearch(sortedProducts, targetIdFound);
        long endTimeBinary = System.nanoTime();
        System.out.println("\nTarget ID: " + targetIdFound + " -> " + 
            (foundBinary != null ? foundBinary : "Product not found"));
        System.out.println("Time taken: " + (endTimeBinary - startTimeBinary) + " ns");

        foundBinary = binarySearch(sortedProducts, targetIdNotFound);
        System.out.println("Target ID: " + targetIdNotFound + " -> " + 
            (foundBinary != null ? foundBinary : "Product not found"));
    }
}