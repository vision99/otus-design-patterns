package org.otus.alex.moving.command;

import org.otus.move.model.Fuel;
import org.otus.alex.moving.command.inters.CheckFuel;
import org.otus.move.UObject;

import java.util.Optional;

public class CheckFuelAdapter implements CheckFuel {

    private UObject uObject;

    public CheckFuelAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public Boolean isFuelExists( ) {
        return (Boolean) uObject.getProperty( "isFuelExists" );
    }

    @Override
    public void setIsFuelExists( boolean isFuelExists ) {
        uObject.setProperty( "isFuelExists", isFuelExists );
    }

}
