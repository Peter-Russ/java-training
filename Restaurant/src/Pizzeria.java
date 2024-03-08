public class Pizzeria extends Restaurant {

    @Override
    protected void mahlzeitZubereiten() {
        new Pizza().mahlzeitZubereiten();
    }
}
