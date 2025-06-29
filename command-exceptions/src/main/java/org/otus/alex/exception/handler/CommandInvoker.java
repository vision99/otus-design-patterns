package org.otus.alex.exception.handler;

import org.otus.move.Command;
import org.otus.move.Invoker;

public class CommandInvoker implements Invoker {

    private Command command;
    private final Handler handler = new Handler( );

    @Override
    public void setCommand( Command command ) {
        this.command = command;
    }

    @Override
    public void invoke( ) {
        try {
            this.command.execute( );
        } catch ( Exception e ) {
            handler.handle( command, e );
        }
    }

    public Handler getHandler( ) {
        return handler;
    }

}
