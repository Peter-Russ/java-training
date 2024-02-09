abstract class Restaurant {
    public void bestellungAufnehmen() {
        System.out.println("Bestellung aufgenommen");
    }

    protected abstract Mahlzeit mahlzeitZubereiten();

    public void mahlzeitLiefern() {
        bestellungAufnehmen();
        Mahlzeit mahlzeit = mahlzeitZubereiten();
        mahlzeitServieren();
    }

    protected void mahlzeitServieren() {
        System.out.println("Mahlzeit serviert");
    }
}
