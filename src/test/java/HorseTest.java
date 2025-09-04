
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class HorseTest {

    @Test
   public void constructorNameNullCheck() {
         Throwable exception =
               assertThrows(IllegalArgumentException.class, () -> new Horse(null, 12.3, 123.1));
       assertEquals("Name cannot be null.", exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\r", "\n"})
    public void constructorNameEmptyCheck(String name) {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Horse(name, 12.3, 123.1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }
    @Test
    public void constructorSpeedParamCheck () {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Horse("Cherry", -1, 123.1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    public void constructorDistanceParamCheck () {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> new Horse("Cherry", 12.3, -123.1));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    public void getNameTest() {
        Horse horse = new Horse("Cherry", 12, 123);
        assertEquals("Cherry", horse.getName());
    }

    @Test
    public void getSpeedTest() {
        Horse horse = new Horse("Cherry", 12, 123);
        assertEquals(12, horse.getSpeed());
    }

    @Test
    public void getDistanceTest() {
        Horse horse = new Horse("Cherry", 12, 123);
        assertEquals(123, horse.getDistance());
    }
}