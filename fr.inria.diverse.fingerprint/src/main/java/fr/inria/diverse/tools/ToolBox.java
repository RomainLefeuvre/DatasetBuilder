package fr.inria.diverse.tools;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.labels.DirEntry;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolBox {
	public static <T> T loadJsonObject(String fileName, Type type) {
		Gson gson = new Gson();
		try (Reader reader = Files.newBufferedReader(Paths.get(fileName))) {
			return gson.fromJson(reader, type);

		} catch (IOException e) {
			throw new RuntimeException("Error while loading", e);
		}
	}

	/**
	 * Export an object of Type T to a json file named filename+".json"
	 *
	 * @param objectToSave the object you want to save
	 * @param filename     its filename
	 * @param <T>          the type of objectToSave
	 */
	public static <T> void exportObjectToJson(T objectToSave, String filename) {
		try {
			createParentIfNeeded(filename);
		} catch (IOException e) {
			throw new RuntimeException("Error while creating parent folder", e);
		}
		try (FileWriter f = new FileWriter(filename)) {
			Gson gson = new Gson();
			gson.toJson(objectToSave, f);
		} catch (IOException e) {
			throw new RuntimeException("Error while saving", e);
		}
	}

	public static <T> void serialize(T objectToSave, String filename) {

		try {
			createParentIfNeeded(filename);
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(objectToSave);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			throw new RuntimeException("Error while serializing " + filename, e);
		}
	}

	public static <T> T deserialize(String filename) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			T object = (T) objectInputStream.readObject();
			objectInputStream.close();
			return object;
		} catch (FileNotFoundException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException("Error while deserializing " + filename, e);
		}

	}

	public static void createParentIfNeeded(String path) throws IOException {
		Path filePath = Paths.get(path);
		Path parentDir = filePath.getParent();
		if (!Files.exists(parentDir))
			Files.createDirectories(parentDir);
	}
	
	public static boolean checkIfExist(String path) {
		Path filePath = Paths.get(path);
		Path parentDir = filePath.getParent();
		return Files.exists(parentDir);
	}

	public static String getFileName(DirEntry labelId, SwhUnidirectionalGraph graphCopy) {
		return new String(graphCopy.getLabelName(labelId.filenameId));
	}

	public static List<List<String>> readCsv(String uri) {
		List<List<String>> records = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader(uri));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				records.add(Arrays.asList(values));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
		return records;
	}

}
