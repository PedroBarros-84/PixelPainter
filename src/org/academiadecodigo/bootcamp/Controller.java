package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.*;

public class Controller implements KeyboardHandler{

    private Keyboard keyboard;

    private PixelPainter mapEditor;
    private boolean spaceIsPressed;

    // Constructor
    public Controller(PixelPainter mapEditor) {
        keyboard = new Keyboard(this);
        this.mapEditor = mapEditor;
        spaceIsPressed = false;
        init();
    }

    public void init() {
        KeyboardEvent moveUP = new KeyboardEvent();
        moveUP.setKey(KeyboardEvent.KEY_UP);
        moveUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUP);

        KeyboardEvent moveDOWN = new KeyboardEvent();
        moveDOWN.setKey(KeyboardEvent.KEY_DOWN);
        moveDOWN.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDOWN);

        KeyboardEvent moveRIGHT = new KeyboardEvent();
        moveRIGHT.setKey(KeyboardEvent.KEY_RIGHT);
        moveRIGHT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRIGHT);

        KeyboardEvent moveLEFT = new KeyboardEvent();
        moveLEFT.setKey(KeyboardEvent.KEY_LEFT);
        moveLEFT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLEFT);

        KeyboardEvent switchColor = new KeyboardEvent();
        switchColor.setKey(KeyboardEvent.KEY_SPACE);
        switchColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(switchColor);

        KeyboardEvent stopSwitchColor = new KeyboardEvent();
        stopSwitchColor.setKey(KeyboardEvent.KEY_SPACE);
        stopSwitchColor.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(stopSwitchColor);

        KeyboardEvent savePaint = new KeyboardEvent();
        savePaint.setKey(KeyboardEvent.KEY_S);
        savePaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(savePaint);

        KeyboardEvent loadPaint = new KeyboardEvent();
        loadPaint.setKey(KeyboardEvent.KEY_L);
        loadPaint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(loadPaint);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKey(KeyboardEvent.KEY_D);
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(delete);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quit);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            mapEditor.getDot().moveUp(spaceIsPressed);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            mapEditor.getDot().moveDown(spaceIsPressed);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            mapEditor.getDot().moveRight(spaceIsPressed);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            mapEditor.getDot().moveLeft(spaceIsPressed);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spaceIsPressed = true;
            mapEditor.getDot().invertSquareColor();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            mapEditor.save();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            mapEditor.load();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            mapEditor.delete();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_Q) {
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spaceIsPressed = false;
        }
    }

}