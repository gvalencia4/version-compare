package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MattVersionCompareTwo {

    public static int MattVersionCompareStringsTwo(String v1, String v2) {

        // split arguments by . into array
        String[] splitv1 = v1.split("\\.");
        String[] splitv2 = v2.split("\\.");

        List<Integer> intv1 = new ArrayList<>();
        List<Integer> intv2 = new ArrayList<>();

        // add Integer values into new int array
        for (int i = 0; i < splitv1.length; i++) {
            intv1.add(Integer.parseInt(splitv1[i]));
        }

        for (int i = 0; i < splitv2.length; i++) {
            intv2.add(Integer.parseInt(splitv2[i]));
        }

        // if sizes are not the same, add to the smaller array the difference
        int sizeDifference = 0;
        if (intv1.size() < intv2.size()) {
            sizeDifference = intv2.size() - intv1.size();
            for (int i = 0; i < sizeDifference; i++) {
                intv1.add(0);
            }
        } else if (intv1.size() > intv2.size()) {
            sizeDifference = intv1.size() - intv2.size();
            for (int i = 0; i < sizeDifference; i++) {
                intv2.add(0);
            }
            // compare integers and return appropriate value
        }


        int comparedResult = 25; //test to see if logic changes this value
        for (int i = 0; i < intv1.size(); i++) {
            if (Arrays.equals(intv1.toArray(),intv2.toArray())) {
                comparedResult = 0;
                break;
            } while (intv1.get(i) != intv2.get(i)) {
                if (intv1.get(i) > intv2.get(i)) {
                    comparedResult =1;
                    break;
                } else if (intv1.get(i) < intv2.get(i)) {
                    comparedResult = -1;
                    break;
                }
            }
        }
        return comparedResult;

    }

    public static void main (String[]args){
        //System.out.println(versionComparison("3.0.1.9", "3.0.1.0.0.0"));
    }
}