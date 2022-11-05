package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MattVersionCompare {

    public static int versionComparison(String v1, String v2){

        // split arguments by . into array
        String[] splitv1 = v1.split("\\.");
        String[] splitv2 = v2.split("\\.");

        List<Integer> intv1 = new ArrayList<>();
        List <Integer> intv2 = new ArrayList<>();

        // add Integer values into new int array
        for (int i = 0; i < splitv1.length; i++) {
            intv1.add(Integer.parseInt(splitv1[i]));
        }

        for (int i = 0; i < splitv2.length; i++) {
            intv2.add(Integer.parseInt(splitv2[i]));
        }

        // if sizes are not the same, add to the smaller array the difference
        int sizeDifference = 0;
        if (intv1.size() < intv2.size()){
            sizeDifference = intv2.size() - intv1.size();
            for (int i = 0; i < sizeDifference; i++){
                intv1.add(0);
            }
        } else if (intv1.size() > intv2.size()){
            sizeDifference = intv1.size() - intv2.size();
            for (int i = 0; i < sizeDifference; i++){
                intv2.add(0);
            }
            // compare integers and return appropriate value
        }

        System.out.println("First:  " + Arrays.toString(intv1.toArray()));
        System.out.println("Second: " + Arrays.toString(intv2.toArray()));

        int comparedResult = 25; //test to see if logic changes this value
        for (int i = 0; i < intv1.size(); i++){
            if (intv1.get(i) > intv2.get(i) ){
                comparedResult = 1;
            } else if (intv1.get(i) < intv2.get(i)) {
                comparedResult = -1;
            } else {
                comparedResult = 0;
            }
        }
        return comparedResult;
    }

    public static void main (String[] args){
        System.out.println(versionComparison("1.1.4", "1.1.0.0.1"));
        System.out.println(versionComparison("1", "1.1.0.0.1.0"));
    }
}