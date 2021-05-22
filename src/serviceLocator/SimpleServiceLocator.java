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

        if(!this.constants.containsKey(name) && !this.service.containsKey(name)){
            throw new LocatorError((new ClassCastException()));
        }

        Object object = null;

        if(this.constants.containsKey(name)){
            object = this.constants.get(name);
        }else if (this.service.containsKey(name)){
            object = this.service.get(name).create(this);
        }
       return object;
    }
}
