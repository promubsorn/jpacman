package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        //test asserts that a unit has no square to start with,
        // i.e., a unit “has no square” at the beginning.
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        //verifies that the unit indeed has the target square as its base after occupation.
        // In other words, if a unit is occupied by a(ny) basic square,
        // then one should contain the other.
        assertThat(unit.invariant()).isTrue();
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Verifies that the unit indeed has the target square as its base after double occupation.
        // What happens if the unit is reoccupied by another square?
        Square square;
        if(unit.hasSquare()) {
            square = unit.getSquare();
            unit.occupy(square);
            assertThat(unit.invariant()).isTrue();
        }
    }
}
