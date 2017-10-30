package communication.bean;

public class Card {

	private int id;
	
	private User user;
	
	private String name;
	
	private Company company;
	
	private String add;
	
	private String tel;
	
	private String image;
	
	private String email;
	
	private Kind kind;
	
	private int state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Card(int id, User user, String name, Company company, String add, String tel, String image, String email,
			Kind kind, int state) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.company = company;
		this.add = add;
		this.tel = tel;
		this.image = image;
		this.email = email;
		this.kind = kind;
		this.state = state;
	}

	public Card() {
		super();
	}
	
	
}
