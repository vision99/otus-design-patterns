package org.otus.move;

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
        uObject.setProperty( "location", point );
    }

    @Override
    public PointOfLocation getLocation( ) {
        return (PointOfLocation) Optional.ofNullable( uObject.getProperty( "location" ) ).orElseThrow( ( ) -> new IllegalStateException( "location not found" ) );
    }

    @Override
    public VelocityVector getVelocity( ) {
        int velocity = (int) uObject.getProperty( "velocity" );
        double angle = (double) uObject.getProperty( "angle" );
        return new VelocityVector( velocity * Math.cos( angle ), velocity * Math.sin( angle ) );
    }

}
