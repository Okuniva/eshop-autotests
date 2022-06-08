package alexheal.eshop.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/selenoid/local.properties",
        "classpath:config/selenoid/remote.properties"
})
public interface ProjectConfig extends Config {
    @DefaultValue("chrome")
    String browser();

    String baseUrl();

    @DefaultValue("91.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    String browserMobileView();

    String remoteDriverUrl();

    String videoStorage();
}
