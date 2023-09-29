import java.util.*;
public class duplicate {
    public static void main(String[] args){
        int[] num = {1,2,3,5,3,4,6,7};

        List<Integer> res = duplicateArray(num);
        System.out.println("Array after removing duplicates: " + res);

        Map<Integer , Integer> occurences = countOfDuplicates(num);
        System.out.println("Occurences of each element: " + occurences);
    }

    public static List<Integer> duplicateArray(int[] arr){

        Set<Integer> uniqueelement = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int num : arr){
            if(uniqueelement.add(num)){
                res.add(num);
            }
        }
        return res;
    }

    public static Map<Integer , Integer> countOfDuplicates(int[] arr){

        Map<Integer , Integer> occurr = new HashMap<>();

        for(int num : arr){
            occurr.put(num , occurr.getOrDefault(num , 0) + 1);
        }

        occurr.values().removeIf(value -> value == 1);
        return occurr;
    }
}