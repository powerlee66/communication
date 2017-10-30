package communication.serverDaoImpl;

import communication.bean.User;
import communication.dao.impl.UserDaoImpl;
import communication.serverDao.UserServerDao;

public class UserServerDaoImpl implements UserServerDao {

	@Override
	public User login(User user) {
		
		return new UserDaoImpl().userLogin(user.getName(), user.getPassword());
	}

	@Override
	public boolean resgister(User user) {
		
		return new UserDaoImpl().userRegister(user.getName(), user.getPassword());
	}

	@Override
	public boolean remove(User user) {
		
		return new UserDaoImpl().userRemove(user);
	}

}
