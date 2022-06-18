package alexheal.eshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/mobile/androidLocal.properties",
        "classpath:config/mobile/androidRemote.properties"
})
public interface AndroidConfig extends Config {
    @Key("bs_username")
    String bsUsername();

    @Key("bs_access_key")
    String bsAccessKey();
}
