/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstBadVersion{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstBadVersion(1));
    }
}


class Solution extends VersionControl {
    int min = Integer.MAX_VALUE;

    public int firstBadVersion(int n) {
        return searchVersion(1,n);
    }

    public int searchVersion(int l,int u){

        int m = l + (u-l)/2 ;

        if (u < l) {
            return min;
        }

        if (m < min){
            if (isBadVersion(m)){
                min = m;
                return searchVersion(l,m-1);
            }else{
                return searchVersion(m+1,u);
            }
        } else if(m>min){
            return searchVersion(l,m-1);
        }
        else{
            return min;
        }
    }
}

class VersionControl{
    public boolean isBadVersion(int n){
        if (n >= 1){
            return true;
        }else{
            return false;
        }
    }
}

    //SOLUTION:
//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }