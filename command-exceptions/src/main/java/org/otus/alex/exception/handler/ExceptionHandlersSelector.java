package org.otus.alex.exception.handler;

import org.otus.alex.exception.handler.commands.LogExceptionCommand;
import org.otus.alex.exception.handler.commands.SecondThrowExceptionCommand;
import org.otus.move.Command;

import java.util.Map;

public class ExceptionHandlersSelector {


    private Exception exception;
    private Command command;

    private Map<String, Map<String, Command>> handlers = Map.of(
            "FirstThrowExceptionCommand", Map.of( "RuntimeException", new SecondThrowExceptionCommand( ) )
            , "SecondThrowExceptionCommand", Map.of( "RuntimeException", new LogExceptionCommand( exception ) )
            //            , "LogExceptionCommand", Map.of( "null", new EmptyCommand( ) )

    );

    public void setHandlers( Map<String, Map<String, Command>> handlers ) {
        this.handlers = handlers;
    }

    public void setException( Exception exception ) {
        this.exception = exception;
    }

    public void setCommand( Command command ) {
        this.command = command;
    }

    public Command getCommand( ) {
        return handlers.get( command.getClass( ).getSimpleName( ) ).get( exception.getClass( ).getSimpleName( ) );
    }

}
