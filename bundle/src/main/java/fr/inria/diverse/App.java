package fr.inria.diverse;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.inria.diverse.requests.SwhClient;
import fr.inria.diverse.utils.FileUtils;
import fr.inria.model.CookingStatus;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "BundleRequester", description = "Request for revision from a json file containing a list of snapshots", footer = "DIVERSE team - Inria", defaultValueProvider = BundlePropertiesDefaultProvider.class)
public class App implements Runnable {
    static Logger logger = LogManager.getLogger(App.class);

    @Option(names = { "-i",
            "--input" }, description = "Input file containing the list of snapshots to request", required = true)
    private String inputFile;

    @Option(names = { "-o",
            "--output" }, description = "Output folder where the revisions will be placed", required = true)
    private String outputFolder;

    @Option(names = { "-t", "--token" }, description = "token to use when requesting to the SWH api", required = false)
    private String token;

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Option(names = { "-d",
            "--delay" }, description = "delay between the requests to cook and the requests to receive in seconds", required = false)
    private int delay;

    @Option(names = { "-b",
            "--bundle" }, description = "bundle type to request (gitfast, git, flat)", required = false)
    private String bundleType;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);

    }

    @Override
    public void run() {

        //IMPORTING THE MAP//
        logger.info("Importing from file " + inputFile);
        Map<String, List<String>> importMap;
        try {
            importMap = FileUtils.importMapFromFilePath(inputFile);
        } catch (FileNotFoundException e) {
            logger.error("File not found", e);
            return;
        }

        //CREATING THE CLIENT//
        SwhClient swhClient = new SwhClient(token);
        logger.info("Delay = " + delay);
        logger.info("Output folder = " + outputFolder);
        logger.info("Token = " + token);
        logger.info("Bundle type = " + bundleType);

        //REQUESTING THE REVISIONS//
        logger.info("Requesting revisions from import map...");
        List<String> revisionsIDs = swhClient.requestRevisionsFromSwhImportMap(importMap);

        //REQUESTING THE COOKING//
        logger.info("Requesting cooking for revisions...");
        List<CookingStatus> status = swhClient.requestCooking(bundleType,
                revisionsIDs);

        //DOWNLOADING THE COOKED BUNDLES//
        logger.info("downloading already cooked bundles...");

        swhClient.DownloadCookedIfReady(bundleType, status.stream()
                .filter(s -> s.getStatus() == CookingStatus.Status.DONE)
                .map(s -> s.getSwhid())
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll), outputFolder);

        //STARTING THE DOWNLOAD OF THE REMAINING BUNDLES//
        LinkedList<String> remainingRevisionsToCook = status.stream()
                .filter(s -> s.getStatus() != CookingStatus.Status.DONE)
                .map(s -> s.getSwhid()).collect(LinkedList::new, LinkedList::add,
                        LinkedList::addAll);

        while (!remainingRevisionsToCook.isEmpty()) {
            try {
                logger.info("Waiting for " + delay + " seconds");
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                logger.warn("program interrupted");
            }

            remainingRevisionsToCook = (LinkedList<String>) swhClient.DownloadCookedIfReady(bundleType,
                    remainingRevisionsToCook, outputFolder);
            logger.info(remainingRevisionsToCook.size() + " bundles remaining");

        }
        logger.info("All bundles have been downloaded");
        System.exit(0);
    }

}
