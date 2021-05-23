package servicelocator1;

import servicelocator1.Factories1.FactoryA1;
import servicelocator1.Factories1.FactoryB1;
import servicelocator1.Factories1.FactoryC1;
import servicelocator1.Factories1.FactoryD1;
import servicelocator1.Implementations1.ImplementationA1;
import servicelocator1.Implementations1.ImplementationB1;
import servicelocator1.Implementations1.ImplementationC1;
import servicelocator1.Implementations1.ImplementationD1;
import servicelocator1.Interfaces1.InterfaceA;
import servicelocator1.Interfaces1.InterfaceB;
import servicelocator1.Interfaces1.InterfaceC;
import servicelocator1.Interfaces1.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import serviceLocator.*;

import static org.junit.jupiter.api.Assertions.*;

public class servicelocatorTests {

    private ServiceLocator simpleService;
    private ServiceLocator cachedService;


    @BeforeEach
    void init() throws LocatorError {
        simpleService = new SimpleServiceLocator();
        cachedService = new CachedServiceLocator();
    }

    @Test
    void getObjectSimpleService() throws LocatorError{

        simpleService.setConstant("Tournaments won", 5);
        simpleService.setConstant("player", "Agustin Tapia");

        assertEquals("Agustin Tapia", simpleService.getObject("player"));
        assertEquals(5, simpleService.getObject("Tournaments won"));

        Object Agustin_Tapia = simpleService.getObject("player");
        assertEquals(Agustin_Tapia, simpleService.getObject("player"));

        Object tournaments_won = simpleService.getObject("Tournaments won");
        assertEquals(tournaments_won, simpleService.getObject("Tournaments won"));
    }

    @Test
    void throwsExceptionGetObjectSimpleTest() {

        assertThrows(LocatorError.class, () -> simpleService.getObject("earnings"));
    }

    @Test
    void throwsExceptionSetServiceSimpleTest() throws LocatorError {
        Factory factoryA = new FactoryA1();
        simpleService.setService("A", factoryA);

        assertThrows(LocatorError.class, () -> simpleService.setService("A", factoryA));
    }

    @Test
    void throwsExceptionSetConstantSimpleTest() throws LocatorError {
        simpleService.setConstant("player", "Agustin Tapia");
        assertThrows(LocatorError.class, () -> simpleService.setConstant("player", "Agustin Tapia"));
    }

    @Test
    void FactoryASimpleTest() throws LocatorError {

        InterfaceD interfaceD = new ImplementationD1(5);
        ImplementationB1 implB = new ImplementationB1(interfaceD);
        ImplementationC1 implC = new ImplementationC1("B");

        simpleService.setConstant("B", implB);
        simpleService.setConstant("C", implC);
        simpleService.setService("A", new FactoryA1());

        InterfaceA interfaceA = (InterfaceA) simpleService.getObject("A");

        ImplementationA1 implA = (ImplementationA1) interfaceA;
        assertEquals(simpleService.getObject("B"), implA.getB());
        assertEquals(simpleService.getObject("C"), implA.getC());

    }
    @Test
    void FactoryBSimpleTest() throws LocatorError {


        ImplementationD1 impld = new ImplementationD1(5);

        simpleService.setConstant("D", impld);
        simpleService.setService("B", new FactoryB1());

        InterfaceB interfaceB = (InterfaceB) simpleService.getObject("B");

        ImplementationB1 implb = (ImplementationB1) interfaceB;

        assertEquals(simpleService.getObject("D"), implb.getD());

    }

    @Test
    void FactoryCSimpleTest() throws LocatorError {

        simpleService.setConstant("S", "s");
        simpleService.setService("C", new FactoryC1());

        InterfaceC interfaceC = (InterfaceC) simpleService.getObject("C");

        ImplementationC1 implc = (ImplementationC1) interfaceC;

        assertEquals(simpleService.getObject("S"), implc.getS());
    }

