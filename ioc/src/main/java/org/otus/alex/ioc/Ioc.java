package org.otus.alex.ioc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Ioc {

    private final Map<String, Function<Object[], Object>> strategies = new HashMap<>( );
    private final Map<String, Object> registry = new HashMap<>( );

    public <T> T resolve( String dependencyName, Object... params ) {
        if ( dependencyName.equalsIgnoreCase( "register" ) ) {
            var st = new RegisterStrategy( params );
            strategies.put( (String) params[0], ((Function<Object[], Object>) params[1]) );
            return (T) st;
        }
        String key = dependencyName.split( "\\." )[1];
        if ( dependencyName.startsWith( "singletoneScope" ) && registry.containsKey( key ) )
            return (T) registry.get( key );
        T obj = (T) strategies.get( dependencyName ).apply( params );
        registry.put( key, obj );
        return obj;
    }

    public Map<String, Object> getRegistry( ) {
        return this.registry;
    }

}
