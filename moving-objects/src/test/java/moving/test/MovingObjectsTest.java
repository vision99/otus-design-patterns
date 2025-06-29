package moving.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.otus.move.model.Fuel;
import org.otus.move.*;
import org.otus.move.model.Angle;
import org.otus.move.model.AngularVelocity;
import org.otus.move.model.PointOfLocation;
import org.otus.move.model.SpaceShip;

@Tag("moving-objects")
public class MovingObjectsTest {


    @Test
    void movingTest( ) {
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "location", new PointOfLocation( 3.0, 10.0 ) );
        spaceShip.setProperty( "angle", new Angle( Math.PI / 2 ) );
        spaceShip.setProperty( "velocity", 1 );
        spaceShip.setProperty( "fuel", new Fuel( 1 ) );
        spaceShip.setProperty( "isFuelExists", true );
        MovingObject movingObject = new MovingObjectAdapter( spaceShip );
        Command obj = new Move( movingObject );
        obj.execute( );
        Assertions.assertEquals( new PointOfLocation( 3.0, 11.0 ), movingObject.getLocation( ) );

    }

    @Test
    void try_get_location_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        MovingObject movingObject = new MovingObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, movingObject::getLocation );
        Assertions.assertEquals( "location not found", ex.getMessage( ) );

    }

    @Test
    void try_get_velocity_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        MovingObject movingObject = new MovingObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, movingObject::getVelocityVector );
        Assertions.assertEquals( "velocity not found", ex.getMessage( ) );

    }


    @Test
    void try_move_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        MovingObject movingObject = new MovingObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, ( ) -> movingObject.setLocation( null ) );
        Assertions.assertEquals( "new location is null", ex.getMessage( ) );

    }


    @Test
    void rotate_object_Test( ) {
        var spaceShip = new SpaceShip( );
        //        spaceShip.setProperty( "location", new PointOfLocation( 3.0, 10.0 ) );
        spaceShip.setProperty( "angle", new Angle( Math.PI / 2 ) );
        spaceShip.setProperty( "angularVelocity", new AngularVelocity( 0.00123 ) );
        RotateObject rotateObject = new RotateObjectAdapter( spaceShip );
        Command obj = new Rotate( rotateObject );
        obj.execute( );
        Assertions.assertEquals( new AngularVelocity( 1.5732563267948967 ).getAngularVelocity(), rotateObject.getAngularVelocity( ).getAngularVelocity() );

    }

    @Test
    void try_get_angle_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        RotateObject rotateObject = new RotateObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, rotateObject::getAngle );
        Assertions.assertEquals( "angle not found", ex.getMessage( ) );

    }

    @Test
    void try_get_angular_velocity_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        RotateObject rotateObject = new RotateObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, rotateObject::getAngularVelocity );
        Assertions.assertEquals( "angular velocity not found", ex.getMessage( ) );

    }


    @Test
    void try_rotate_if_absent_should_throw_exception( ) {
        var spaceShip = new SpaceShip( );
        RotateObject rotateObject = new RotateObjectAdapter( spaceShip );
        Exception ex = Assertions.assertThrows( IllegalStateException.class, ( ) -> rotateObject.setAngle( null ) );
        Assertions.assertEquals( "angle is null", ex.getMessage( ) );

    }

}
