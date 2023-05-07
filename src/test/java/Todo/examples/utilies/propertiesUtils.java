package Todo.examples.utilies;

import java.io.*;
import java.util.Properties;

public class propertiesUtils {

    public static Properties loadProperties(String filePath) {
        File file=new File(filePath);
        try {
            InputStream inputStream=new FileInputStream(file);
            Properties properties =new Properties();
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file is not found");
        } catch (IOException e) {
            throw new RuntimeException("error while loading");
        }


    }
}
