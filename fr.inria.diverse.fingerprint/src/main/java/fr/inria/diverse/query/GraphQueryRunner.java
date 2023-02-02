package fr.inria.diverse.query;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.inria.diverse.tools.Configuration;
import it.unimi.dsi.fastutil.Arrays;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.PropertiesDefaultProvider;
import picocli.CommandLine.Option;
@Command(
	name="GraphQueryRunner",
	description="Execute a query over the graph property dataset",
	footer = "Romain Lefeuvre - DIVERSE team - Inria"
)
public class GraphQueryRunner extends Configuration implements Runnable  {
	static Logger logger = LogManager.getLogger(GraphQueryRunner.class);
	private CommandLine cmd;
	@Option(names = {"--graphPath","-g"},description = "The graph path", required = true)
	private String graphPath;
	@Option(names = {"--threadNumber","-t"},description = "The number of thread the query will use")
	private int threadNumber;
	@Option(names = {"--exportPath","-e"},description = "The export path, where all the queries results will be saved including checkpoints")
	private String exportPath;
	@Option(names = {"--loadingMode","-l"}, description = "The graph loading mode either MAPPED for memory mapped or RAM for ram loading")
	private  String loadingMode;
	@Option(names = {"--checkPointIntervalInMinutes","-c"}, description ="The time in minutes after which a checkpoint will be produced")
	private  int checkPointIntervalInMinutes;
	@Option(names = {"--help","-h"}, usageHelp = true, description = "display this help and exit")
	boolean help;
	
	public String getGraphPath() {
		return graphPath;
	}

	public int getThreadNumber() {
		return threadNumber;
	}
	
	public String getExportPath() {
		return exportPath;
	}


	public String getLoadingMode() {
		return loadingMode;
	}

	public int getCheckPointIntervalInMinutes() {
		return checkPointIntervalInMinutes;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		init(args);
        //Set<Long> queryResult = new GraphQuery().runQuery();
        
    }
	
	public static void init(String[] args) {
		GraphQueryRunner gqr = new GraphQueryRunner();
		gqr.cmd = new CommandLine(gqr);
		File defaultsFile = Paths.get(DEFAULT_URI,Configuration.CONFIG_FILE_NAME).toFile();
		gqr.cmd.setDefaultValueProvider(new PropertiesDefaultProvider(defaultsFile));
		Configuration.instance = gqr;
		gqr.cmd.execute(args);
	}

	@Override
	public void run() {
		logger.info(this);
		try {
			(new GraphQuery()).runQuery();
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