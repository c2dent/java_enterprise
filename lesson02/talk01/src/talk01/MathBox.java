package talk01;

import java.util.*;

public class MathBox <T extends Number> {
	
	List<Number> nums;
	MathBox(T[] nums) {
		this.nums = new ArrayList<Number>(new HashSet<>(Arrays.asList(nums)));
	}
	
	public Double summator() {
		Double summ = 0d;
		for (Number num: nums) {
			summ += num.doubleValue();
		}
		return summ;
	}
	
	public List<Number> splitter (T del) throws NullPointerException {
		for (int i = 0; i < nums.size(); i++) {
			nums.set(i, nums.get(i).doubleValue()/((Number)del).doubleValue());
		}
		return nums;
	}
	
	
	public boolean remove(Integer n) {
		for (int i = 0; i < nums.size(); i++)  {
			if(nums.get(i).equals(n)) {
				nums.remove(i);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nums == null) ? 0 : nums.hashCode());
		
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
		MathBox<?> other = (MathBox<?>) obj;
		if (nums == null) {
			if (other.nums != null)
				return false;
		} else if (!nums.equals(other.nums))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return nums.toString() + " Сумма коллекции = " + summator();
	}
	
	
	
}
