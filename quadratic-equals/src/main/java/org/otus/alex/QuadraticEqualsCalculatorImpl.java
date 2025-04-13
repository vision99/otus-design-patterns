package org.otus.alex;

import java.awt.image.RasterFormatException;
import java.util.Random;

public class QuadraticEqualsCalculatorImpl implements QuadraticEqualsCalculator {

    private double a;
    private double b;
    private double c;
    private double[] result = new double[0];

    public QuadraticEqualsCalculatorImpl( double a, double b, double c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEqualsCalculatorImpl( double a ) {
        this.a = a;
        this.b = new Random( ).nextDouble( );
        this.c = new Random( ).nextDouble( );
    }

    @Override
    public void solve( ) {
        if ( isEqualToZero( a ) ) {
            throw new RuntimeException( "a is equal to zero" );
        }
        if ( isEqualToZero( b ) ) {
            if ( (a > 0 && c > 0) || (a < 0 && c < 0) ) {
                this.result = new double[0];
            return;
            }
        }
        var discriminant = calculateDiscriminant( );
        if ( isEqualToZero( discriminant ) ) {
            this.result = new double[]{-b / 2 * a};
            return;
        }

        var v = Math.sqrt( discriminant );

        this.result = new double[]{(-b - v) / 2 * a, (-b + v) / 2 * a};
    }

    public double[] getResult( ) {
        return result;
    }

    public static boolean isEqualToZero( double a ) {
        return Double.compare( a, 0.0 ) == 0;
    }

    public double calculateDiscriminant( ) {
        return b * b - 4 * a * c;
    }

}
