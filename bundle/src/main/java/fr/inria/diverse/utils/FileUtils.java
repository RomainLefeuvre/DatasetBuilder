package fr.inria.diverse.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class FileUtils {
    static Logger logger = LogManager.getLogger(FileUtils.class);

    public static Map<String, List<String>> importMapFromFilePath(String inputFile) throws FileNotFoundException {

        Gson gson = new Gson();
        JsonReader reader;
        reader = new JsonReader(new FileReader(Paths.get(inputFile).toString()));

        return gson.fromJson(reader, Map.class);

    }

    private boolean writeFile(String outputFolder, byte[] bytes) {
        try {
            File outputFile = new File(outputFolder);
            if (!outputFile.exists()) {
                outputFile.mkdirs();
            }
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(bytes);
            outputStream.close();
            return true;
        } catch (IOException e) {
            logger.error("Error writing file to output folder: " + outputFolder, e);
            return false;
        }
    }

}
