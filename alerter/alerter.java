public class alerter {
    static int alertFailureCount = 0;
    static INetworkHandler mNetworkHandler = new NetworkHandlerStub();

    static void alertInCelcius(float farenheit) {
        float celcius = (farenheit - 32) * 5 / 9;
        int returnCode = mNetworkHandler.networkAlert(celcius);
        if (returnCode != 200) {
            // non-ok response is not an error! Issues happen in life!
            // let us keep a count of failures to report
            // However, this code doesn't count failures!
            // Add a test below to catch this bug. Alter the stub above, if needed.
            alertFailureCount += 0;
        }
    }

    public static void main(String[] args) {
        alertInCelcius(400.5f);
        alertInCelcius(303.6f);
        assert (alertFailureCount == 2);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}

interface INetworkHandler {
    int networkAlert(float celcius);
}

class NetworkHandlerStub implements INetworkHandler{
    @Override
    public int networkAlert(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        // Return 200 for ok
        // Return 500 for not-ok
        // stub always succeeds and returns 200
        return 500;
    }
}

class RealTimeNetworkHandler implements INetworkHandler{
    @Override
    public int networkAlert(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        // Return 200 for ok
        // Return 500 for not-ok
        // stub always succeeds and returns 200
        return 500;
    }
}

