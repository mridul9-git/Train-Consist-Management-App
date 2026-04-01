import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Inner class for UC7+
        class Bogie {
            private String name;
            private int capacity;

            public Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }

            public String getName() { return name; }
            public int getCapacity() { return capacity; }
        }

        //===== UC1 =====
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        //===== UC2 =====
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);

        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train.");
        }

        System.out.println("\nFinal Passenger Bogie List:");
        System.out.println(passengerBogies);

        //===== UC3 =====
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("\nBogie IDs (duplicates automatically removed):");
        System.out.println(bogieIds);

        //===== UC4 =====
        System.out.println("\n=== UC4: Train Consist Using LinkedList ===");

        LinkedList<String> consist = new LinkedList<>();
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(consist);

        consist.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(consist);

        consist.removeFirst();
        consist.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(consist);

        System.out.println("\nFinal Ordered Train Consist:");
        System.out.println(consist);

        //===== UC5 =====
        System.out.println("\n=== UC5: Train Formation Using LinkedHashSet ===");

        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        //===== UC6 =====
        System.out.println("\n=== UC6: Bogie Capacity Mapping Using HashMap ===");

        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //===== UC7 =====
        System.out.println("\n=== UC7: Sort Bogies ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }

        //===== UC8 =====
        System.out.println("\n=== UC8: Filter Bogies ===");

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        for (Bogie b : filtered) {
            System.out.println(b.getName());
        }

        //===== UC9 =====
        System.out.println("\n=== UC9: Group Bogies ===");

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        b -> b.getCapacity() > 50 ? "High" : "Low"
                ));

        System.out.println(grouped);

        //===== UC10 =====
        System.out.println("\n=== UC10: Total Capacity ===");

        int total = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("Total: " + total);

        //===== UC11 =====
        System.out.println("\n=== UC11: Regex Validation ===");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean validTrain = trainId.matches("TRN-\\d{4}");
        boolean validCargo = cargoCode.matches("PET-[A-Z]{2}");

        System.out.println("Train ID: " + validTrain);
        System.out.println("Cargo Code: " + validCargo);

        //===== UC12 =====
        System.out.println("\n=== UC12: Safety Check ===");

        class GoodsBogie {
            String type, cargo;
            GoodsBogie(String t, String c) { type = t; cargo = c; }
        }

        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Box", "Coal"));

        boolean safe = goods.stream()
                .allMatch(g -> !g.type.equals("Cylindrical") || g.cargo.equals("Petroleum"));

        System.out.println("Safe: " + safe);

        //===== UC13 =====
        System.out.println("\n=== UC13: Performance Comparison ===");

        List<Bogie> big = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            big.add(new Bogie("B" + i, i % 100));
        }

        long start1 = System.nanoTime();
        List<Bogie> loop = new ArrayList<>();
        for (Bogie b : big) {
            if (b.getCapacity() > 60) loop.add(b);
        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        List<Bogie> stream = big.stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();
        long end2 = System.nanoTime();

        System.out.println("Loop time: " + (end1 - start1));
        System.out.println("Stream time: " + (end2 - start2));
    }
}