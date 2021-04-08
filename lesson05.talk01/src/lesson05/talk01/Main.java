package lesson05.talk01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	
	public static List<String> readerFile(String path) {
		String text = null;
		List<String> ls = null;
		try (Reader reader = new FileReader(path)) {
			int read = reader.read();
			while(read != -1) {
				text += (char) read;
				read = reader.read();
			}
		} catch (IOException e) {
			System.out.print("Читения файла прервался " + e.getMessage());
		}
		String[] wordArray = text.split("[ .,]+");
		Set<String> wordsSet = new HashSet<String>(Arrays.asList(wordArray));
		ls = wordsSet.stream().sorted((a,b) -> a.toLowerCase().compareTo(b.toLowerCase())).collect(Collectors.toList());
		return ls;
	}
	
	
	public static void writerFile(String path, List<String> listWords) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
			listWords.forEach(a -> {
				try {
					writer.write(a);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			System.out.print("запис файла прервано");
		}
	}
	
	
	
	public static void main(String... args) {
		String source = "/home/c2dent/practic/java/lesson05.talk01/src/lesson05/talk01/Source.txt";
		String result = "/home/c2dent/practic/java/lesson05.talk01/src/lesson05/talk01/Result.txt";
		
		List<String> listWords = readerFile(source);
		
		writerFile(result, listWords);
		System.out.print("Прогамма завершился");
	}
}




