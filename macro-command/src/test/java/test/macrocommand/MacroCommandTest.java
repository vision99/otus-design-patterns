package test.macrocommand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.otus.alex.moving.command.inters.AccelerateVelocity;
import org.otus.move.model.Fuel;
import org.otus.alex.moving.command.*;
import org.otus.move.Invoker;
import org.otus.move.UObject;
import org.otus.move.model.Angle;
import org.otus.move.model.PointOfLocation;
import org.otus.move.model.SpaceShip;

@Tag("macro-command")
public class MacroCommandTest {

    @Test
    public void check_fuel_command_test( ) {
        //given
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "fuel", new Fuel( 1 ) );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new CheckFuelCommand( spaceShip ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( true, spaceShip.getProperty( "isFuelExists" ) );
        Assertions.assertEquals( 1, ((Fuel) spaceShip.getProperty( "fuel" )).getValue( ) );
    }

    @Test
    public void burn_fuel_command_test( ) {
        //given
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "fuel", new Fuel( 1 ) );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new BurnFuelCommand( spaceShip ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( 0, ((Fuel) spaceShip.getProperty( "fuel" )).getValue( ) );
    }

    @Test
    public void when_tank_id_empty_burn_fuel_command_should_throw_exception( ) {
        //given
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "fuel", new Fuel( 0 ) );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new BurnFuelCommand( spaceShip ) );
        //when
        //then
        Exception ex = Assertions.assertThrows( CommandException.class, invoker::invoke );
        Assertions.assertEquals( "fuel must be greater than 0", ex.getMessage( ) );
    }

    @Test
    public void macro_command_test( ) {
        //given
        UObject spaceShip = new SpaceShip( );
        spaceShip.setProperty( "location", new PointOfLocation( 3.0, 10.0 ) );
        spaceShip.setProperty( "angle", new Angle( Math.PI / 2 ) );
        spaceShip.setProperty( "velocity", 1 );
        spaceShip.setProperty( "fuel", new Fuel( 1 ) );
        spaceShip.setProperty( "isFuelExists", true );
        //------------------------------------
        Invoker invoker = new SimpleInvoker( );

        invoker.setCommand( new MovingMacroCommand( spaceShip ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( new PointOfLocation( 3.0, 11.0 ), spaceShip.getProperty( "location" ) );
        Assertions.assertEquals( 0, ((Fuel) spaceShip.getProperty( "fuel" )).getValue( ) );
    }

    @Test
    public void accelerate_velocity_command_test( ) {
        //given
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "velocity", 1 );
        spaceShip.setProperty( "isCanChangeVelocity", true );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new Accelerate( new AccelerateVelocityAdapter( spaceShip ) ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( 2, spaceShip.getProperty( "velocity" ) );
    }

    @Test
    public void accelerate_velocity_command_should_throw_exception( ) {
        //given
        var spaceShip = new SpaceShip( );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new Accelerate( new AccelerateVelocityAdapter( spaceShip ) ) );
        //when
        //then
        Exception ex = Assertions.assertThrows( CommandException.class, invoker::invoke );
        Assertions.assertEquals( "Can't change velocity", ex.getMessage( ) );
    }

    @Test
    public void slowing_down_velocity_command_test( ) {
        //given
        var spaceShip = new SpaceShip( );
        spaceShip.setProperty( "velocity", 1 );
        spaceShip.setProperty( "isCanChangeVelocity", true );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new SlowingDown( new SlowingDownVelocityAdapter( spaceShip ) ) );
        //when
        invoker.invoke( );
        //then
        Assertions.assertEquals( 0, spaceShip.getProperty( "velocity" ) );
    }

    @Test
    public void slowing_down_velocity_command_should_throw_exception( ) {
        //given
        var spaceShip = new SpaceShip( );
        Invoker invoker = new SimpleInvoker( );
        invoker.setCommand( new SlowingDown( new SlowingDownVelocityAdapter( spaceShip ) ) );
        //when
        //then
        Exception ex = Assertions.assertThrows( CommandException.class, invoker::invoke );
        Assertions.assertEquals( "Can't change velocity", ex.getMessage( ) );
    }

}
