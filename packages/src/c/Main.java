package c;

import ab.KlasseB;

public class Main {
    public static void main(String[] args) {
        KlasseB objB = new KlasseB();
        int val1 = objB.myPublA + objB.myPrivA + objB.myProtA + objB.myPackA;
        int val2 = objB.myPublB + objB.myPrivB + objB.myProtB + objB.myPackB;
        KlasseC objC = new KlasseC();
        int val3 = objC.myPublA + objC.myPrivA + objC.myProtA + objC.myPackA;
        int val4 = objC.myPublC + objC.myPrivC + objC.myProtC + objC.myPackC;
    }
}