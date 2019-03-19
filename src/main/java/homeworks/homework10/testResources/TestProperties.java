package homeworks.homework10.testResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static FileInputStream testPropertiesFile;
    private static Properties testProperties;

    static {
        try {
            testPropertiesFile = new FileInputStream("test.properties");
            testProperties = new Properties();
            testProperties.load(testPropertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (testPropertiesFile != null)
                try {
                    testPropertiesFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getTestProperty(String key) {
        return testProperties.getProperty(key);
    }
}
