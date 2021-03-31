package lesson03.talk01;

import java.util.*;

public class CardIndexPets {
	public Set<Pet> cIPets = new TreeSet<Pet>();
	
	public boolean addPet(Pet p) throws Exception {
		if (cIPets.contains(p)) {
			throw new Exception("Такое животные уже есть в картотеке");
		} else {
			cIPets.add(p);
			return true;
		}
	}
	
	public List<Pet> seachByNickname(String nickname) {
		List<Pet> pets = new ArrayList<>();
		for (Pet p: cIPets) {
			if(p.nickname.toLowerCase().contains(nickname.toLowerCase())) {
				pets.add(p);
			}
		}
		return pets;
	}
	
	public void changePetById(int id, Person owner) throws Exception {
		for (Pet p: cIPets) {
			if (p.id == id) {
				p.owner = owner;
				break;
			} else {
				throw new Exception("Животные с таким id нету");
			}
		}
	}
	
	public void changePetById(int id, Person owner, String nickname) throws Exception {
		for (Pet p: cIPets) {
			if (p.id == id) {
				p.owner = owner;
				p.nickname = nickname;
			} else {
				throw new Exception("Животные с таким id нету");
			}
		}
	}

	public void changePetById(int id, Person owner, String nickname, int weight) throws Exception {
		for (Pet p: cIPets) {
			if (p.id == id) {
				p.owner = owner;
				p.nickname = nickname;
				p.weight = weight;
			} else {
				throw new Exception("Животные с таким id нету");
			}
		}
	}
	
	public void printCardPets() {
		for (Pet p: cIPets) {
			System.out.println(p);
		}
	}
}
