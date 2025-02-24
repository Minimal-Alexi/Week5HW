import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {
    private Dice dice;
    @BeforeEach
    public void setUp() {
        dice = new Dice();
    }
    @Test
    public void testDiceRoll() {
        for(int i = 0; i <= 100; ++i)
        {
            dice.roll();
            int value1 = dice.getDie1(), value2 = dice.getDie2();
            assertTrue(value1 > 0 && value2 > 0);
            assertTrue(value1 < 7 && value2 < 7);
        }
    }
    @Test
    public void testIsDouble(){
        dice.roll();
        while(dice.getDie1() != dice.getDie2())
        {
            dice.roll();
        }
        assertTrue(dice.isDouble());
    }
}
