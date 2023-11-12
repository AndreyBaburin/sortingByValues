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
        String text = "aaaaabcccchelloword";
        Value result = calculation.createPost(text);
        Assertions.assertEquals(text, result.getIncomingValue());
    }

    @Test
    void testUpdatePost() {
        String text1 = "aaaaabcccchelloword";
        Value value1 = calculation.createPost(text1);
        String text2 = "aaaaabcccc";
        Value value2 = calculation.updatePost(text2);
        Assertions.assertEquals(text2, value2.getIncomingValue());
        Assertions.assertNotEquals(value1, value2);
    }

    @Test
    void testDelete() {
        String text = "aaaaabcccchelloword";
        calculation.createPost(text);
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
