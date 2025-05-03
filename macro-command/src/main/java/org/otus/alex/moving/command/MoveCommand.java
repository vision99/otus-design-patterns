package org.otus.alex.moving.command;

import org.otus.alex.exception.handler.Command;
import org.otus.move.MovingObject;
import org.otus.move.MovingObjectAdapter;
import org.otus.move.UObject;
import org.otus.move.model.PointOfLocation;

public class MoveCommand implements Command {

    private UObject uObject;

    public MoveCommand( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void execute( ) {
        if ( !(boolean) uObject.getProperty( "isFuelExists" ) ) throw new CommandException( "isFuelExists is false" );
        MovingObject movingObject = new MovingObjectAdapter( uObject );
        movingObject.setLocation( new PointOfLocation(
                movingObject.getLocation( ).getX( ) + movingObject.getVelocity( ).getX( )
                , movingObject.getLocation( ).getY( ) + movingObject.getVelocity( ).getY( )
        ) );
    }

}
