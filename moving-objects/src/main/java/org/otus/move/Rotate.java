package org.otus.move;

public class Rotate implements Command {

    private RotateObject rotateObject;

    public Rotate( RotateObject rotateObject ) {
        this.rotateObject = rotateObject;
    }

    @Override
    public void execute( ) {
        rotateObject.rotate();
    }

}
