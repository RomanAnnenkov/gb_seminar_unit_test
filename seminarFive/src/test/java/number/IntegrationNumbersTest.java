package number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class IntegrationNumbersTest {
    @Test
    public void testIntegrationNumbers() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        int[] testArray = randomNumberModule.getRandomNumbers(15);
        int max = maxNumberModule.getMax(testArray);
        Arrays.sort(testArray);
        assertThat(max).isEqualTo(testArray[testArray.length - 1]);
    }
}
