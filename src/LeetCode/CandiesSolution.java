package LeetCode;

import java.util.ArrayList;
import java.util.List;

class CandiesSolution{
    public static void main(String[] args) {
        int array[] = {12,1,1,3,4,23,5};
        kidsWithCandies(array,10);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestKid = 0;
        List<Boolean> list = new ArrayList<Boolean>();
        for(int i = 0; i<candies.length; i++){
            if (candies[i] >= candies[greatestKid]){
                greatestKid = i;
            }
        }

        for (int i = 0;i< candies.length;i++){
            list.add(i,(candies[greatestKid] - candies[i]) <= extraCandies);
            System.out.println(">>> "+i + "   ->   " + list.get(i));
        }

        return list;
    }
}