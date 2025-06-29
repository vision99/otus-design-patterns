package org.otus.alex.moving.command;

import org.otus.alex.moving.command.inters.AccelerateVelocity;
import org.otus.move.UObject;

import java.util.Optional;

public class AccelerateVelocityAdapter implements AccelerateVelocity {
    private UObject uObject;

    public AccelerateVelocityAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void accelerateVelocity() {
        Optional.ofNullable( uObject.getProperty( "isCanChangeVelocity" ) ).orElseThrow( ( ) -> new CommandException( "Can't change velocity" ) );
        uObject.setProperty( "velocity", ((int) uObject.getProperty( "velocity" )) + 1 );
    }
}