    @Test
    void FactoryDSimpleTest() throws LocatorError{

        simpleService.setConstant("i", 5);
        simpleService.setService("D", new FactoryD1());

        InterfaceD interfaceD = (InterfaceD) simpleService.getObject("D");

        ImplementationD1 impld = (ImplementationD1) interfaceD;

        assertEquals(simpleService.getObject("i"), impld.getI());
    }


    //CACHED TESTS


    @Test
    void getObjectCachedTest() throws LocatorError {

        cachedService.setConstant("Tournaments won", 5);
        cachedService.setConstant("player", "Agustin Tapia");

        assertEquals("Agustin Tapia", cachedService.getObject("player"));
        assertEquals(5, cachedService.getObject("Tournaments won"));

        Object Agustin_Tapia = cachedService.getObject("player");
        assertEquals(Agustin_Tapia, cachedService.getObject("player"));

        Object tournaments_won = cachedService.getObject("Tournaments won");
        assertEquals(tournaments_won, cachedService.getObject("Tournaments won"));

    }

    @Test
    void throwsExceptionGetObjectCachedTest() {

        assertThrows(LocatorError.class, () -> cachedService.getObject("earnings"));
    }

    @Test
    void throwsExceptionSetServiceCachedest() throws LocatorError {
        Factory factoryA = new FactoryA1();
        cachedService.setService("A", factoryA);
        assertThrows(LocatorError.class, () -> cachedService.setService("A", factoryA));
    }

    @Test
    void throwsExceptionSetConstantCachedTest() throws LocatorError {
        cachedService.setConstant("player", "Agustin Tapia");
        assertThrows(LocatorError.class, () -> cachedService.setConstant("player", "Agustin Tapia"));
    }

    @Test
    void FactoryACachedTest() throws LocatorError {

        InterfaceD interfaceD = new ImplementationD1(5);
        ImplementationB1 implB = new ImplementationB1(interfaceD);
        ImplementationC1 implC = new ImplementationC1("B");

        cachedService.setConstant("B", implB);
        cachedService.setConstant("C", implC);
        cachedService.setService("A", new FactoryA1());

        InterfaceA interfaceA = (InterfaceA) cachedService.getObject("A");
        InterfaceA interfaceA2 = (InterfaceA) cachedService.getObject("A");

        assertEquals(interfaceA, interfaceA2);

        ImplementationA1 implA = (ImplementationA1) interfaceA;
        assertEquals(cachedService.getObject("B"), implA.getB());
        assertEquals(cachedService.getObject("C"), implA.getC());
    }
    @Test
    void FactoryBCachedTest() throws LocatorError {


        ImplementationD1 impld = new ImplementationD1(5);

        cachedService.setConstant("D", impld);
        cachedService.setService("B", new FactoryB1());

        InterfaceB interfaceB = (InterfaceB) cachedService.getObject("B");
        InterfaceB interfaceB2 = (InterfaceB) cachedService.getObject("B");

        assertEquals(interfaceB,interfaceB2);

        ImplementationB1 implb = (ImplementationB1) interfaceB;

        assertEquals(cachedService.getObject("D"), implb.getD());

    }

    @Test
    void FactoryCCachedTest() throws LocatorError {

        cachedService.setConstant("S", "s");
        cachedService.setService("C", new FactoryC1());

        InterfaceC interfaceC = (InterfaceC) cachedService.getObject("C");
        InterfaceC interfaceC2 = (InterfaceC) cachedService.getObject("C");

        assertEquals(interfaceC, interfaceC2);

        ImplementationC1 implc = (ImplementationC1) interfaceC;

        assertEquals(cachedService.getObject("S"), implc.getS());
    }

    @Test
    void FactoryDCachedTest() throws LocatorError {
        cachedService.setConstant("i", 5);
        cachedService.setService("D",new FactoryD1());

        InterfaceD interfaceD = (InterfaceD) cachedService.getObject("D");
        InterfaceD interfaceD2 = (InterfaceD) cachedService.getObject("D");
        assertEquals(interfaceD,interfaceD2);

        ImplementationD1 impld = (ImplementationD1) interfaceD;

        assertEquals(cachedService.getObject("i"), impld.getI());
    }
}
