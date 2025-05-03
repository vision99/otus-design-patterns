package org.otus.alex.moving.command;

import org.otus.alex.exception.handler.Command;
import org.otus.move.MovingObject;
import org.otus.move.MovingObjectAdapter;
import org.otus.move.UObject;

import java.util.List;

public class MovingMacroCommand implements Command {

    private UObject uObject;

    @Override
    public void execute( ) {
        var commandsLst = List.of( new CheckFuelCommand( uObject ), new MoveCommand( uObject ), new BurnFuelCommand( uObject ) );
        commandsLst.forEach( Command::execute );

    }


    public MovingMacroCommand( MovingObject movingObject ) {
        this.uObject = ((MovingObjectAdapter) movingObject).getuObject( );

    }

}
