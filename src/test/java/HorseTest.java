
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class HorseTest {

    @Test
    void constructorNameNullCheck() {
         Throwable exception =
               assertThrows(IllegalArgumentException.class, () -> new Horse(null, 12.3, 123.1));
       assertEquals("Name cannot be null.", exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\r", "\n"})
    void constructorNameEmptyCheck(String name) {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Horse(name, 12.3, 123.1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }
    @Test
    void constructorSpeedParamCheck () {

    }
}
