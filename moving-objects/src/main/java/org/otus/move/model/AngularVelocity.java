package org.otus.move.model;

import java.util.Objects;

public class AngularVelocity {

    private double angularVelocity;

    public AngularVelocity( double angularVelocity ) {
        this.angularVelocity = angularVelocity;
    }

    public double getAngularVelocity( ) {
        return angularVelocity;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        AngularVelocity that = (AngularVelocity) o;
        return Double.compare( angularVelocity, that.angularVelocity ) == 0;
    }

    @Override
    public int hashCode( ) {
        return Objects.hashCode( angularVelocity );
    }

}
