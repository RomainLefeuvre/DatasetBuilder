package fr.inria.diverse.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hadoop.fs.FileUtil;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.labels.DirEntry;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

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
		return Files.exists(filePath);
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

	public static List<File> getFilePathEndingWith(String folder, String pattern) throws IOException {
		return Arrays.stream(FileUtil.listFiles(new File(folder))).filter(f -> f.getPath().endsWith(pattern))
				.collect(Collectors.toList());

	}

	/**
	 * Parse a date YYYY-MM-DD at the beginning of a string a return a ZonedDateTime
	 * 
	 * @param string
	 * @return ZonedDateTime
	 */
	public static ZonedDateTime extractDate(String string) {
		String[] split = string.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		return ZonedDateTime.of(year, month, day, 0, 0, 0, 0, ZoneId.of("Europe/Paris"));

	};

}
