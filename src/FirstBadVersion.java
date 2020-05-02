/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstBadVersion{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstBadVersion(5));
    }
}


class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        int array[] = getVersionArray(n);
        return searchVersion(array,Integer.MAX_VALUE,0,n-1);
    }

    public int searchVersion(int array[],int min,int l,int u){

        int m = l + (u - l)/2 ;

        if (u == l){
            if (array[l]< min){
                if (isBadVersion(array[l])){
                    min = array[l];
                }
            }
            return min;
        }

        if (array[m] < min){
            if (isBadVersion(array[m])){
                min = array[m];
                u = m-1;
            }else{
                l = m+1;
            }
        } else{
            u = m-1;
        }
        return searchVersion(array,min,l,u);
    }

    public int[] getVersionArray(int n){
        int array[] = new int[n];

        for(int i = 1;i<=n;i++){
            array[i-1] = i;
        }

        return array;
    }
}

class VersionControl{
    public boolean isBadVersion(int n){
        Set<Integer> set = new HashSet<Integer>();
        set.add(4);
        set.add(5);
        if (set.contains(n)){
            return true;
        }
        return false;
    }
}