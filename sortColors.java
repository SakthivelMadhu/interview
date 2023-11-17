import java.util.*;
public class sortColors{
    public static void main(String[] args){
        int[] nums = {-2,2,0,1,1};
        sortColours(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColours(int[] nums){
        int[] counts = new int[5];

        for(int num : nums){
            counts[num+2]++;
        }
        int index = 0;
        for(int i=0;i<5;i++){
            while(counts[i] > 0){
                nums[index++] = i - 2;
                counts[i]--;
            }
        }
    }
}


