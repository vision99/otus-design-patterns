package org.otus.alex.moving.command;

import org.otus.alex.moving.command.inters.SlowingDownVelocity;
import org.otus.move.Command;

public class SlowingDown implements Command {

    private SlowingDownVelocity slowingDownVelocity;

    public SlowingDown( SlowingDownVelocity slowingDownVelocityAdapter ) {
        this.slowingDownVelocity = slowingDownVelocityAdapter;
    }

    @Override
    public void execute( ) {
        slowingDownVelocity.slowingDownVelocity( );
    }

}
