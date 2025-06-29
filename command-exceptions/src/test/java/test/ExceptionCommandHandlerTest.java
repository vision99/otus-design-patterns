package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.otus.alex.exception.handler.CommandInvoker;
import org.otus.alex.exception.handler.commands.FirstThrowExceptionCommand;
import org.otus.alex.exception.handler.commands.LogExceptionCommand;
import org.otus.alex.exception.handler.commands.SecondThrowExceptionCommand;
import org.otus.move.Command;

import java.util.Map;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.*;

@Tag("command-exceptions")
public class ExceptionCommandHandlerTest {

    @Test
    public void testFirstThrowException_should_be_SecondThrowExceptionCommand_in_queue( ) {
        //given
        var invoker = new CommandInvoker( );
        invoker.setCommand( new FirstThrowExceptionCommand( ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( SecondThrowExceptionCommand.class, invoker.getHandler( ).pollNext( ).getClass( ) );
    }

    @Test

    public void testSecondThrowException_should_be_LogExceptionCommand_in_queue( ) {
        //given
        var invoker = new CommandInvoker( );
        invoker.setCommand( new SecondThrowExceptionCommand( ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( LogExceptionCommand.class, invoker.getHandler( ).pollNext( ).getClass( ) );
    }

    @Test
    public void testLogExceptionCommand_execute_method_once( ) {
        var log = mock( LogExceptionCommand.class );
        var invoker = new CommandInvoker( );
        invoker.setCommand( log );
        //given
        //when
        invoker.invoke( );
        //then
        verify( log, atMostOnce( ) ).execute( );
    }

    @Test
    public void test_execute_FirstException_then_SecondException_then_LogExceptionCommand_in_queue( ) throws InterruptedException {
        //given
        var first = spy( FirstThrowExceptionCommand.class );
        var second = spy( SecondThrowExceptionCommand.class );
        var log = spy( new LogExceptionCommand( new RuntimeException( "test" ) ) );
        var invoker = new CommandInvoker( );
        Map<String, Map<String, Command>> handlers = Map.of(
                "FirstThrowExceptionCommand", Map.of( "RuntimeException", second )
                , "SecondThrowExceptionCommand", Map.of( "RuntimeException", log )
                //            , "LogExceptionCommand", Map.of( "null", new EmptyCommand( ) )

        );
        invoker.getHandler( ).getSelector( ).setHandlers( handlers );
        invoker.setCommand( first );
        //when
        invoker.invoke( );
        sleep( 200 );
        while ( !invoker.getHandler( ).getQueue( ).isEmpty( ) ) {
            invoker.setCommand( invoker.getHandler( ).getQueue( ).poll( ) );
            invoker.invoke( );
            sleep( 200 );
        }
        //then
        verify( first ).execute( );
        verify( second ).execute( );
        verify( log ).execute( );
        //        verify( log, atMostOnce( ) ).execute( );
    }

}
