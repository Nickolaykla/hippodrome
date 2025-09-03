import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HorseTest {

    @Test
    void constructorNameCheck() {
         Throwable exception =
               assertThrows(IllegalArgumentException.class, () -> new Horse(null, 12.3, 123.1));
       assertEquals("Name cannot be null.", exception.getMessage());
    }
}
