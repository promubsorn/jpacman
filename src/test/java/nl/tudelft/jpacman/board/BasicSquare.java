package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Basic implementation of square.
 *
 * @author Jeroen Roosen 
 */
class BasicSquare extends Square {

    /**
     * Creates a new basic square.
     */
    private Square[][] board;

    /***
     *
     */
    BasicSquare() {
        super();
    }

    @Override
    public boolean isAccessibleTo(Unit unit) {
        return true;
    }

    @Override
    @SuppressWarnings("return.type.incompatible")
    public Sprite getSprite() {
        return null;
    }

    /***
     *
     */
    @Test
    void boardTest() {
        BasicSquare basicSquare = new BasicSquare();
        Square[][] grid = {{basicSquare}};
        Board board = new Board(grid);

        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

    /***
     *
     */
    @Test
    void nullSquareTest() {
        Square[][] grid = {{null}};
        AssertionError error = assertThrows(AssertionError.class, () -> new Board(grid));
        assertThat(error.getMessage()).isEqualTo("Initial grid cannot contain null squares");
    }
}
