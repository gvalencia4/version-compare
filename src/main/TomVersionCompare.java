package main;

import java.util.Arrays;

public class TomVersionCompare {
    public static final int SAME_VERSION = 0;

    public static String[] copyAndFill(String[] sourceArray, int newLength) {
        int oldLength = sourceArray.length;
        String[] newArray = Arrays.copyOf(sourceArray, newLength);
        if (oldLength < newLength) {
            // replace trailing nulls with 0s
            Arrays.fill(newArray, oldLength, newLength, "0");
        }
        return newArray;
    }

    public static int TomVersionCompareStrings(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        // Now we need to ensure parts1 and parts2 have the same length

        // Note: This does not work when the second string is shorter, and they are not equal
        parts1 = copyAndFill(parts1, parts2.length);
        parts2 = copyAndFill(parts2, parts1.length);

        // At this point, parts1 and parts2 have the same length

        for (int i = 0; i < parts1.length; i++) {
            int result = Integer.parseInt(parts1[i]) - Integer.parseInt(parts2[i]);
            if (result == SAME_VERSION) continue;  // this part of the version string is the same in both versions
            return Math.abs(result) / result;      // otherwise, if we get here, we know there is a difference
        }
        // if we get here, we know the versions are the same
        return SAME_VERSION;
    }

    public static void main(String[] args) {
//        String version1 = "5.0.0.1";
//        String version2 = "5";

        String version1 = "5.0.0.1";
        String version2 = "5.2";

        System.out.println(TomVersionCompareStrings(version1, version2));
    }
}
