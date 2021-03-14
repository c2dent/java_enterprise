package talk03;

public class SortingPerson02 implements Sorting {
	
	private void swap(Person[] persons, int index1, int index2) {
		Person tmpPerson = persons[index1];
		persons[index1] = persons[index2];
		persons[index2] = tmpPerson;
	}	
	
	private void sortPersonByAgeAndAlf(Person[] persons, int index1, int index2) throws CoincidenceNameAgeException, NullPointerException {
		for (int i = index1; i < index2; i++) {
			for (int j = i; j < index2; j++) {
				if (persons[j].age > persons[i].age) {
					swap(persons, i, j);
				} else if (persons[j].age == persons[i].age) {
					if (persons[i].name.compareTo(persons[j].name ) > 0) {
						swap(persons, i, j);
					} else if (persons[i].name.compareTo(persons[j].name ) == 0) {
						throw new CoincidenceNameAgeException();
					}
				} else {
					continue;
				}
			}
		}
	}
	
	private void sortPersonBySex(Person[] persons) throws NullPointerException {
		int i = 0;
		int index = -1;
		boolean endCycle = false;
		boolean endSort = false;
		do {
			if (persons[i].sex == Sex.WOMEN) {
				if (index == -1) {
					index = i;
				}
			} else {
				if (index > -1) {
					swap(persons, index, i);
					endCycle = true;
				}
			}
			
			if (i + 1 < persons.length) {
				i++;
			} else {
				endCycle = true;
				endSort = true;
			}
		} while(!endCycle);
		
		if (!endSort) {
			sortPersonBySex(persons);
		}
	}
	

	public void sortPerson (Person[] persons) throws CoincidenceNameAgeException, NullPointerException {
		int firstWomenIndex = -1;
		sortPersonBySex(persons);
		
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].sex == Sex.WOMEN) {
				firstWomenIndex = i;
				break;
			}
		}
		
		if (firstWomenIndex == 0 || firstWomenIndex == -1) {
			sortPersonByAgeAndAlf(persons, 0, persons.length);
		} else {
			sortPersonByAgeAndAlf(persons, 0, firstWomenIndex);
			sortPersonByAgeAndAlf(persons, firstWomenIndex, persons.length);
		}
	}
	
}