package communication.serverDao;

import java.util.List;

import communication.bean.Classify;
import communication.bean.Collection;
import communication.bean.User;


/**
 * @author power
 *
 */
public interface ShowServerDao {

	public List<Classify> showClassify(User user);
	
	public List<Collection> showCollection(String name);
	
	
	
	
}
