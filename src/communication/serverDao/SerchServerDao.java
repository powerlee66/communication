package communication.serverDao;

import java.util.List;

import communication.bean.Card;

public interface SerchServerDao {

	public List<Card>searchCardByConpanyName(String name);
	
	public List<Card>searchCardByKindName(String name);
	
	public List<Card>searchCardByName(String name);
	
	
}
