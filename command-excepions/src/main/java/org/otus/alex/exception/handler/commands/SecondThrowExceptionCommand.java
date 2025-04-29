package org.otus.alex.exception.handler.commands;

import org.otus.alex.exception.handler.Command;

import java.util.logging.Logger;

public class SecondThrowExceptionCommand implements Command {

    private final Logger logger = Logger.getLogger( SecondThrowExceptionCommand.class.getName( ) );

    @Override
    public void execute( ) {
        logger.info( "Executing SecondThrowExceptionCommand" );
        throw new RuntimeException( "Second throw exception" );
    }

}
