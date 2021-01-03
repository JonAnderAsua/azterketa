package ehu.isad.utils;

import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class Utils {

    public static Properties getProperties()  {
        Properties properties = null;

        try (InputStream in = Utils.class.getResourceAsStream("/setup.properties")) {
            properties = new Properties();
            properties.load(in);

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}