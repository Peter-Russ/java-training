public class Rostwurstbude extends Restaurant {

    @Override
    protected void mahlzeitZubereiten() {
        new Rostwurst().mahlzeitZubereiten();
    }
}
