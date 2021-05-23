package Factories1;

import Implementations1.ImplementationA1;
import Interfaces1.InterfaceA;
import Interfaces1.InterfaceB;
import Interfaces1.InterfaceC;
import serviceLocator.*;

public class FactoryA1 implements Factory {

    public InterfaceA create (ServiceLocator sl) throws LocatorError {
        try{
            InterfaceB b = (InterfaceB) sl.getObject("B");
            InterfaceC c = (InterfaceC) sl.getObject("C");
            return new ImplementationA1(b,c);
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
