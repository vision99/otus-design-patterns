package org.otus.alex.moving.command;

import org.otus.move.model.Fuel;
import org.otus.move.Command;
import org.otus.move.UObject;

import java.util.Optional;

public class CheckFuelCommand implements Command {

    private UObject uObject;

    @Override
    public void execute( ) {
        uObject.setProperty( "isFuelExists", ((Fuel) Optional.ofNullable( (uObject.getProperty( "fuel" )) ).orElseThrow( ( ) -> new CommandException( "fuel property not fount" ) )).getValue() > 0 );
    }

    public CheckFuelCommand( UObject uObject ) {
        this.uObject = uObject;
    }

}
