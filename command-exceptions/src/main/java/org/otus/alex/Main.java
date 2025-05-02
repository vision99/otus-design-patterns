package org.otus.alex;

import org.otus.alex.exception.handler.Command;
import org.otus.alex.exception.handler.CommandInvoker;
import org.otus.alex.exception.handler.commands.FirstThrowExceptionCommand;

public class Main {


    public static void main( String[] args ) {
        var invoker = new CommandInvoker( );
        invoker.setCommand( new FirstThrowExceptionCommand( ) );
        invoker.invoke( );
        Command next;
        while ( true ) {
            next = invoker.getHandler( ).pollNext( );
            while ( next == null ) ;
            //                System.err.println("queue size: "+invoker.getHandler( ).getQueue( ).size( )  );
            invoker.setCommand( next );
            invoker.invoke( );


        }
    }

}