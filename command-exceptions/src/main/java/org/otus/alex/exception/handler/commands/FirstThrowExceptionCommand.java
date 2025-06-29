package org.otus.alex.exception.handler.commands;

import org.otus.move.Command;

import java.util.logging.Logger;

public class FirstThrowExceptionCommand implements Command {

    private final Logger logger = Logger.getLogger( FirstThrowExceptionCommand.class.getName( ) );

    @Override
    public void execute( ) {
        logger.info( "Executing FirstThrowExceptionCommand" );
        throw new RuntimeException( "First throw exception" );
    }

}
