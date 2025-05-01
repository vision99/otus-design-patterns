package org.otus.move.model;

import org.otus.move.UObject;

import java.util.HashMap;
import java.util.Map;

public class SpaceShip implements UObject {

    private Map<String, Object> properties = new HashMap<>( );

    @Override
    public Object getProperty( String name ) {
        return properties.get( name );
    }

    @Override
    public void setProperty( String property, Object point ) {
        properties.put( property, point );
    }

}
