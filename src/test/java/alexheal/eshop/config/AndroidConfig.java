package alexheal.eshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/androidLocal.properties",
        "classpath:config/mobile/androidRemote.properties"
})
public interface AndroidConfig extends Config {
    String server();

    String username();

    String access_key();

    String url();

    String videoStorage();

    String remoteDriverUrl();
}
