package lesson03.talk01;

public class Pet implements Comparable<Pet>{
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + weight;
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
		Pet other = (Pet) obj;
		if (id != other.id)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}




	@Override
	public int compareTo(Pet p) {
		if (this.owner.getName().compareTo(p.owner.getName()) > 0) {
			return -1;
		} else if (this.owner.getName().compareTo(p.owner.getName()) < 0) {
			return 1;
		} else {
			if (this.nickname.compareTo(p.nickname) > 0) {
				return -1;
			} else if (this.nickname.compareTo(p.nickname) < 0) {
				return 1;
			} else {
				if (this.weight > p.weight) {
					return -1;
				} else if (this.weight < p.weight) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "id = " + id + ", nickname = " + nickname + ", owner = [" + owner + "], weight = " + weight;
	}
}
