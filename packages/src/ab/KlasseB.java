package ab;

public class KlasseB extends KlasseA {
    public int myPublB;
    protected int myProtB;
    int myPackB;
    private int myPrivB;
    public void myB() {
        int val1 = myPublA + myPrivA + myProtA + myPackA;
        int val2 = myPublB + myPrivB + myProtB + myPackB;
        KlasseA objA = new KlasseA();
        int val3 = objA.myPublA + objA.myPrivA + objA.myProtA + objA.myPackA;
    }
}
