package servicelocator2;

import java.util.HashMap;
import java.util.Map;

public class CachedServiceLocator implements ServiceLocator {

    private Map<Class, Factory<?>> service = new HashMap<>();
    private Map<Class, Object> constants = new HashMap<>();

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if(!service.containsKey(klass)){
            service.put(klass, factory);
        } else {
            throw new LocatorError(new ClassCastException());
        }

    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if(!constants.containsKey(klass)){
            constants.put(klass,value);
        }else{
            throw new LocatorError(new ClassCastException());
        }

    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {

        if(service.containsKey(klass) && constants.containsKey(klass)){
            return (T) constants.get(klass);
        } else if(service.containsKey(klass)){
            T object = (T) service.get(klass).create(this);
            constants.put(klass, object);
            return (T) constants.get(klass);

        } else if (constants.containsKey(klass)){
            return (T) constants.get(klass);
        }
        throw new LocatorError(new ClassCastException());

    }
}
