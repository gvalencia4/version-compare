package main;

import static main.VersionCompare.VersionCompareStrings;

public class Main {

    public static void main(String[] args) {
        String inputString1 = "3.1";
        String inputString2 = "3.0.0.0.0.0";

        System.out.println(VersionCompareStrings(inputString1, inputString2));
    }
}
