package talk02;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox<T> {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectBox<?> other = (ObjectBox<?>) obj;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		return true;
	}

	List<T> objects = new ArrayList<T>();
	
	public void addObject(T o) {
		objects.add(o);
	}
	
	public boolean deleteObject(T o) {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.contains(o)) {
				objects.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return objects.toString();
	}
}
