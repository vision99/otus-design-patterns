package org.otus.move;

import org.otus.move.model.Angle;
import org.otus.move.model.AngularVelocity;

public interface RotateObject {

    Angle getAngle( );

    AngularVelocity getAngularVelocity( );

    void setAngle( Angle angle );

    void rotate(  );

}
