package fr.inria.diverse;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

import picocli.CommandLine.IDefaultValueProvider;
import picocli.CommandLine.Model.ArgSpec;
import picocli.CommandLine.Model.OptionSpec;

public class BundlePropertiesDefaultProvider implements IDefaultValueProvider {

    private Properties properties;
    private static Logger logger = Logger.getLogger(BundlePropertiesDefaultProvider.class.getName());

    @Override
    public String defaultValue(ArgSpec argSpec){

        if (properties == null) {
            properties = new Properties();
            try {

                File file = Paths.get("./resources", "defaultConfig.properties").toFile();
                try (Reader reader = new FileReader(file)) {
                    properties.load(reader);
                } catch (Exception e) {
                    logger.info(e.toString());
                }
            } catch (Exception e) {
                logger.info(e.toString());
            }

        }
        logger.info(properties.toString());
        // logger.info(argSpec.toString());
        String key = argSpec.isOption()
                ? ((OptionSpec) argSpec).longestName()
                : argSpec.paramLabel();
        return properties.getProperty(key);
    }

}
