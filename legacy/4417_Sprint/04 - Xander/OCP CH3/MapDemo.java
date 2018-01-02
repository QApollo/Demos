import java.util.*;

public class MapDemo {
    
    public static void main(String[] args) {
     MapDemo demo = new MapDemo();
     HashMap<String, Integer> products = new HashMap<>();
     
     demo.populateproductsMap(products);
     demo.printKeyValuePairInMap(products);

     products.merge("GPU", 400, Integer::sum);
     demo.printKeyValuePairInMap(products);
     demo.printValueFromMap(products, "TV");
    }

    public void populateproductsMap(HashMap<String,Integer> productsMap) {
        productsMap.put("TV", 1000);
        productsMap.put("Laptop", 1200);
        productsMap.put("GPU", null);
        productsMap.put("CPU", 300);
        productsMap.put("Cutting board", 5);
        productsMap.put("Golden carrot", 9999);
    }

    public<K, V> void printKeyValuePairInMap(HashMap<K,V> map) {
        System.out.println("\n" + "key & values");
        map.forEach((k,v) -> System.out.println("Key:" + k + " "+ "Value:" + v));
    }

    private <K, V, U> void printValueFromMap(HashMap<K,V> map, U key) {
        System.out.println("value = " + map.get(key));
    }

}
