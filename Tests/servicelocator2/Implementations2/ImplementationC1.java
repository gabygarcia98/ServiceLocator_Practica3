package servicelocator2.Implementations2;

import servicelocator2.Interficies.*;

public class ImplementationC1 implements InterfaceC {
    private String s;
    public ImplementationC1(String s) {
        this.s = s;
    }
    public String getS(){
        return s;
    }
}
