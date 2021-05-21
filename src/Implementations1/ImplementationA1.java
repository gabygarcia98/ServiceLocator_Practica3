package Implementations1;

import Interfaces1.InterfaceA;
import Interfaces1.InterfaceB;
import Interfaces1.InterfaceC;

public class ImplementationA1 implements InterfaceA {

    private InterfaceB b;
    private InterfaceC c;
    public ImplementationA1(InterfaceB b, InterfaceC c){
        this.b = b;
        this.c = c;
    }
}
