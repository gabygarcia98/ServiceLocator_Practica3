package Factories1;

import Implementations1.ImplementationD1;
import Interfaces1.InterfaceD;
import serviceLocator.*;

public class FactoryD1 implements Factory {
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        try{
            int i = (int) sl.getObject("i");
            return new ImplementationD1(i);
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
