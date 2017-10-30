package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import communication.bean.Classify;
import communication.bean.User;
import communication.dao.ClassifyDao;
import communication.util.Util;

public class ClassifyDaoImpl implements ClassifyDao {

	@Override
	public List<Classify> findClassifyByUser(User user) {
		List<Classify> list = new ArrayList<Classify>();

		String sql = "select * from classify where userid=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, user.getId());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Classify classify = new Classify();

				classify.setId(resultSet.getInt("id"));

				classify.setName(resultSet.getString("name"));

				classify.setNum(resultSet.getInt("num"));

				classify.setUser(new UserDaoImpl().findUserById(resultSet.getInt("userid")));

				list.add(classify);

				// ÃÍ³ÉÏó°Î°ö private String name;

				// private int num;
				//
				// private User user;

			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public boolean addClassify(Classify classify) {
		int a = 0;

		String sql = "insert into classify(name,num,userid) values(?,?,?)";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, classify.getName());

			preparedStatement.setInt(2, classify.getNum());

			preparedStatement.setInt(3, classify.getUser().getId());

			a = preparedStatement.executeUpdate();
		} catch (Exception e) {

		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Classify findById(int id) {
		Classify classify = new Classify();

		String sql = "select * from classify where id=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
		
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				classify.setId(resultSet.getInt("id"));

				classify.setName(resultSet.getString("name"));

				classify.setNum(resultSet.getInt("num"));

				classify.setUser(new UserDaoImpl().findUserById(resultSet.getInt("userid")));
			}
		} catch (Exception e) {

		}
		return classify;
	}

	@Override
	public boolean updateClassify(Classify classify) {
		String sql = "update classify set name=?,num=?,userid=? where id=?";
		
		int a = 0;
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, classify.getName());

			preparedStatement.setInt(2, classify.getNum());

			preparedStatement.setInt(3, classify.getUser().getId());

			preparedStatement.setInt(4, classify.getId());

			a = preparedStatement.executeUpdate();

		} catch (Exception e) {

		}

		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean delete(int id) {

		String sql = "delete from classify where id=?";
		
		int a = 0;
				
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			a = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (a>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteClassifyByUser(User user){
		int a = 0;
		
		String sql = "delete from classify where userid=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, user.getId());
			
			a = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (a>0) {
			return true;
		}else {
			return false;
		}
	}

}
