package test;

import org.junit.jupiter.api.Test;

import static main.MattVersionCompare.MattVersionCompareStrings;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MattVersionCompareTest {

    // 1.3 is newer than 1.2.0.0.3, or 4.4.3 is newer than 4.4.2.4.0

    @Test
    void EqualStringsReturnsZero() {
        String inputString1 = "3.0.0.0.0.1";
        String inputString2 = "3.0.0.0.0.1";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), 0);
    }

    @Test
    void EqualButLongStringsReturnsZero() {
        String inputString1 = "1";
        String inputString2 = "1.0.0.0.0.0";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), 0);
    }

    @Test
    void DifferentStringsReturnOne() {
        String inputString1 = "5.0.1";
        String inputString2 = "5";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), 1);
    }

    @Test
    void DifferentStringsReturnNegativeOne() {
        String inputString1 = "5";
        String inputString2 = "5.0.1";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), -1);
    }

    @Test
    void DifferentStringsWithDoubleDigitsReturnsZero() {
        String inputString1 = "5.24.45.3.0.0.0";
        String inputString2 = "5.24.45.3";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), 0);
    }

    @Test
    void StringsWithLeadingZerosReturnZero() {
        String inputString1 = "0.24.45.3.0.0.0";
        String inputString2 = "0.24.45.3";

        assertEquals(MattVersionCompareStrings(inputString1, inputString2), 0);
    }
}