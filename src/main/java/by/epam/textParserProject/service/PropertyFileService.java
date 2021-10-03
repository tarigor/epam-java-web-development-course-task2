package by.epam.textParserProject.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Service provides getting data from property file located in resources folder
 *
 * @author Igor Taren
 */
public class PropertyFileService {
    private final Properties properties;
    private InputStream inputStream;

    public PropertyFileService() {
        this.properties = new Properties();
    }

    /**
     * Method get data from property file
     *
     * @param propertyFileName path name of property file
     * @return instance of property
     */
    public Properties readFromPropertyFile(String propertyFileName) {
        inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
        if (inputStream != null) {
            try {
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
