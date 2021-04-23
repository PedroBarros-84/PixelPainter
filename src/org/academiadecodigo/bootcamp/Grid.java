package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int SQUARE_SIZE = Size.SQUARE_SIZE.getSize();
    private final int GRID_WIDTH = Size.GRID_WIDTH.getSize();
    private final int GRID_HEIGHT = Size.GRID_HEIGHT.getSize();
    private final int PADDING = Size.PADDING.getSize();

    private final Rectangle field;
    private final Rectangle[][] grid;
    private int fieldHeightStartPosition;

    public Grid() {

        field = new Rectangle(0, 0, PADDING * 2 + GRID_WIDTH * SQUARE_SIZE,
                                                PADDING * 2 + GRID_HEIGHT * SQUARE_SIZE);
        field.setColor(Color.WHITE);
        field.fill();

        fieldHeightStartPosition = PADDING;

        grid = new Rectangle[GRID_HEIGHT][GRID_WIDTH];

    }

    public void drawGrid() {

        for (int row = 0; row < GRID_HEIGHT; row++) {

            grid[row][0] = new Rectangle(PADDING, fieldHeightStartPosition, SQUARE_SIZE, SQUARE_SIZE);
            grid[row][0].draw();

            for (int col = 1; col < grid[row].length; col++) {

                grid[row][col] = new Rectangle(grid[row][col - 1].getX() + grid[row][col - 1].getWidth(),
                                                            fieldHeightStartPosition, SQUARE_SIZE, SQUARE_SIZE);
                grid[row][col].draw();
            }

            fieldHeightStartPosition += SQUARE_SIZE;
        }
    }

    public void switchCellColor(int y, int x) {

        if (!grid[y][x].isFilled()) {
            grid[y][x].setColor(Color.BLACK);
            grid[y][x].fill();
        } else {
            grid[y][x].draw();
        }
    }

    public void stringToGrid(String file) {

        int counter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (file.charAt(counter) == '0') {
                    grid[row][col].draw();
                } else {
                    grid[row][col].fill();
                }
                counter++;
            }
            counter++;
        }
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                result.append(grid[row][col].isFilled() ? '1' : '0');
            }
            result.append("\n");
        }

        return result.toString();
    }

    public void delete() {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col].draw();
            }
        }
    }

}
