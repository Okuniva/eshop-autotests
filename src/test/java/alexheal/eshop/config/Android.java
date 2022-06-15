package alexheal.eshop.config;

import org.aeonbits.owner.ConfigFactory;

public class Android {
    public static AndroidConfig config = ConfigFactory.create(AndroidConfig.class, System.getProperties());

    public static boolean isRemoteAndroid() {
        return !config.remoteDriverUrl().equals("");
    }
}
