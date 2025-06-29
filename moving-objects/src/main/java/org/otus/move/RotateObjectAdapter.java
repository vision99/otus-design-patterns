package org.otus.move;

import org.otus.move.model.Angle;
import org.otus.move.model.AngularVelocity;

import java.util.Optional;

public class RotateObjectAdapter implements RotateObject {

    private UObject uObject;

    public RotateObjectAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public AngularVelocity getAngularVelocity( ) {
        var angularVelocity = (AngularVelocity) Optional.ofNullable( uObject.getProperty( "angularVelocity" ) ).orElseThrow( ( ) -> new IllegalStateException( "angular velocity not found" ) );
        var angle = (Angle) Optional.ofNullable( uObject.getProperty( "angle" ) ).orElseThrow( ( ) -> new IllegalStateException( "angle not found" ) );
        return new AngularVelocity( angle.getValue( ) + angularVelocity.getAngularVelocity( ) );
    }

    @Override
    public Angle getAngle( ) {
        return (Angle) Optional.ofNullable( uObject.getProperty( "angle" ) ).orElseThrow( ( ) -> new IllegalStateException( "angle not found" ) );
    }

    @Override
    public void setAngle( Angle angle ) {
        Optional.ofNullable( angle ).orElseThrow( ( ) -> new IllegalStateException( "angle is null" ) );
        uObject.setProperty( "angle", angle );
    }

    @Override
    public void rotate( ) {
        setAngle( new Angle( getAngularVelocity( ).getAngularVelocity( ) ) );
    }

}
