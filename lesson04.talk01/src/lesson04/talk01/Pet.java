package lesson04.talk01;

public class Pet {
	static int identification = 0;
	public int id;
	public String nickname;
	public Person owner;
	public int weight;
	
	
	public Pet(String nickname, Person owner, int weight) {
		identification += 1;
		id = identification;
		this.nickname = nickname;
		this.owner = owner;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "id = " + id + ", nickname = " + nickname + ", owner = [" + owner + "], weight = " + weight;
	}
	
}