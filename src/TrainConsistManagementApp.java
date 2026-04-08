import java.util.*;

public class TrainConsistManagementApp {
    // ===== UC16: Bubble Sort Logic =====
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped) break;
        }
    }

    // ===== CUSTOM EXCEPTION =====
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ===== Passenger Bogie =====
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("=========================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));

            // Invalid example
            bogies.add(new PassengerBogie("First Class", 0)); // throws exception

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nValid Bogies:");
        for (PassengerBogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC14 execution completed...");

        // ===== UC16 EXECUTION =====
        System.out.println("\n=========================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("=========================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

// Call sorting
        bubbleSort(capacities);

        System.out.println("\n\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
        // ===== UC17 EXECUTION =====
        System.out.println("\n=========================================");
        System.out.println(" UC17 - Sorting Bogie Names using Arrays.sort() ");
        System.out.println("=========================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

// Sorting using built-in method
        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");

        // ===== UC18 EXECUTION =====
        System.out.println("\n=========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("=========================================\n");

//        //String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
//        String searchId = "BG309";
//
//        System.out.println("Available Bogie IDs:");
//        for (String id : bogieIds) {
//            System.out.println(id);
//        }
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String key = "BG309";

// Ensure sorted before display (matches output)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

// Call binary search
        boolean found = binarySearchBogieId(bogieIds, key);

        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }

    // ===== UC17: Sort Bogie Names using Arrays.sort() =====
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }
    // ===== UC18: Linear Search for Bogie ID =====
    public static boolean searchBogieById(String[] bogieIds, String searchId) {

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true; // Found → early termination
            }
        }

        return false; // Not found
    }
    // ===== UC19: Binary Search for Bogie ID =====
    public static boolean binarySearchBogieId(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure array is sorted (important precondition)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                return true; // Found
            } else if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
    }
}