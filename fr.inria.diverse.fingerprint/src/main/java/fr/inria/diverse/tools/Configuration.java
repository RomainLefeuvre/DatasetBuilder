package fr.inria.diverse.tools;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	public abstract int getThreadNumber();

	public Path getGraphPath() {
		return Paths.get(getGraphFolderPath().toString(), "/compressed/graph");
	}

	public Path getRelationalPath() {
		return Paths.get(getGraphFolderPath().toString(), "/orc/");
	}

	public ZonedDateTime getGraphTimestamp() {
		ZonedDateTime graphDate = ToolBox.extractDate(this.getGraphFolderPath().getFileName().toString());
		// Take 7 days of guarentee;
		return graphDate.minusDays(1);
	};

	public abstract ZonedDateTime getQueryTimestamp();

	protected abstract Path getGraphFolderPath();

	public abstract String getLoadingMode();

	public abstract Path getExportPath();

	public abstract int getCheckPointIntervalInMinutes();

	@Override
	public String toString() {
		return "Configuration [getThreadNumber()=" + getThreadNumber() + ", getGraphPath()=" + getGraphPath()
				+ ", getRelationalPath()=" + getRelationalPath() + ", getGraphTimestamp()=" + getGraphTimestamp()
				+ ", getQueryTimestamp()=" + getQueryTimestamp() + ", getGraphFolderPath()=" + getGraphFolderPath()
				+ ", getLoadingMode()=" + getLoadingMode() + ", getExportPath()=" + getExportPath()
				+ ", getCheckPointIntervalInMinutes()=" + getCheckPointIntervalInMinutes() + "]";
	}

}
