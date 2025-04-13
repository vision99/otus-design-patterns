package org.otus.alex.exception.handler.commands;

import org.otus.alex.exception.handler.Command;

import java.util.logging.Logger;

public class EmptyCommand implements Command {

    Logger logger = Logger.getLogger( EmptyCommand.class.getName( ) );

    @Override
    public void execute( ) {
        logger.info( "Executing EmptyCommand" );
    }

}
