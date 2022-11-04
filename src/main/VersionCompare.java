package main;

public class VersionCompare {

    // Return 1 if inputString1 is greater, -1 if inputString2 is greater, or 0 if they are equal
    public static int VersionCompareStrings(String inputString1, String inputString2) {
        boolean flipped = false;
        int[] v1;
        int[] v2;

        // Split Strings by "."
        String[] inputStringSplit1 = inputString1.split("\\.");
        String[] inputStringSplit2 = inputString2.split("\\.");

        // Convert each array of strings into an array of ints
        int[] inputNum1 = new int[inputStringSplit1.length];
        for (int i = 0; i < inputStringSplit1.length; i++)
        {
            inputNum1[i] = Integer.parseInt(inputStringSplit1[i]);
        }

        int[] inputNum2 = new int[inputStringSplit2.length];
        for (int i = 0; i < inputStringSplit2.length; i++)
        {
            inputNum2[i] = Integer.parseInt(inputStringSplit2[i]);
        }

        // Find the longer array and assign to v1, set up for future steps
        if (inputNum1.length < inputNum2.length) {
            v2 = inputNum1;
            v1 = inputNum2;
            flipped = true; // we will use this to return the correct response
        } else {
            v1 = inputNum1;
            v2 = inputNum2;
        }

        // Check indexes that exist in both v1 and v2
        for (int i = 0; i < v2.length; i++) {

            // If v1 is larger return 1 (or -1 if flipped)
            if (v1[i] > v2[i]) {
                return flipped ? -1 : 1;

            // If v2 is larger return -1 (or 1 if flipped)
            } else if (v2[i] > v1[i]) {
                return flipped ? 1 : -1;
            }
        }

        // Check indexes that exist in v1 but are outside v2
        // Values outside v2 are "0"
        for (int i = v2.length + 1; i < v1.length; i++) {
            // If v1 is not equal to 0 return 1 (or -1 if flipped)
            if (v1[i] != 0) {
                return flipped ? -1 : 1;
            }
        }

        return 0;
    }
}
