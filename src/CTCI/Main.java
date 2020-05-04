package CTCI;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        CTCString1 question = new CTCString1();

    }
}


//Unique char String CTC q-1 Strings.
class CTCString1{
    String str ;
    CTCString1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:\n");
        str = scanner.nextLine();
        this.str = str;
        if (isUnique()){
            System.out.println("Yes the string has all unique chars");
        }else{
            System.out.println("string has duplicate chars");
        }
    }

    Boolean isUnique(){
        Set<Character> set = new HashSet<Character>();
        for (int i = 0;i<str.length();i++){
            if (set.contains(str.charAt(i))){
                return false;
            }else{
                set.add(str.charAt(i));
            }
        }
        return true;
    }
}

