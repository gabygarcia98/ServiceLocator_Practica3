package servicelocator1.Factories1;

import servicelocator1.Implementations1.ImplementationA1;
import servicelocator1.Interfaces1.InterfaceA;
import servicelocator1.Interfaces1.InterfaceB;
import servicelocator1.Interfaces1.InterfaceC;
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
