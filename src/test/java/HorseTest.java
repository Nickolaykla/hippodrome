
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
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
        Horse horse2 = new Horse("Cherry", 10);
        assertEquals(123, horse.getDistance());
        assertEquals(0, horse2.getDistance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 0.9})
    public void moveTest(double value) {
        try(MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            Horse horse = new Horse("Cherry", 12, 123);
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(value);
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));

            assertEquals(123 + 12 * value, horse.getDistance());
        }
    }
}