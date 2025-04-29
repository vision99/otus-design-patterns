package org.otus.alex.exception.handler;

import java.util.LinkedList;
import java.util.Queue;

public class Handler {

    private ExceptionHandlersSelector selector = new ExceptionHandlersSelector( );

    private final Queue<Command> queue = new LinkedList<>( );

    public Command pollNext( ) {
        return this.queue.poll( );
    }

    public void handle( Command command, Exception e ) {
        selector.setCommand( command );
        selector.setException( e );
        this.queue.add( selector.getCommand( ) );
    }

    public ExceptionHandlersSelector getSelector( ) {
        return selector;
    }

    public Queue<Command> getQueue( ) {
        return queue;
    }

}
