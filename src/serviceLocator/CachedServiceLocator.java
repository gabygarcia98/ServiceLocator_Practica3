package serviceLocator;

import java.util.HashMap;
import java.util.Map;

public class CachedServiceLocator implements ServiceLocator {
    private Map<String, Factory> services;
    private Map<String, Object> constant;

    public CachedServiceLocator() {
        services = new HashMap<>();
        constant = new HashMap<>();
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (!services.containsKey(name)) {
            services.put(name, factory);
        } else {
            throw new LocatorError((new ClassCastException()));
        }

    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (!constant.containsKey(name)) {
            constant.put(name, value);
        } else {
            throw new LocatorError((new ClassCastException()));
        }

    }
}

   /* @Override
    /*public Object getObject(String name) throws LocatorError {
        if(!this.constant.containsKey(name) || !this.services.containsKey(name)){
            throw new LocatorError((new ClassCastException()));
        }
        if(services.containsKey(name))
    }
}
