package servicelocator2;


import java.util.HashMap;
import java.util.Map;

public class SimpleServiceLocator implements ServiceLocator{
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
        if(!this.constants.containsKey(klass) && !this.service.containsKey(klass)){
            throw new LocatorError(new ClassCastException());
        }

        T object = null;

        if(this.constants.containsKey(klass)){
            object = (T) this.constants.get(klass);
        }else if (this.service.containsKey(klass)){
            object = (T) this.service.get(klass).create(this);
        }
        return object;
    }
}
