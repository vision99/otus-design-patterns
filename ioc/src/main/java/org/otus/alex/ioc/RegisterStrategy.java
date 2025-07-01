package org.otus.alex.ioc;

import java.util.Map;
import java.util.function.Function;

public class RegisterStrategy {

    private final String dependencyName;
    private final Function<Object[], Object> params;

    public RegisterStrategy( Object[] values ) {
        this.dependencyName = (String) values[0];
        this.params =( Function<Object[], Object>) values[1];
    }


    public String getDependencyName( ) {
        return dependencyName;
    }

    public Function<Object[], Object> getParams( ) {
        return params;
    }

}
