package org.otus.alex.moving.command;

import org.otus.alex.exception.handler.Command;
import org.otus.move.UObject;

import java.util.Optional;

public class AccelirateVelocityCommand implements Command {

    private UObject uObject;

    public AccelirateVelocityCommand( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void execute( ) {
        Optional.ofNullable( uObject.getProperty( "isCanChangeVelocity" ) ).orElseThrow( ( ) -> new CommandException( "Can't change velocity" ) );
        uObject.setProperty( "velocity", ((int) uObject.getProperty( "velocity" )) + 1 );
    }

}
