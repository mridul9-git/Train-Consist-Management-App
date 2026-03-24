import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {

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
    }}