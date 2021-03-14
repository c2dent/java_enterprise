package talk03;

public class SortingPerson01 {
	
	public void sortPerson (Person[] persons) throws CoincidenceNameAgeException, NullPointerException {
		for (int i = 0; i < persons.length; i++) {
				for (int j = i; j < persons.length; j++) {
					
					Person tmpPerson;
					if (persons[i].sex == Sex.WOMEN && persons[j].sex == Sex.MAN) {
						tmpPerson = persons[i];
						persons[i] = persons[j];
						persons[j] = tmpPerson;
					} else if((persons[i].sex == Sex.MAN && persons[j].sex == Sex.MAN) || (persons[i].sex == Sex.WOMEN && persons[j].sex == Sex.WOMEN) ) {
						if (persons[i].age < persons[j].age) {
							tmpPerson = persons[i];
							persons[i] = persons[j];
							persons[j] = tmpPerson;
							
						} else if (persons[i].age == persons[j].age) {
							if (persons[i].name.compareTo(persons[j].name) > 0) {
								tmpPerson = persons[i];
								persons[i] = persons[j];
								persons[j] = tmpPerson;
							} else if (persons[i].name.compareTo(persons[j].name) == 0) {
								throw new CoincidenceNameAgeException();
							}
						}
						else {
							continue;
						}
					} else {
						continue;
					}
				}
		}
	}
}
