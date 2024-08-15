
public class alerter {
    static int alertFailureCount = 0;

    //function Pointer , interface, abstraction
    public interface INetworkHandler {
        int networkAlert(float celcius);
    }


    //Hig Level Module depends on Abstarction of Low Level Module
    static void alertInCelcius(float farenheit, INetworkHandler mNetworkHandler) {
        float celcius = (farenheit - 32) * 50 / 9;//calculating
        int returnCode = mNetworkHandler.networkAlert(celcius);//delegating
        if (returnCode != 200) {
            // non-ok response is not an error! Issues happen in life!
            // let us keep a count of failures to report
            // However, this code doesn't count failures!
            // Add a test below to catch this bug. Alter the stub above, if needed.
            alertFailureCount += 0;//update state
        }
    }


    static void testEnv() {
        alertInCelcius(400.5f, new RealTimeNetworkHandler());
        alertInCelcius(303.6f, new RealTimeNetworkHandler());
        //state based testing
        alertInCelcius(400.5f, new NetworkHandlerMock(500));
        assert (alertFailureCount == 1);

        //Behavior/interaction Testing
        float expectedCelciusValueToBeReceivedByNetworkHandler = 204.72222f;
        NetworkHandlerMock mockObj = new NetworkHandlerMock(200);
        alertInCelcius(400.5f, mockObj);
        assert expectedCelciusValueToBeReceivedByNetworkHandler == mockObj.actualCelciusFromAlertInCelcius;
    }

    public static void main(String[] args) {
        testEnv();
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}

class NetworkHandlerMock implements alerter.INetworkHandler {
    public int networkAlertCallCount = 0;
    public float actualCelciusFromAlertInCelcius;
    public int responceCode;

    public NetworkHandlerMock(int code) {
        responceCode = code;
    }

    @Override
    public int networkAlert(float celcius) {
        networkAlertCallCount++;
        actualCelciusFromAlertInCelcius = celcius;
        return responceCode;
    }
}

//Low Level Module (Service)
class RealTimeNetworkHandler implements alerter.INetworkHandler {
    @Override
    public int networkAlert(float celcius) {
        //Network request , NIC , Socket , Credentials
        return 200;
    }
}



