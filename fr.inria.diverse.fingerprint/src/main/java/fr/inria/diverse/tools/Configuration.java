package fr.inria.diverse.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {

	/**
	 * FILENAME is the file location of the configuration JSON file
	 *
	 * @todo Potentially make this configurable
	 */
	public static final String CONFIG_FILE_NAME = "config.properties";
	public static final String DEFAULT_URI = "./config";
	static Logger logger = LogManager.getLogger(Configuration.class);
	/**
	 * The instance of Configuration that this Class is storing
	 */
	private static Configuration instance = null;
	// Config Attributes
	private final int threadNumber;
	private final String graphPath;
	private final String loadingMode;
	private final String swhToken;
	private final String exportPath;
	private final int checkPointIntervalInMinutes;

	private Configuration(String configUri) {
		Properties props = new Properties();
		try (InputStream input = new FileInputStream(Paths.get(configUri, CONFIG_FILE_NAME).toFile())) {
			if (input == null) {
				throw new RuntimeException("unable to find config.properties");
			}
			props.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Error while loading config file", e);
		}
		this.threadNumber = Integer.parseInt(props.getProperty("threadNumber"));
		this.graphPath = props.getProperty("graphPath");
		this.loadingMode = props.getProperty("loadingMode");
		this.swhToken = props.getProperty("swhToken");
		this.exportPath = props.getProperty("exportPath");
		this.checkPointIntervalInMinutes = Integer.parseInt(props.getProperty("checkPointIntervalInMinutes"));

	}

	public static void init(String uri) {
		if (Configuration.instance == null) {
			Configuration.instance = new Configuration(uri.equals("") ? DEFAULT_URI : uri);
		} else {
			logger.warn("Init not done since configuration is already init");
		}
	}

	public static void init() {
		if (Configuration.instance == null) {
			Configuration.instance = new Configuration(DEFAULT_URI);
		} else {
			logger.warn("Init not done since configuration is already init");
		}
	}

	public static Configuration getInstance() {

		return Configuration.instance;
	}

	// Getters
	public int getThreadNumber() {
		return threadNumber;
	}

	public String getGraphPath() {
		return graphPath;
	}

	public String getLoadingMode() {
		return loadingMode;
	}

	public String getSwhToken() {
		return swhToken;
	}

	public String getExportPath() {
		return exportPath;
	}

	public int getCheckPointIntervalInMinutes() {
		return checkPointIntervalInMinutes;
	}
}
