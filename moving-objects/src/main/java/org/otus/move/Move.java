package org.otus.move;

public class Move implements Command {

    private MovingObject movingObject;

    public Move( MovingObject movingObject ) {
        this.movingObject = movingObject;
    }

    @Override
    public void execute( ) {
        movingObject.move();
    }

}
