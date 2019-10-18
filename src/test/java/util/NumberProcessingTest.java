package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.FinalData.*;
import static util.NumberProcessing.checkNegativityNumber;
import static util.NumberProcessing.numberSegments;

class NumberProcessingTest {

    @Test
    public void compareConvertedOneHundredAndMinusOneHundred() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(MINUS_ONE_HUNDRED));
    }

    @Test
    public void compareConvertedOneHundredAndOneHundred() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(ONE_HUNDRED));
    }

    @Test
    public void compareConvertedOneHundredAndOneThousand() {
        assertNotEquals(ONE_HUNDRED, checkNegativityNumber(ONE_THOUSAND));
    }

    @Test
    public void checkNullPointerExceptionInCheckNegativity() {
        assertThrows(NullPointerException.class, () -> {
            checkNegativityNumber(NULL);
        });
    }

    @Test
    public void compareConvertedOneToNineAndOneToNineSegment() {
        assertEquals(ONE_TO_NINE_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void compareConvertedOneToNineAndOneToSixSegment() {
        assertNotEquals(ONE_TO_SIX_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void checkNullPointerExceptionInNumberSegments() {
        assertThrows(NullPointerException.class, () -> {
            numberSegments(NULL);
        });
    }
}