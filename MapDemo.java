import java.util.*;
public class MapDemo {
    public static void main(String[] args) {
        // Create a HashMap to store key-value pairs
        Map<Integer, Integer> hm = new HashMap<>();

        // Add some key-value pairs to the map
        hm.put(10, 91);
        hm.put(20, 92);
        hm.put(30, 93);
        System.out.println(hm.keySet());
        System.out.println(hm.values());
       for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        hm.remove(100);
        System.out.println("After removing key 100:");
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
