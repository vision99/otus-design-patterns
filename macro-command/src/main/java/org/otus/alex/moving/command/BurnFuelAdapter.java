package org.otus.alex.moving.command;

import org.otus.move.model.Fuel;
import org.otus.alex.moving.command.inters.BurnFuel;
import org.otus.move.UObject;

public class BurnFuelAdapter implements BurnFuel {

    private UObject uObject;

    public BurnFuelAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void burnFuel( ) {
        setFuelValue( ((Fuel) uObject.getProperty( "fuel" )).getValue( ) - 1 );
    }

    private void setFuelValue( int fuelValue ) {
        ((Fuel) uObject.getProperty( "fuel" )).setValue( fuelValue );
    }

}
