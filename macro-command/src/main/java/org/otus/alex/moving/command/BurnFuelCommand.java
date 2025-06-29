package org.otus.alex.moving.command;

import org.otus.move.model.Fuel;
import org.otus.move.Command;
import org.otus.move.UObject;

public class BurnFuelCommand implements Command {

    private UObject uObject;

    @Override
    public void execute( ) {
        if ( ((Fuel) uObject.getProperty( "fuel" )).getValue( ) <= 0 )
            throw new CommandException( "fuel must be greater than 0" );
        uObject.setProperty( "fuel", new Fuel( ((Fuel) uObject.getProperty( "fuel" )).getValue( ) - 1 ) );
    }

    public BurnFuelCommand( UObject uObject ) {
        this.uObject = uObject;
    }

}
