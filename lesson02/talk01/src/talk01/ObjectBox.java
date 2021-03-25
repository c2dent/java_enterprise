package talk01;

import java.util.List;

public class ObjectBox<T> {
	
	List<T> objects;
	
	public void addObject(T o) {
		objects.add(o);
	}
	
	public boolean deleteObject(T o) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.equals(o)) {
				objects.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String dump() {
		return objects.toString();
	}
}
