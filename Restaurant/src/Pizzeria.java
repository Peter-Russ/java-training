public class Pizzeria extends Restaurant {

    @Override
    protected Mahlzeit mahlzeitZubereiten() {
        return new Pizza();
    }
}
