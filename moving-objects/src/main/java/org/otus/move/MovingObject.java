package org.otus.move;

import org.otus.move.model.PointOfLocation;
import org.otus.move.model.VelocityVector;

public interface MovingObject {


    void setLocation( PointOfLocation point );

    PointOfLocation getLocation( );

    VelocityVector getVelocityVector( );

    void move( );

    void setVelocity( Integer velocity );

}
