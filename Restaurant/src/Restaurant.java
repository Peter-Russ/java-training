abstract class Restaurant {
    public void bestellungAufnehmen() {
        System.out.println("Bestellung aufgenommen");
    }

    protected abstract void mahlzeitZubereiten();

    public void mahlzeitLiefern() {
        bestellungAufnehmen();
        mahlzeitServieren();
    }

    protected void mahlzeitServieren() {
        System.out.println("Mahlzeit serviert");
    }
}
