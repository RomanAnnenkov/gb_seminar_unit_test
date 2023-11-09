package hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setup() {
        mainHW = new MainHW();
    }

    @Test
    void numberIsEven() {
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void numberIsOdd() {
        assertFalse(mainHW.evenOddNumber(1));
    }

    @Test
    void numberIsInInterval() {
        for (int i = 26; i < 100; i++) {
            assertTrue(mainHW.numberInInterval(i));
        }
    }

    @Test
    void numberIsNotInInterval() {
        int[] numbers = new int[]{-30, 0, 25, 120};
        for (int number : numbers) {
            assertFalse(mainHW.numberInInterval(number));
        }
    }

}