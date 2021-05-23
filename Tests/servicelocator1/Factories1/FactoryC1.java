package servicelocator1.Factories1;

import serviceLocator.Factory;
import servicelocator1.Implementations1.ImplementationC1;
import serviceLocator.LocatorError;
import serviceLocator.ServiceLocator;

public class FactoryC1 implements Factory {
    public ImplementationC1 create(ServiceLocator sl) throws LocatorError {
        try{
            String s = (String) sl.getObject("S");
            return new ImplementationC1(s);
        }catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
