package org.otus.move.model;

import java.util.Objects;

public class PointOfLocation {

    private double x;
    private double y;

    public PointOfLocation( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public double getX( ) {
        return x;
    }

    public double getY( ) {
        return y;
    }

    @Override
    public String toString( ) {
        return "( " + x + ", " + y + " )";
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        PointOfLocation that = (PointOfLocation) o;
        return Double.compare( x, that.x ) == 0 && Double.compare( y, that.y ) == 0;
    }

    @Override
    public int hashCode( ) {
        return Objects.hash( x, y );
    }

}
