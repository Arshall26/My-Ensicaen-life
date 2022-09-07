package fr.ensicaen.ecole.genielogiciel.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceModelTest {
    private final DiceModel dice = new DiceModel();

    @Test
    public void rollTest() {
        for (int i =0; i<10; i++) {
            int value = dice.roll();
            assertTrue((value < 7) && (value > 0));
        }
    }
}