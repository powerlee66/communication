package communication.dao;

import java.util.List;

import communication.bean.Classify;

import communication.bean.Collection;

public interface CollectionDao {

	public Collection findById(int id);
	
	public List<Collection> findByclassifyName(Classify classify);
	
	
}
