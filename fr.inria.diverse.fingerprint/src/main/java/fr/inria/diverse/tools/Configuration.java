package fr.inria.diverse.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import picocli.CommandLine.Model.ArgSpec;
import picocli.CommandLine.Model.OptionSpec;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public abstract class Configuration {

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
	protected static Configuration instance = null;

	public static Configuration getInstance() {
		return Configuration.instance;
	}
	
	
	// Getters
	public abstract int getThreadNumber();
	public abstract String getGraphPath() ;
	public abstract String getLoadingMode() ;
	public abstract String getExportPath() ;
	public abstract int getCheckPointIntervalInMinutes() ;


	@Override
	public String toString() {
		return "Configuration [getThreadNumber()=" + getThreadNumber() + ", getGraphPath()=" + getGraphPath()
				+ ", getLoadingMode()=" + getLoadingMode() + ", getExportPath()=" + getExportPath()
				+ ", getCheckPointIntervalInMinutes()=" + getCheckPointIntervalInMinutes() + "]";
	}
	
}
