// int arr = [1,2,3,5];
// n = 5;
import java.util.*;
public class app{
    public static void main(String[] args){
        int[] arr = {3,1,5};
        List<Integer> ans  = check(arr);
        // int ans = check(arr);
        if(!ans.isEmpty()){
            System.out.println(ans);
        }else {
            System.out.println("nope");
        }
        // System.out.println(ans != -1 ? ans : -1);
    }
    public static List<Integer> check(int[] arr){
       int n = arr.length+1;
       boolean[] present = new boolean[n+1];
       for(int num : arr){
        if(num >= 1 && num <= n){
            present[num] = true;
        }
        
       }
       List<Integer> missingnumbers = new ArrayList<>();
       for(int i=1;i<=n;i++){
            if(!present[i]) {
                missingnumbers.add(i);
            }
       }
       return missingnumbers;
    }
}


