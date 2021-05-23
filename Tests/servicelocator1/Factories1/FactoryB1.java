package servicelocator1.Factories1;

import servicelocator1.Implementations1.ImplementationB1;
import servicelocator1.Interfaces1.InterfaceB;
import servicelocator1.Interfaces1.InterfaceD;
import serviceLocator.*;

public class FactoryB1 implements Factory {
    public InterfaceB create (ServiceLocator sl) throws LocatorError {
        try {
            InterfaceD d = (InterfaceD) sl.getObject("D");
            return new ImplementationB1(d);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
