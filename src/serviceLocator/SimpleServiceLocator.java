package serviceLocator;

import java.util.HashMap;
import java.util.Map;
;

public class SimpleServiceLocator implements ServiceLocator{

    private Map<String, Factory> service;
    private Map<String, Object> constants;

    public SimpleServiceLocator(){
        service = new HashMap<>();
        constants = new HashMap<>();
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if(!service.containsKey(name)){
            service.put(name, factory);
        } else {
            throw new LocatorError((new ClassCastException()));
        }

    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if(!constants.containsKey(name)){
            constants.put(name,value);
        }else{
            throw new LocatorError((new ClassCastException()));
        }

    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if(constants.containsKey(name)){
            return constants.get(name);
        }else if (service.containsKey(name)){
            Object obj = service.get(name).create(this);
            constants.put(name, obj);
            return obj;
        }
        throw new LocatorError((new ClassCastException()));
    }
}
