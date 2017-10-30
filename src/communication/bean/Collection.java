package communication.bean;

public class Collection {

	private int id;
	
	private Card card;
	
	private Classify classify;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public Collection(int id, Card card, Classify classify) {
		super();
		this.id = id;
		this.card = card;
		this.classify = classify;
	}

	public Collection() {
		super();
	}
	
	
}
