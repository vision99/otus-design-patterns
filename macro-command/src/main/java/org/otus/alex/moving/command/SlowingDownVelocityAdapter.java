package org.otus.alex.moving.command;

import org.otus.alex.moving.command.inters.SlowingDownVelocity;
import org.otus.move.UObject;
import org.otus.move.model.Fuel;

import java.util.Optional;

public class SlowingDownVelocityAdapter implements SlowingDownVelocity {
    private UObject uObject;

    public SlowingDownVelocityAdapter( UObject uObject ) {
        this.uObject = uObject;
    }

    @Override
    public void slowingDownVelocity( ) {
        Optional.ofNullable( uObject.getProperty( "isCanChangeVelocity" ) ).orElseThrow( ( ) -> new CommandException( "Can't change velocity" ) );
        uObject.setProperty( "velocity", ((int) uObject.getProperty( "velocity" )) - 1 );
    }
}
