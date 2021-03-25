package talk02;

import java.util.*;

public class MathBox <T extends Number> extends ObjectBox<Number> {
	
	MathBox(T[] nums) {
		super.objects = new ArrayList<Number>(new HashSet<>(Arrays.asList(nums)));
	}
	
	public Double summator() {
		Double summ = 0d;
		for (Number num: objects) {
			summ += num.doubleValue();
		}
		return summ;
	}
	
	public List<Number> splitter (T del) throws NullPointerException {
		for (int i = 0; i < objects.size(); i++) {
			objects.set(i, (Number)(objects.get(i).doubleValue()/((Number)del).doubleValue()));
		}
		return objects;
	}
	
	
}
