package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import communication.dao.SuperUserDao;
import communication.util.Util;

public class SuperUserDaoImpl implements SuperUserDao {

	@Override
	public boolean userLogin(String name, String password) {
		String sql = "select * from superuser where name=? and password=?";

		try {

			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, name);

			preparedStatement.setString(2, password);

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

	@Override
	public boolean userRegister(String name, String password) {
		if (isSame(name)) {

			return false;

		} else {

			String sql = "insert into superuser(name,password) values(?,?)";

			try {

				PreparedStatement preparedStatement = new Util().getConnection().prepareCall(sql);

				preparedStatement.setString(1, name);

				preparedStatement.setString(2, password);

				preparedStatement.executeUpdate();
			} catch (Exception e) {
				
			}
			return true;

		}

	}

	private boolean isSame(String name) {
		String sql = "select * from superuser where name=?";
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

}
