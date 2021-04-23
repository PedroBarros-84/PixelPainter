package org.academiadecodigo.bootcamp;

public class PixelPainter {

    private Grid grid;
    private Dot dot;
    private Controller controller;

    // Constructor
    public PixelPainter() {
        grid = new Grid();
        dot = new Dot(grid);
        controller = new Controller(this);
    }

    public void init() {
        grid.drawGrid();
    }

    // Getters & Setters
    public Dot getDot() {
        return dot;
    }

    public void save() {
        FileManager.writeToFile(grid.toString());
    }

    public void load() {
        grid.stringToGrid(FileManager.readFile());
    }

    public void delete() {
        grid.delete();
    }

}