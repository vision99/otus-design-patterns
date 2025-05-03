package org.otus.alex.moving.command;

import org.otus.alex.exception.handler.Command;
import org.otus.alex.exception.handler.Invoker;

public class SimpleInvoker implements Invoker {

    private Command command;

    @Override
    public void setCommand( Command command ) {
        this.command = command;
    }

    @Override
    public void invoke( ) {
        this.command.execute( );
    }

}
