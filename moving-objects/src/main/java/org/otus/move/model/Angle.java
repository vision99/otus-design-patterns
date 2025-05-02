package org.otus.move.model;

import java.util.Objects;

public class Angle {

    private double angle;

    public Angle( double angle ) {
        this.angle = angle;
    }

    public double getValue( ) {
        return angle;
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        Angle angle1 = (Angle) o;
        return Double.compare( angle, angle1.angle ) == 0;
    }

    @Override
    public int hashCode( ) {
        return Objects.hashCode( angle );
    }

}
