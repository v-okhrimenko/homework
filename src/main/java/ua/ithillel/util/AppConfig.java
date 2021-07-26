package ua.ithillel.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static final Properties APP_CONFIG = new Properties();

    public static void initAppConfig() {
//        URL res = AppConfig.class.getClassLoader().getResource(PROPERTY_FILE_NAME);
        try {
//            File file = Paths.get(Objects.requireNonNull(res).toURI()).toFile();
//            String pathToFile = file.getAbsolutePath();
            String pathToFile = "/Users/JULIA/Downloads/servlet-crud-app/servlet-crud-app.properties";
            APP_CONFIG.load(new FileReader(pathToFile));
            System.out.println(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String property) {
        return APP_CONFIG.getProperty(property);
    }
}
