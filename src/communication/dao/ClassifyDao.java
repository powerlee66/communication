package communication.dao;

import java.util.List;

import communication.bean.Classify;
import communication.bean.User;

public interface ClassifyDao {

	public List<Classify> findClassifyByUser(User user);
	
	public boolean addClassify(Classify classify);
	
	public Classify findById(int id);
	
	public boolean updateClassify(Classify classify);
}
