package c;

import ab.KlasseA;

public class KlasseC extends KlasseA {
    public int myPublC;
    protected int myProtC;
    int myPackC;
    private int myPrivC;
    public void myC() {
        int val1 = myPublA + myPrivA + myProtA + myPackA;
        int val2 = myPublC + myPrivC + myProtC + myPackC;
        KlasseA objA = new KlasseA();
        int val3 = objA.myPublA + objA.myPrivA + objA.myProtA + objA.myPackA;
    }
}
