public class alerter {
    static int alertFailureCount = 0;
    //function Pointer , interface, abstraction
    interface INetworkHandler {
            int networkAlert(float celcius);
    }

    //Low Level Module (Service)
   class RealTimeNetworkHandler implements INetworkHandler{
    @Override
    public int networkAlert(float celcius) {
        //Network request , NIC , Socket , Credentials
    }
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

    class NetworkHandlerStub implements INetworkHandler{
    @Override
    public int networkAlert(float celcius) {
    
       return 500;
    }
}

    class NetworkHandlerMock implements INetworkHandler{
        public networkAlertCallCount=0;
        public float actualCelciusFromAlertInCelcius=celcius;
    @Override
    public int networkAlert(float celcius) {
    networkAlertCallCount++;
        actualCelciusFromAlertInCelcius=celcius;
       return 500;
    }
}

    static void testEnv(){
        //state based testing
        alertInCelcius(400.5f,new NetworkHandlerStub() );
        assert (alertFailureCount == 1);

        //Behavior/interaction Testing
        floate epectedCeliusValueToBeRecievedByNetworkHandler=204.72222;
        NetworkHandlerMock mockObj=new NetworkHandlerMock()
          alertInCelcius(400.5f, );
        EXPECT_EQ(epectedCeliusValueToBeRecievedByNetworkHandler,mockObj.actualCelciusFromAlertInCelcius);
        
        
 
    }

    public static void main(String[] args) {
        alertInCelcius(400.5f, new RealTimeNetworkHandler());
        alertInCelcius(303.6f , new RealTimeNetworkHandler());
            System.out.printf("%d alerts failed.\n", alertFailureCount);
        System.out.println("All is well (maybe!)\n");
    }
}





