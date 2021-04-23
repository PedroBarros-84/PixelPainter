package org.academiadecodigo.bootcamp;

public enum Size {

    SQUARE_SIZE(10),
    GRID_WIDTH(110),
    GRID_HEIGHT(80),
    PADDING((int)Math.floor(Size.SQUARE_SIZE.getSize() / 2));

    private final int pixels;

    Size(int pixels) {
        this.pixels = pixels;
    }

    public int getSize() {
        return this.pixels;
    }

}