package CollectionExample.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","Prakash");
        map.put("1","Manish");
        map.put(null,"null");
        map.put(null,"null");
        map.put("2","two");
        map.put("3","three");

        //simple Iteration
        map.forEach((key, value) -> {
            System.out.println("Key : " + key + " Value : " + value);
        });

        // Interation using null check
        map.forEach(
                (k, v) -> {
                    // yes, we can put logic here
                    if (k != null){
                        System.out.println("Key1 : " + k + ", Value1 : " + v);
                    }
                }
        );
        System.out.println(map.get("1").hashCode());
        System.out.println(map.get("1").hashCode());
    }
}
