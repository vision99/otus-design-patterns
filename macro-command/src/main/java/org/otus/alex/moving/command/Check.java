package org.otus.alex.moving.command;

import org.otus.move.Command;
import org.otus.alex.moving.command.inters.CheckFuel;

public class Check implements Command {

    private CheckFuel checkFuel;

    public Check( CheckFuel checkFuelAdapter ) {
        this.checkFuel = checkFuelAdapter;
    }

    @Override
    public void execute( ) {
        checkFuel.setIsFuelExists( checkFuel.isFuelExists( ) );
    }

}
