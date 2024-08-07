public class NetworkHandlerStub implements INetworkHandler{
    @Override
    public int networkAlert(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        // Return 200 for ok
        // Return 500 for not-ok
        // stub always succeeds and returns 200
        return 500;
    }
}
