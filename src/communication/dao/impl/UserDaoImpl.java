package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import communication.bean.User;
import communication.dao.UserDao;
import communication.util.Util;

public class UserDaoImpl implements UserDao {

	@Override
	public User userLogin(String name, String password) {
		String sql = "select * from user where name=? and password=?";

		User user = new User();
		try {

			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, name);

			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				
				user.setId(resultSet.getInt("id"));
				
				user.setName(name);
				
				user.setPassword(password);
				
				
			} else {
			
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		if (user.getId()!=0) {
			
			
			System.out.println("进入if");
			
			System.out.println(user.getId());
			return user;
			
		}else {
			System.out.println("进入else");
			return null;
		}
	}

	@Override
	public boolean userRegister(String name, String password) {
		
		if (isSame(name)) {
			
			return false;
		
		}else {
			
			String sql = "insert into user(name,password) values(?,?)";
			
			try {
				
				PreparedStatement preparedStatement = new Util().getConnection().prepareCall(sql);
				
				preparedStatement.setString(1, name);
				
				preparedStatement.setString(2, password);
				
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return true;

		}
		
	}

	@Override
	public boolean userRemove(User user) {
		String sql = "delete from user where id=?";
		
		int a = 0;
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, user.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (a>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public User findUserById(int id) {
		User user = new User();
		
		String sql = "select * from user where id=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
		
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				user.setId(id);
				
				user.setName(resultSet.getString("name"));
				
				user.setPassword(resultSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return user;
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> list = new ArrayList<User>();
				
		String sql = "select * from user where name = ?";
		
		try {
			
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				
				user.setName(resultSet.getString("name"));
				
				user.setPassword(resultSet.getString("password"));
				
				list.add(user);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
	}

	private boolean isSame(String name) {
		String sql = "select * from user where name=?";
		try {

			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return true;

			} else {

				return false;

			}
		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

	}
	
	public boolean updatePassword(String newpassword,User user){
		int a = 0;
		
		String sql = "update user set password=? where id=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, newpassword);
			
			preparedStatement.setInt(2, user.getId());
			
			a = preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if (a>0) {
			return true;
		}else {
			return false;
		}
	}

}
