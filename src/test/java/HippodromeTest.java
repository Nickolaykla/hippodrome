import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class HippodromeTest {

    @Test
    public void constructorParamNullCheck(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    public void constructorParamNotEmptyCheck() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>(0)));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    public void getHorsesTest() {
        List<Horse> horses = List.of(
                new Horse("1", 2.1), new Horse("2", 2.2), new Horse("3", 2.3),
                new Horse("4", 2.4), new Horse("5", 2.5), new Horse("6", 2.6),
                new Horse("7", 2.7), new Horse("8", 2.8), new Horse("9", 2.9),
                new Horse("10", 2.1), new Horse("11", 2.2), new Horse("12", 2.3),
                new Horse("13", 2.4), new Horse("14", 2.5), new Horse("15", 2.6),
                new Horse("16", 2.7), new Horse("17", 2.8), new Horse("18", 2.9),
                new Horse("19", 2.1), new Horse("20", 2.1), new Horse("21", 2.1),
                new Horse("22", 2.1), new Horse("23", 2.1), new Horse("24", 2.1),
                new Horse("25", 2.1), new Horse("26", 2.1), new Horse("27", 2.1),
                new Horse("28", 2.1), new Horse("29", 2.1), new Horse("30", 2.1)
        );
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void moveTest() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse : horses) {
            Mockito.verify(horse).move();
        }
    }

    @Test
    public void getWinnerTest() {
        Horse horse1 = new Horse("1", 2, 12);
        Horse horse2 = new Horse("2", 3, 16);
        List<Horse> horses = List.of(horse1, horse2);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertSame(horse2, hippodrome.getWinner());
    }
}