package fr.inria.diverse.query;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.inria.diverse.Graph;
import fr.inria.diverse.tools.Configuration;
import fr.inria.diverse.tools.ToolBox;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.PropertiesDefaultProvider;

@Command(name = "GraphQueryRunner", description = "Execute a query over the graph property dataset", footer = "Romain Lefeuvre - DIVERSE team - Inria")
public class GraphQueryRunner extends Configuration implements Runnable {
	static Logger logger = LogManager.getLogger(GraphQueryRunner.class);
	private CommandLine cmd;
	@Option(names = { "--queryTimestamp", "-qt" }, description = "The  query Timestamp")
	private String queryTimestamp;
	@Option(names = { "--graphPath", "-g" }, description = "The graph Folder path", required = true)
	private String graphFolderPath;
	@Option(names = { "--threadNumber", "-t" }, description = "The number of thread the query will use")
	private int threadNumber;
	@Option(names = { "--exportPath",
			"-e" }, description = "The export path, where all the queries results will be saved including checkpoints")
	private String exportPath;
	@Option(names = { "--loadingMode",
			"-l" }, description = "The graph loading mode either MAPPED for memory mapped or RAM for ram loading")
	private String loadingMode;
	@Option(names = { "--checkPointIntervalInMinutes",
			"-c" }, description = "The time in minutes after which a checkpoint will be produced")
	private int checkPointIntervalInMinutes;
	@Option(names = { "--help", "-h" }, usageHelp = true, description = "display this help and exit")
	boolean help;

	public ZonedDateTime getQueryTimestamp() {
		if (queryTimestamp != null) {
			return ToolBox.extractDate(queryTimestamp);
		} else {
			return this.getGraphTimestamp();
		}
	}

	protected Path getGraphFolderPath() {
		return Paths.get(this.graphFolderPath);
	}

	public int getThreadNumber() {
		return threadNumber;
	}

	public Path getExportPath() {
		return Paths.get(exportPath);
	}

	public String getLoadingMode() {
		return loadingMode;
	}

	public int getCheckPointIntervalInMinutes() {
		return checkPointIntervalInMinutes;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		GraphQueryRunner gqr = new GraphQueryRunner();
		gqr.init();
		gqr.execute(args);

		// Set<Long> queryResult = new GraphQuery().runQuery();

	}

	public void init() {
		cmd = new CommandLine(this);
		File defaultsFile = Paths.get(DEFAULT_URI, Configuration.CONFIG_FILE_NAME).toFile();
		cmd.setDefaultValueProvider(new PropertiesDefaultProvider(defaultsFile));
		Configuration.instance = this;

	}

	public void execute(String[] args) {
		this.cmd.execute(args);

	}

	@Override
	public void run() {
		logger.info(this);
		try {
			Graph g = new Graph();
			g.init();
			Set<Long> matchedOrigin = (new GraphQuery(g)).runQuery();
			g.exportOriginUri(matchedOrigin, Paths.get(Configuration.getInstance().getExportPath().toString(),
					GraphQuery.id, "origin_url_snap_swhid.json").toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}