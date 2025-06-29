package org.otus.alex.moving.command;

import org.otus.move.Command;

public class Burn implements Command {

    private BurnFuelAdapter burnFuelAdapter;

    public Burn( BurnFuelAdapter burnFuelAdapter ) {
        this.burnFuelAdapter = burnFuelAdapter;
    }

    @Override
    public void execute( ) {
        burnFuelAdapter.burnFuel( );
    }

}
