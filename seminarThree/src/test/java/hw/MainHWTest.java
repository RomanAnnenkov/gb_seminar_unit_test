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

}