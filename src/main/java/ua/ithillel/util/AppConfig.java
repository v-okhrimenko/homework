package ua.ithillel.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import static ua.ithillel.util.AppConstant.PROPERTY_FILE_NAME;

public class AppConfig {
    private static final Properties APP_CONFIG = new Properties();

    public static void initAppConfig() {

        URL resource = AppConfig.class.getClassLoader().getResource(PROPERTY_FILE_NAME);
        try {
            File file = Paths.get(Objects.requireNonNull(resource).toURI()).toFile();
            String path = file.getAbsolutePath();
            System.out.println("PATH to property " + path);
            APP_CONFIG.load(new FileReader(path));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return APP_CONFIG.getProperty(key);
    }
}
