package servicelocator1.Implementations1;

import servicelocator1.Interfaces1.InterfaceC;

public class ImplementationC1 implements InterfaceC {
    private String s;
    public ImplementationC1(String s) {
        this.s = s;
    }
    public String getS(){
        return s;
    }
}
