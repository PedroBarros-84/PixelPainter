package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Dot {

    private final int SQUARE_SIZE = Size.SQUARE_SIZE.getSize();
    private final int GRID_WIDTH = Size.GRID_WIDTH.getSize();
    private final int GRID_HEIGHT = Size.GRID_HEIGHT.getSize();
    private final int PADDING = Size.PADDING.getSize();

    private int dot_Y_OnGrid;
    private int dot_X_OnGrid;
    private Rectangle dot;
    private Grid grid;

    public Dot(Grid grid) {
        this.grid = grid;
        dot_Y_OnGrid = 0;
        dot_X_OnGrid = 0;
        dot = new Rectangle(PADDING + 1, PADDING + 1, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
        dot.setColor(Color.RED);
        dot.fill();
    }

    public void moveUp(boolean spaceIsPressed) {

        if (dot_Y_OnGrid > 0) {
            dot_Y_OnGrid--;
            dot.translate(0, -SQUARE_SIZE);
            if (spaceIsPressed) {
                invertSquareColor();
            }
        }

    }

    public void moveDown(boolean spaceIsPressed) {

        if (dot_Y_OnGrid < GRID_HEIGHT - 1) {
            dot_Y_OnGrid++;
            dot.translate(0, SQUARE_SIZE);
            if (spaceIsPressed) {
                invertSquareColor();
            }
        }
    }

    public void moveRight(boolean spaceIsPressed) {

        if (dot_X_OnGrid < GRID_WIDTH - 1) {
            dot_X_OnGrid++;
            dot.translate(SQUARE_SIZE, 0);
            if (spaceIsPressed) {
                invertSquareColor();
            }
        }
    }

    public void moveLeft(boolean spaceIsPressed) {

        if (dot_X_OnGrid > 0) {
            dot_X_OnGrid--;
            dot.translate(-SQUARE_SIZE, 0);
            if (spaceIsPressed) {
                invertSquareColor();
            }
        }
    }

    public void invertSquareColor() {
        grid.switchCellColor(dot_Y_OnGrid, dot_X_OnGrid);
    }
}
