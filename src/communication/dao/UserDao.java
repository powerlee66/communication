package communication.dao;

import java.util.List;

import communication.bean.User;

public interface UserDao {

	public User userLogin(String name,String password);//登陆
	
	public boolean userRegister(String name,String password);//注册
	
	public boolean userRemove(User user);//注销用户
	
	public User findUserById(int id);//通过id查找用户
	
	public List<User> findUserByName(String name);//通过名字查找用户
	
}
