package fr.inria.diverse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public String defaultValue(ArgSpec argSpec) {

        if (properties == null) {
            properties = new Properties();

            try (InputStream stream = App.class.getClassLoader().getResourceAsStream("defaultConfig.properties")) {

                try (Reader reader = new InputStreamReader(stream)) {
                    properties.load(reader);
                } catch (Exception e) {
                    logger.info(e.toString());
                }
            } catch (Exception e) {
                logger.info(e.toString());
            }

        }
        String key = (argSpec.isOption()
                ? ((OptionSpec) argSpec).longestName()
                : argSpec.paramLabel()).replace("-", "");
        return properties.getProperty(key);
    }

}
