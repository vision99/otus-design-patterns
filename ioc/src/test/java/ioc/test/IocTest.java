package ioc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.otus.alex.ioc.Ioc;
import org.otus.move.*;
import org.otus.move.model.Angle;
import org.otus.move.model.Fuel;
import org.otus.move.model.PointOfLocation;
import org.otus.move.model.SpaceShip;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Tag("ioc")
public class IocTest {

    private Function<Object[], Object> constructObj = ( arr ) -> {
        var clazz = (Class) arr[0];
        Object instance;
        Constructor constructor;
        try {
            constructor = clazz.getConstructor( arr[1].getClass( ).getInterfaces( )[0] );
            instance = constructor.newInstance( arr[1] );
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
        return instance;
    };

    @Test
    void iocTest( ) throws InterruptedException {
        System.err.println( Thread.currentThread( ).getName( ) );
        var ioc = new Ioc( );
        var properties = new HashMap<>( Map.of(
                "location", new PointOfLocation( 3.0, 10.0 ),
                "angle", new Angle( Math.PI / 2 ),
                "velocity", 1,
                "fuel", new Fuel( 1 ),
                "isFuelExists", true
        ) );
        ioc.resolve( "register", "defaultScope.spaceship", constructObj );
        ioc.resolve( "register", "defaultScope.spaceship moving", constructObj );
        ioc.resolve( "register", "defaultScope.Команда движение по прямой", constructObj );

        UObject spaceShip = ioc.resolve( "defaultScope.spaceship", SpaceShip.class, properties );
        MovingObject obj = ioc.resolve( "defaultScope.spaceship moving", MovingObjectAdapter.class, spaceShip );
        Move cmd = ioc.resolve( "defaultScope.Команда движение по прямой", Move.class, obj );
        cmd.execute( );
        Assertions.assertEquals( new PointOfLocation( 3.0, 11.0 ), obj.getLocation( ) );

    }

    @Test
    void checkSingletoneTest( ) throws InterruptedException {
        System.err.println( Thread.currentThread( ).getName( ) );

        var ioc = new Ioc( );
        var properties = new HashMap<>( Map.of(
                "location", new PointOfLocation( 3.0, 10.0 ),
                "angle", new Angle( Math.PI / 2 ),
                "velocity", 1,
                "fuel", new Fuel( 1 ),
                "isFuelExists", true
        ) );
        ioc.resolve( "register", "singletoneScope.spaceship", constructObj );
        UObject spaceShip = ioc.resolve( "singletoneScope.spaceship", SpaceShip.class, properties );
        UObject spaceShipTwo = ioc.resolve( "singletoneScope.spaceship", SpaceShip.class, properties );
        Assertions.assertEquals( Objects.hashCode( spaceShip ), Objects.hashCode( spaceShipTwo ) );
        Assertions.assertEquals( 1, ioc.getRegistry( ).size( ) );

    }

    @Test
    void checkPrototypeTest( ) throws InterruptedException {
        System.err.println( Thread.currentThread( ).getName( ) );

        var ioc = new Ioc( );
        var properties = new HashMap<>( Map.of(
                "location", new PointOfLocation( 3.0, 10.0 ),
                "angle", new Angle( Math.PI / 2 ),
                "velocity", 1,
                "fuel", new Fuel( 1 ),
                "isFuelExists", true
        ) );
        ioc.resolve( "register", "default.spaceship", constructObj );
        UObject spaceShip = ioc.resolve( "default.spaceship", SpaceShip.class, properties );
        UObject spaceShipTwo = ioc.resolve( "default.spaceship", SpaceShip.class, properties );
        Assertions.assertNotEquals( Objects.hashCode( spaceShip ), Objects.hashCode( spaceShipTwo ) );
        Assertions.assertEquals( 1, ioc.getRegistry( ).size( ) );

    }

}
