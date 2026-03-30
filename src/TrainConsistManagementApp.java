import java.util.*;
import java.util.stream.Collectors;

// Bogie Class
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString for display
    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // ================= UC2 =================
        System.out.println("\n--- UC2: Managing Passenger Bogies ---");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("After removing 'AC Chair': " + trainConsist);

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the train.");
        }

        System.out.println("Final train consist: " + trainConsist);

        // ================= UC3 =================
        System.out.println("\n--- UC3: Ensuring Unique Bogie IDs ---");

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIds);

        // ================= UC4 =================
        System.out.println("\n--- UC4: Maintaining Ordered Train Consist ---");

        LinkedList<String> linkedTrain = new LinkedList<>();
        linkedTrain.add("Engine");
        linkedTrain.add("Sleeper");
        linkedTrain.add("AC");
        linkedTrain.add("Cargo");
        linkedTrain.add("Guard");

        linkedTrain.add(2, "Pantry Car");
        linkedTrain.removeFirst();
        linkedTrain.removeLast();

        System.out.println("Final ordered train consist: " + linkedTrain);

        // ================= UC5 =================
        System.out.println("\n--- UC5: Ordered Unique Train Formation ---");

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate ignored

        System.out.println("Final train formation: " + formation);

        // ================= UC6 =================
        System.out.println("\n--- UC6: Bogie Capacity Mapping ---");

        Map<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 50);
        bogieCapacity.put("First Class", 24);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        // ================= UC7 =================
        System.out.println("\n--- UC7: Sort Passenger Bogies by Capacity ---");

        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Ascending sort
        passengerBogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (Ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // Descending sort
        passengerBogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nAfter Sorting (Descending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // ================= UC8 =================
        System.out.println("\n--- UC8: Filter Passenger Bogies Using Streams ---");

        System.out.println("\nAll Bogies:");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        List<Bogie> filteredBogies = filterBogiesByCapacity(passengerBogies, 60);

        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

        System.out.println("\nUC8 filtering completed...");

        // ================= UC9 =================
        System.out.println("\n=========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("=========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Grouping
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }

        System.out.println("\nUC9 grouping completed...");
        System.out.println("\nSystem ready for further operations.");
    }

    // ================= UC8 METHOD =================
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .toList();
    }

    // ================= UC9 METHOD (IMPORTANT FOR TESTS) =================
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }
}