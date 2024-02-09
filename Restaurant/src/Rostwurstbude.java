public class Rostwurstbude extends Restaurant {

    @Override
    protected Mahlzeit mahlzeitZubereiten() {
        return new Rostwurst();
    }
}
