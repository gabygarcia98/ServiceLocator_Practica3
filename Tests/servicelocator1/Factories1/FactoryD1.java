package servicelocator1.Factories1;

import servicelocator1.Implementations1.ImplementationD1;
import servicelocator1.Interfaces1.InterfaceD;
import serviceLocator.*;

public class FactoryD1 implements Factory {
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        try{
            return new ImplementationD1((int) sl.getObject("i"));
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
