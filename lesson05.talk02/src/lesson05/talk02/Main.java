package lesson05.talk02;

public class Main {
	public static void main(String[] args) {
		String[] str = {"attention", "audience", "avoid", "back", "become", "behind", "body", "building", "candidate", "center", "choice", "course",
				"data", "daughter", "deep", "development", "die", "economic", "election", "explain", "finally", "foot", "great", "hand", "herself"};
		
		String path = "/home/c2dent/practic/java/lesson05.talk02/src/lesson05/talk02/files";
		try {
			GenerateFiles.getFiles(path, 2, 500, str);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
