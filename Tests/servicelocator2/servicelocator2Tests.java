package servicelocator2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator2.Factories2.FactoryA1_2;
import servicelocator2.Factories2.FactoryB1_2;
import servicelocator2.Factories2.FactoryC1_2;
import servicelocator2.Factories2.FactoryD1_2;
import servicelocator2.Implementations2.ImplementationA1;
import servicelocator2.Implementations2.ImplementationB1;
import servicelocator2.Implementations2.ImplementationC1;
import servicelocator2.Implementations2.ImplementationD1;
import servicelocator2.Interficies.InterfaceA;
import servicelocator2.Interficies.InterfaceB;
import servicelocator2.Interficies.InterfaceC;
import servicelocator2.Interficies.InterfaceD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class servicelocator2Tests {

    private ServiceLocator simpleService;
    private ServiceLocator cachedService;

    @BeforeEach
    void init() throws LocatorError {
        simpleService = new SimpleServiceLocator();
        cachedService = new CachedServiceLocator();
    }

    @Test
    void getObjectSimpleService() throws LocatorError {

        simpleService.setConstant(String.class, "Agustin Tapia");
        simpleService.setConstant(Integer.class, 5);

        assertEquals("Agustin Tapia", simpleService.getObject(String.class));
        assertEquals(5, simpleService.getObject(Integer.class));

        String Agustin_Tapia = simpleService.getObject(String.class);
        assertEquals(Agustin_Tapia, simpleService.getObject(String.class));

        Integer tournaments_won = simpleService.getObject(Integer.class);
        assertEquals(tournaments_won, simpleService.getObject(Integer.class));

    }

    @Test
    void throwsExceptionGetObjectSimpleTest() {

        assertThrows(LocatorError.class, () -> simpleService.getObject(String.class));
    }

    @Test
    void throwsExceptionSetServiceSimpleTest() throws LocatorError {
        Factory factoryA = new FactoryA1_2();
        simpleService.setService(String.class, factoryA);
        assertThrows(LocatorError.class, () -> simpleService.setService(String.class, factoryA));
    }

    @Test
    void throwsExceptionSetConstantSimpleTest() throws LocatorError {
        simpleService.setConstant(String.class, "Agustin Tapia");
        assertThrows(LocatorError.class, () -> simpleService.setConstant(String.class, "Agustin Tapia"));

    }

    @Test
    void FactoryASimpleTest() throws LocatorError {
        InterfaceD interfaceD = new ImplementationD1(5);
        ImplementationB1 implB = new ImplementationB1(interfaceD);
        ImplementationC1 implC = new ImplementationC1("B");

        simpleService.setConstant(InterfaceB.class, implB);
        simpleService.setConstant(InterfaceC.class, implC);
        simpleService.setService(InterfaceA.class, new FactoryA1_2());

        InterfaceA interfaceA =  simpleService.getObject(InterfaceA.class);
        ImplementationA1 implA = (ImplementationA1) interfaceA;
        assertEquals(simpleService.getObject(InterfaceB.class), implA.getB());
        assertEquals(simpleService.getObject(InterfaceC.class), implA.getC());
    }
    @Test
    void FactoryBSimpleTest() throws LocatorError {
        ImplementationD1 impld = new ImplementationD1(5);

        simpleService.setConstant(InterfaceD.class, impld);
        simpleService.setService(InterfaceB.class, new FactoryB1_2());

        InterfaceB interfaceB =  simpleService.getObject(InterfaceB.class);

        ImplementationB1 implb = (ImplementationB1) interfaceB;

        assertEquals(simpleService.getObject(InterfaceD.class), implb.getD());
    }

    @Test

    void FactoryCSimpleTest() throws  LocatorError {

        simpleService.setConstant(String.class, "s");
        simpleService.setService(InterfaceC.class, new FactoryC1_2());

        InterfaceC interfaceC =  simpleService.getObject(InterfaceC.class);

        ImplementationC1 implc = (ImplementationC1) interfaceC;

        assertEquals(simpleService.getObject(String.class), implc.getS());
    }

    @Test
    void FactoryDSimpleTest() throws LocatorError {

        simpleService.setConstant(Integer.class, 5);
        simpleService.setService(InterfaceD.class, new FactoryD1_2());

        InterfaceD interfaceD = simpleService.getObject(InterfaceD.class);

        ImplementationD1 impld = (ImplementationD1) interfaceD;

        assertEquals(simpleService.getObject(Integer.class), impld.getI());
    }

    //CACHED TEST

    @Test
    void getObjectCachedTest() throws LocatorError {

        cachedService.setConstant(Integer.class, 5);
        cachedService.setConstant(String.class, "Agustin Tapia");

        assertEquals("Agustin Tapia", cachedService.getObject(String.class));
        assertEquals(5, cachedService.getObject(Integer.class));

        Object Agustin_Tapia = cachedService.getObject(String.class);
        assertEquals(Agustin_Tapia, cachedService.getObject(String.class));

        Object tournaments_won = cachedService.getObject(Integer.class);
        assertEquals(tournaments_won, cachedService.getObject(Integer.class));

    }

    @Test
    void throwsExceptionGetObjectCachedTest() {

        assertThrows(LocatorError.class, () -> cachedService.getObject(String.class));
    }

    @Test
    void throwsExceptionSetServiceCachedest() throws LocatorError {
        Factory factoryA = new FactoryA1_2();
        cachedService.setService(String.class, factoryA);
        assertThrows(LocatorError.class, () -> cachedService.setService(String.class, factoryA));
    }

    @Test
    void throwsExceptionSetConstantCachedTest() throws LocatorError {
        cachedService.setConstant(String.class, "Agustin Tapia");
        assertThrows(LocatorError.class, () -> cachedService.setConstant(String.class, "Agustin Tapia"));
    }

    @Test
    void FactoryACachedTest() throws LocatorError {

        InterfaceD interfaceD = new ImplementationD1(5);
        ImplementationB1 implB = new ImplementationB1(interfaceD);
        ImplementationC1 implC = new ImplementationC1("B");

        cachedService.setConstant(InterfaceB.class, implB);
        cachedService.setConstant(InterfaceC.class, implC);
        cachedService.setService(InterfaceA.class, new FactoryA1_2());

        InterfaceA interfaceA = cachedService.getObject(InterfaceA.class);
        InterfaceA interfaceA2 = cachedService.getObject(InterfaceA.class);

        assertEquals(interfaceA, interfaceA2);

        ImplementationA1 implA = (ImplementationA1) interfaceA;
        assertEquals(cachedService.getObject(InterfaceB.class), implA.getB());
        assertEquals(cachedService.getObject(InterfaceC.class), implA.getC());
    }
    @Test
    void FactoryBCachedTest() throws LocatorError {


        ImplementationD1 impld = new ImplementationD1(5);

        cachedService.setConstant(InterfaceD.class, impld);
        cachedService.setService(InterfaceB.class, new FactoryB1_2());

        InterfaceB interfaceB = cachedService.getObject(InterfaceB.class);
        InterfaceB interfaceB2 = cachedService.getObject(InterfaceB.class);

        assertEquals(interfaceB,interfaceB2);

        ImplementationB1 implb = (ImplementationB1) interfaceB;

        assertEquals(cachedService.getObject(InterfaceD.class), implb.getD());

    }

    @Test
    void FactoryCCachedTest() throws LocatorError {

        cachedService.setConstant(String.class, "s");
        cachedService.setService(InterfaceC.class, new FactoryC1_2());

        InterfaceC interfaceC = cachedService.getObject(InterfaceC.class);
        InterfaceC interfaceC2 = cachedService.getObject(InterfaceC.class);

        assertEquals(interfaceC, interfaceC2);

        ImplementationC1 implc = (ImplementationC1) interfaceC;

        assertEquals(cachedService.getObject(String.class), implc.getS());
    }

    @Test
    void FactoryDCachedTest() throws LocatorError {
        cachedService.setConstant(Integer.class, 5);
        cachedService.setService(InterfaceD.class,new FactoryD1_2());

        InterfaceD interfaceD = cachedService.getObject(InterfaceD.class);
        InterfaceD interfaceD2 = cachedService.getObject(InterfaceD.class);
        assertEquals(interfaceD,interfaceD2);

        ImplementationD1 impld = (ImplementationD1) interfaceD;

        assertEquals(cachedService.getObject(Integer.class), impld.getI());
    }
}




