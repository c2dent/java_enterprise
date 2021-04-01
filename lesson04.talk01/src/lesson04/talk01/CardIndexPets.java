package lesson04.talk01;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CardIndexPets {
	public Set<Pet> cIPets = new HashSet<Pet>();
	
	public boolean addPet(Pet p) throws Exception {
		if (cIPets.contains(p)) {
			throw new Exception("Такое животные уже есть в картотеке");
		} else {
			cIPets.add(p);
			return true;
		}
	}
	
	public List<Pet> searchPetByNickname(String nick) {
		return cIPets.stream().filter((a) -> a.nickname.toLowerCase().contains(nick.toLowerCase())).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public void printSortedListPets() {
		cIPets.stream().sorted((a, b) -> {
			if (a.owner.getName().compareTo(b.owner.getName()) == 0) {
				if (a.nickname.compareTo(b.nickname) == 0) {
					return b.weight - a.weight;
				} else {
					return -a.nickname.compareTo(b.nickname);
				}
			} else {
				return -a.owner.getName().compareTo(b.owner.getName());
			}
		}).forEach(a -> System.out.println(a));
	}
	
	
	public void changePetById(int id, Consumer<Pet> cons) throws Exception {
		Optional<Pet> petOp = cIPets.stream().filter(a -> a.id == id).findFirst();
		
		if (petOp.isPresent()) {
			cons.accept(petOp.get());
		} else {
			throw new Exception("Нет животного с таким значениям id");
		}
	}

}
