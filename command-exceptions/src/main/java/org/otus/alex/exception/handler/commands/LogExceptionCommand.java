package org.otus.alex.exception.handler.commands;

import org.otus.alex.exception.handler.Command;

import java.util.logging.Logger;

public class LogExceptionCommand implements Command {

    private final Logger logger = Logger.getLogger( LogExceptionCommand.class.getName( ) );
    private final Exception exception;

    @Override
    public void execute( ) {
        logger.info( "Executing Logging" );
//        logger.info("message: " +exception.getMessage( ) );
    }

    public LogExceptionCommand( Exception exception ) {
        this.exception = exception;
    }

}
