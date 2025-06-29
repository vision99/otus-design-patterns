package org.otus.alex.moving.command;

import org.otus.move.Command;
import org.otus.move.Move;
import org.otus.move.MovingObjectAdapter;
import org.otus.move.UObject;

import java.util.List;

public class MovingMacroCommand implements Command {

    private UObject uObject;

    @Override
    public void execute( ) {
        List<Command> commandsLst = List.of( new Check( new CheckFuelAdapter( uObject ) ), new Move( new MovingObjectAdapter( uObject ) ), new Burn( new BurnFuelAdapter( uObject ) ) );
        commandsLst.forEach( Command::execute );

    }


    public MovingMacroCommand( UObject uObject ) {
        this.uObject = uObject;

    }

}
