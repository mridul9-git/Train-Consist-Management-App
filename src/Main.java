import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Inner class for UC7
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

        System.out.println("\nFinal Train Formation (Insertion Order Preserved, No Duplicates):");
        System.out.println(formation);

        //===== UC6 =====
        System.out.println("\n=== UC6: Bogie Capacity Mapping Using HashMap ===");

        HashMap<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        //===== UC7 =====
        System.out.println("\n=== UC7: Sort Bogies by Capacity (Comparator) ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nBogies sorted by capacity (Ascending):");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> Capacity: " + b.getCapacity());
        }

        //===== UC8 =====
        System.out.println("\n=== UC8: Filter Passenger Bogies Using Streams ===");

        Map<String, Integer> bogieData = new HashMap<>();
        bogieData.put("Sleeper", 72);
        bogieData.put("AC Chair", 60);
        bogieData.put("First Class", 24);
        bogieData.put("Luxury", 80);

        List<Map.Entry<String, Integer>> bogieListStream = new ArrayList<>(bogieData.entrySet());

        List<Map.Entry<String, Integer>> filteredBogies = bogieListStream
                .stream()
                .filter(b -> b.getValue() > 60)
                .toList();

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Map.Entry<String, Integer> entry : filteredBogies) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        //===== UC9 =====
        System.out.println("\n=== UC9: Group Bogies by Type (Collectors.groupingBy) ===");

        class BogieType {
            private String name;
            private String type;
            private int capacity;

            public BogieType(String name, String type, int capacity) {
                this.name = name;
                this.type = type;
                this.capacity = capacity;
            }

            public String getName() { return name; }
            public String getType() { return type; }
            public int getCapacity() { return capacity; }
        }

        List<BogieType> bogieList = new ArrayList<>();
        bogieList.add(new BogieType("Sleeper", "Passenger", 72));
        bogieList.add(new BogieType("AC Chair", "Passenger", 60));
        bogieList.add(new BogieType("First Class", "Passenger", 24));
        bogieList.add(new BogieType("Cargo Box", "Goods", 100));
        bogieList.add(new BogieType("Oil Tanker", "Goods", 120));

        Map<String, List<BogieType>> groupedBogies = bogieList
                .stream()
                .collect(java.util.stream.Collectors.groupingBy(BogieType::getType));

        System.out.println("Grouped Bogies by Type:");
        for (Map.Entry<String, List<BogieType>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (BogieType b : entry.getValue()) {
                System.out.println(b.getName() + " -> Capacity: " + b.getCapacity());
            }
        }

        //===== UC10 =====
        System.out.println("\n=== UC10: Count Total Seats in Train (reduce) ===");

        int totalSeats = bogies
                .stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        //===== UC11 =====
        System.out.println("\n=== UC11: Validate Train ID & Cargo Code (Regex) ===");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        String trainPatternStr = "TRN-\\d{4}";
        String cargoPatternStr = "PET-[A-Z]{2}";

        java.util.regex.Pattern trainPattern = java.util.regex.Pattern.compile(trainPatternStr);
        java.util.regex.Pattern cargoPattern = java.util.regex.Pattern.compile(cargoPatternStr);

        java.util.regex.Matcher trainMatcher = trainPattern.matcher(trainId);
        java.util.regex.Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        System.out.println(trainMatcher.matches() ? "Train ID VALID" : "Train ID INVALID");
        System.out.println(cargoMatcher.matches() ? "Cargo Code VALID" : "Cargo Code INVALID");

        //===== UC12 =====
        System.out.println("\n=== UC12: Safety Compliance Check for Goods Bogies ===");

        class GoodsBogie {
            private String type;
            private String cargo;

            public GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }

            public String getType() { return type; }
            public String getCargo() { return cargo; }
        }

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));

        boolean isSafe = goodsBogies
                .stream()
                .allMatch(b ->
                        !b.getType().equals("Cylindrical") ||
                                b.getCargo().equals("Petroleum")
                );

        System.out.println(isSafe ? "Train is SAFE" : "Train is UNSAFE");

//===== UC13 =====
        System.out.println("\n=== UC13: Performance Comparison (Loops vs Streams) ===");

// Create large dataset
        List<Bogie> largeList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeList.add(new Bogie("Bogie" + i, (i % 100) + 1));
        }


        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : largeList) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;



        long startStream = System.nanoTime();

        List<Bogie> streamResult = largeList
                .stream()
                .filter(b -> b.getCapacity() > 60)
                .toList();

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;



        System.out.println("Loop Filter Result Size: " + loopResult.size());
        System.out.println("Stream Filter Result Size: " + streamResult.size());

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
 //===== UC14 =====
        System.out.println("\n=== UC14: Handle Invalid Bogie Capacity (Custom Exception) ===");


        class InvalidCapacityException extends Exception {
            public InvalidCapacityException(String message) {
                super(message);
            }
        }


        class PassengerBogie {
            private String type;
            private int capacity;

            public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
                if (capacity <= 0) {
                    throw new InvalidCapacityException("Capacity must be greater than zero");
                }
                this.type = type;
                this.capacity = capacity;
            }

            public String getType() { return type; }
            public int getCapacity() { return capacity; }
        }


        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72); // valid
            System.out.println("Created: " + b1.getType() + " -> " + b1.getCapacity());

            PassengerBogie b2 = new PassengerBogie("AC Chair", -10); // ❌ invalid
            System.out.println("Created: " + b2.getType());

        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }
//===== UC15 =====
        System.out.println("\n=== UC15: Safe Cargo Assignment Using try-catch-finally ===");


        class CargoSafetyException extends RuntimeException {
            public CargoSafetyException(String message) {
                super(message);
            }
        }


        class SafeGoodsBogie {
            private String type;
            private String cargo;

            public SafeGoodsBogie(String type) {
                this.type = type;
            }

            public void assignCargo(String cargo) {
                try {
                    // Unsafe condition
                    if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                        throw new CargoSafetyException("Unsafe: Cannot assign Petroleum to Rectangular bogie");
                    }

                    this.cargo = cargo;
                    System.out.println("Cargo assigned successfully: " + cargo);

                } catch (CargoSafetyException e) {
                    System.out.println("Error: " + e.getMessage());

                } finally {
                    System.out.println("Cargo assignment attempt completed for " + type + " bogie");
                }
            }

            public String getCargo() {
                return cargo;
            }
        }


        SafeGoodsBogie g1 = new SafeGoodsBogie("Cylindrical");
        g1.assignCargo("Petroleum"); // ✅ valid

        SafeGoodsBogie g2 = new SafeGoodsBogie("Rectangular");
        g2.assignCargo("Petroleum"); // ❌ invalid but handled

        System.out.println("Program continues after handling exception...");
//===== UC16 =====
        System.out.println("\n=== UC16: Bubble Sort on Passenger Bogie Capacities ===");


        int[] capacities = {72, 56, 24, 70, 60};


        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();


        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }


        System.out.println("Sorted Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

    }
}