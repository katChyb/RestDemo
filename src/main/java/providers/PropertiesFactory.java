package providers;

import helpers.YamlReader;
import models.UrlData;

import java.util.Map;

public class PropertiesFactory {
    YamlReader yamlReader = new YamlReader();
    protected UrlData urlData;

    private PropertiesFactory() {
        setUrlProperties();
    }

    public static PropertiesFactory getInstance() {
        return PropertiesFactorySingleton.INSTANCE;
    }

    private static class PropertiesFactorySingleton {
        private static final PropertiesFactory INSTANCE = new PropertiesFactory();
    }

    private void setUrlProperties() {
        urlData = yamlReader.getConfig().getUrlData();
        Map<String, Object> urlDataProperties = urlData.getUrlProperties();
        for (Map.Entry entry : urlDataProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
