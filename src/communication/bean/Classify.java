package communication.bean;

public class Classify {

	private int id;
	
	private String name;
	
	private int num;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Classify(int id, String name, int num, User user) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.user = user;
	}

	public Classify() {
		super();
	}
	
	
}
