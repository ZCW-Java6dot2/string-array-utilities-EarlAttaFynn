package com.zipcodewilmington;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].matches(value)) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        //Create empty string array of same size as parameter and index
        String[] bizzarro = new String[array.length];
        int index = 0;

        //Iterate backwards over array and copy each element into new array

        for (int i = array.length - 1; i >= 0; i-- ) {
            bizzarro[index] = array[i];
            index++;
        }

        //Return reversed array
        return bizzarro;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        //Initialize flag. Stop returning from within if statements.
        int flag = 0;

        //Loop array to array.length/2
        for (int i = 0; i <= array.length/2 && array.length != 0; i++) {

        //Check if first and last element are different. If so set flag to 1(fails)
            if (array[i] != array[(array.length) - i - 1]) {
                flag = 1;
        //Note use of break keyword. if failing situation occurs, tally it and stop running.
                break;
            }
        }
        //Return boolean based on flag position. 0 == true, 1 == false;
        if (flag == 1) {
            return false;
        }
        else return true;
    /*
        //Create empty string array of same size as parameter and index
        String[] bizzarro = new String[array.length];
        int index = 0;

        //Iterate backwards over array and copy each element into new array

        for (int i = array.length - 1; i >= 0; i-- ) {
            bizzarro[index] = array[i];
            index++;
        }

        //Set both arrays next to each other and if equal then return true
        return bizzarro.equals(array);
*/

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

/* //Turn array into charArr and initialize hashSet
        char[] input = array.toString().toCharArray();
        Set<Character> hash = new HashSet(26);

        //Loop through charArray, if letter by ASCII value, make lowercase, put in set
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= ((int)'A') && input[i] <= ((int)'Z')
                || input[i] >= ((int)'a') && input[i] <= ((int)'z')) {
                hash.add(Character.toLowerCase(input[i]));
                //(String.valueOf(Character.toLowerCase(input[i])));
            }
        }

        Character[] finalSet = hash.toArray(new Character[0]);
        if (finalSet.length == 26) {
            return true;
        }
        else return false;
*/
        /*
        String input = array.toString();

        for (char i = 'A'; i <= 'Z'; i++) {
            if ((input.indexOf(i) < 0) && (input.indexOf((char) i + 32) < 0)) {
                return false;
            }

        }
        return true;
    }
    */

            boolean answer = false;
            StringBuilder stringBuilder = new StringBuilder();
            for (String x : array){
                stringBuilder.append(x);
            }
            String s = "";
            s = stringBuilder.toString();

            for(char i = 'A'; i <= 'Z'; i++){
                if ((s.indexOf(i) < 0) && (s.indexOf((char)i+32)< 0)){
                    answer = false;
                }else{
                    answer = true;
                }
            }
            return answer;
        }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        //Initialize counter
        int counter = 0;

        //Iterated over array and log every match;
        for(String word : array) {
            if (word.equals(value)) {
                counter++;
            }
        }

        //return counter
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {


        //Convert to arrayList
        ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(array));

        //iterate over list and .remove at every instance value is found
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i).equals(valueToRemove)) {
                arrList.remove(i);
            }
        }

        //Convert arrayList back to array and return.
        //Necessary to cast to (String[]) type.
        String[] newArr = arrList.toArray(new String[0]);
        return newArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        ArrayList<String> input = new ArrayList<String>(Arrays.asList(array));
        String[] result = new String[input.size()];
        for (int i = 0; i < input.size(); i++) {
            if ( i != 0 && input.get(i).equals(input.get(i-1))) {
                input.remove(i);
            }
        }
        for (int i = 0; i < input.size(); i++) {
            if ( i != 0 && input.get(i).equals(input.get(i-1))) {
                input.remove(i);
            }
        }

        return input.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder pack = new StringBuilder();
        String prev = "";

        for(String val : array) {
            if(val.equals(prev)) {
                pack.append(val);
                prev = val;
            }
            else if (!pack.toString().isEmpty()) {
                result.add(pack.toString());
                pack = new StringBuilder();
                pack.append(val);
                prev = val;
            }
            else {
                pack.append(val);
                prev = val;
            }

        }
        result.add(pack.toString());

        String[] packedString = result.toArray(new String[0]);

        return packedString;
    }


}
