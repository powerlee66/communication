package communication.serverDaoImpl;

import java.util.List;

import communication.bean.Classify;
import communication.bean.Collection;
import communication.bean.User;
import communication.dao.impl.ClassifyDaoImpl;
import communication.dao.impl.CollectionDaoImpl;
import communication.serverDao.ShowServerDao;

public class ShowServerDaoImpl implements ShowServerDao {

	@Override
	public List<Classify> showClassify(User user) {
		
		return new ClassifyDaoImpl().findClassifyByUser(user);
	}

	@Override
	public List<Collection> showCollection(String name) {
		
		Classify classify = new Classify();
		
		classify.setName(name);
		
		return new CollectionDaoImpl().findByclassifyName(classify);
	}

}
