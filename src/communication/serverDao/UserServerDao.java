package communication.serverDao;

import communication.bean.User;

public interface UserServerDao {
	public User login(User user);
	
	public boolean resgister(User user);//没电了，先不写。。。。
	
	public boolean remove(User user);
}
