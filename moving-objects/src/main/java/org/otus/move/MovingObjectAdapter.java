package org.otus.move;

import org.otus.move.model.Angle;
import org.otus.move.model.PointOfLocation;
import org.otus.move.model.VelocityVector;

import java.util.Optional;

public class MovingObjectAdapter implements MovingObject {

    private UObject uObject;

    public MovingObjectAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void setLocation( PointOfLocation point ) {
        uObject.setProperty( "location", Optional.ofNullable( point ).orElseThrow( ( ) -> new IllegalStateException( "new location is null" ) ) );
    }

    @Override
    public PointOfLocation getLocation( ) {
        return (PointOfLocation) Optional.ofNullable( uObject.getProperty( "location" ) ).orElseThrow( ( ) -> new IllegalStateException( "location not found" ) );
    }

    @Override
    public VelocityVector getVelocity( ) {
        int velocity = (int) Optional.ofNullable( uObject.getProperty( "velocity" ) ).orElseThrow( ( ) -> new IllegalStateException( "velocity not found" ) );
        var angle = (Angle) Optional.ofNullable( uObject.getProperty( "angle" ) ).orElseThrow( ( ) -> new IllegalStateException( "angle not found" ) );
        return new VelocityVector( velocity * Math.cos( angle.getValue() ), velocity * Math.sin( angle.getValue() ) );
    }

}
