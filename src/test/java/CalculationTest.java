import com.andrey_baburin.domain.Value;
import com.andrey_baburin.services.Calculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CalculationTest {
    private Calculation calculation;

    @BeforeEach
    void setUp() {
        calculation = new Calculation();
    }

    @Test
    void testCreatePost() {
        String message = "aaaaabcccchelloword";
        Value value = calculation.createPost(message);
        Assertions.assertEquals(message, value.getIncomingValue());
    }

    @Test
    void testUpdatePost() {
        String message1 = "aaaaabcccchelloword";
        Value value1 = calculation.createPost(message1);
        String message2 = "aaaaabcccc";
        Value value2 = calculation.updatePost(message2);
        Assertions.assertEquals(message2, value2.getIncomingValue());
        Assertions.assertNotEquals(value1, value2);
    }

    @Test
    void testDelete() {
        String message = "aaaaabcccchelloword";
        calculation.createPost(message);
        calculation.delete();
        Assertions.assertNull(calculation.getValue());
    }

    @Test
    void testConvertAndSort() {
        String message = "hhhelloooo";
        calculation.createPost(message);

        List<Map.Entry<Character, Integer>> result = calculation.convertAndSort();
        Assertions.assertEquals('o', result.get(0).getKey());
        Assertions.assertEquals(4, result.get(0).getValue());
        Assertions.assertEquals('h', result.get(1).getKey());
        Assertions.assertEquals(3, result.get(1).getValue());
        Assertions.assertEquals('l', result.get(2).getKey());
        Assertions.assertEquals(2, result.get(2).getValue());
        Assertions.assertEquals('e', result.get(3).getKey());
        Assertions.assertEquals(1, result.get(3).getValue());
    }
}
