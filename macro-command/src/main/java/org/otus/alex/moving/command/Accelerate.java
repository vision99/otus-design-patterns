package org.otus.alex.moving.command;

import org.otus.alex.moving.command.inters.AccelerateVelocity;
import org.otus.move.Command;

public class Accelerate implements Command {
    private AccelerateVelocity accelirateVelocity;

    public Accelerate( AccelerateVelocity accelerateVelocityAdapter ) {
        this.accelirateVelocity = accelerateVelocityAdapter;
    }

    @Override
    public void execute( ) {
        accelirateVelocity.accelerateVelocity( );
    }

}
