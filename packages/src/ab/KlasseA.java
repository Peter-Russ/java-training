package ab;

import c.KlasseC;

public class KlasseA {
    public int myPublA;
    protected int myProtA;
    int myPackA;
    private int myPrivA;
    public void myA() {
        int val1 = myPublA + myPrivA + myProtA + myPackA;
        KlasseA objA = new KlasseA();
        int val2 = objA.myPublA + objA.myPrivA + objA.myProtA + objA.myPackA;
        KlasseB objB = new KlasseB();
        int val3 = objB.myPublA + objB.myPrivA + objB.myProtA + objB.myPackA;
        int val4 = objB.myPublB + objB.myPrivB + objB.myProtB + objB.myPackB;
        KlasseC objC = new KlasseC();
        int val5 = objC.myPublA + objC.myPrivA + objC.myProtA + objC.myPackA;
        int val6 = objC.myPublC + objC.myPrivC + objC.myProtC + objC.myPackC;

    }

}
