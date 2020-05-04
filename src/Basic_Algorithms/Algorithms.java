package com.company;
import java.util.*;

public class Algorithms{
    public static void main(String[] args) {
        /*BINARY SEARCH*/
        testBinarySearch();

    }

    public static void testBinarySearch(){
        int array[] = {4,1,5,235,3,44,67,84,2,7,0,12,90,22,6,64,34,122,89,69};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int index;
        try {
            index = BinarySearch.search(array,44);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("The element "+44+" is found at index :"+index);
    }
}

class BinarySearch{
    public static int search(int array[],int element) throws ValueNotFoundException {
        return search(array,element,0,array.length-1);
    }

    public static int search(int array[],int element, int left,int right) throws ValueNotFoundException{
        if (right < left){
            throw new ValueNotFoundException("The element "+ element +" is not present in the array");
        }
        int m = (left + right)/2;

        if (array[m] < element){
            return search(array,element,m+1,right);
        }else if (array[m] > element){
            return search(array,element,left,m-1);
        }else{
            return m;
        }
    }
}

class ValueNotFoundException extends Exception{
    public ValueNotFoundException(String message){
        super(message);
    }
}
