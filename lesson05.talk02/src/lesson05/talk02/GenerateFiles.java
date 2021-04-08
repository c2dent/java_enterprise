package lesson05.talk02;

import java.io.*;

public class GenerateFiles {
	
	
	private static int generateNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	private static String generateSentence(int countWords, String[] words) {
		String sentence = "";
		String[] signs = {".", "!", "?", "."};
		String[] comma = {"", "", "", "", ",",""};
	
		for (int i = 0; i < countWords; i++) {
			if (i == countWords -1) {
				sentence += words[generateNumber(0, words.length -1)] + signs[generateNumber(0,2)];
			} else {
				sentence += words[generateNumber(0, words.length -1)] + comma[generateNumber(0,5)] + " ";
			}
		}
		sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
		
		return sentence;
	}
	
	private static String generateMultiSentence (int size, String[] words) throws Exception {
		Boolean b = true;
		String sentence = "";
		String tmp = "";
		
		
		while (b) {
			tmp = generateSentence((((size * 0.8) / 15) < 15) ? generateNumber(1, (int)((size * 0.8) / 15)) : generateNumber(1, 15), words);
			
			if(sentence.getBytes().length + tmp.getBytes().length < size) {
				sentence += (generateNumber(1,15) == 10) ? "\n\t" + tmp : " " + tmp;
			} else {
				b = false;
			}
		}
		
		return sentence;	
	}
	
	
	public static void getFiles(String path, int n, int size, String[] words) throws Exception { 				
		if (size < 20) {
			throw new Exception("Рармер не должно быт менше 20");
		}
		if (words == null || words.length == 0) {
			throw new Exception("Массив слов не должно быт пустой или null");
		}
		
		String text = generateMultiSentence(size, words);
		text = text + new String(new char[size - text.getBytes().length]).replace("\0", " ");

		for (int i = 0; i < n; i++) {
			
			try(RandomAccessFile raf = new RandomAccessFile(new File(path + "/text" + (i + 1) + ".txt"), "rws")) {
				raf.setLength(size);
				raf.write(text.getBytes());
			} catch (IOException e) {
				throw new IOException("Запис файла прервано");
			}
		}
		
		System.out.println("Файлы сгенерировано!");
	}
}
