package moving.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.otus.move.MovingObject;
import org.otus.move.MovingObjectAdapter;
import org.otus.move.model.PointOfLocation;
import org.otus.move.model.SpaceShip;

@Tag("moving-objects")
public class MovingObjectsTest {


    @Test
    void movingTest( ) {
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "location", new PointOfLocation( 3.0, 10.0 ) );
        spaceShip.setProperty( "angle", Math.PI / 2 );
        spaceShip.setProperty( "velocity", 1 );
        MovingObject movingObject = new MovingObjectAdapter( spaceShip );
        movingObject.setLocation( new PointOfLocation(
                movingObject.getLocation( ).getX( ) + movingObject.getVelocity( ).getX( )
                , movingObject.getLocation( ).getY( ) + movingObject.getVelocity( ).getY( )
        ) );

        System.err.println( movingObject.getLocation( ) );
        Assertions.assertEquals( new PointOfLocation( 3.0, 11.0 ), movingObject.getLocation( ) );

    }

}
