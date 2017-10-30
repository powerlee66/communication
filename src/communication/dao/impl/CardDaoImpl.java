package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import communication.bean.Card;
import communication.bean.Kind;
import communication.bean.User;
import communication.dao.CardDao;
import communication.util.Util;

public class CardDaoImpl implements CardDao {

	@Override
	public Card findCardById(int id) {
		Card card = new Card();

		String sql = "select * from card where id=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				card.setId(resultSet.getInt("id"));

				card.setAdd(resultSet.getString("address"));

				card.setCompany(new CompanyDaoImpl().findCompanyById(resultSet.getInt("companyid")));

				card.setEmail(resultSet.getString("email"));

				card.setImage(resultSet.getString("image"));

				card.setKind(new KindDaoImpl().findKindById(resultSet.getInt("kindid")));

				card.setName(resultSet.getString("name"));

				card.setState(resultSet.getInt("state"));

				card.setTel(resultSet.getString("tel"));

				card.setUser(new UserDaoImpl().findUserById(resultSet.getInt("userid")));

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return card;
	}

	@Override
	public List<Card> findCardByName(String name) {

		// 蛇皮 象拔蚌 不想写了，今晚或者明天再写，真的是瓜皮

		List<Card> list = new ArrayList<Card>();

		String sql = "select * from card where name=?";

		System.out.println("dao///" + name);

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Card card = new Card();
				System.out.println(resultSet.getString("name"));

				card.setId(resultSet.getInt("id"));

				card.setAdd(resultSet.getString("address"));

				card.setCompany(new CompanyDaoImpl().findCompanyById(resultSet.getInt("companyid")));

				card.setEmail(resultSet.getString("email"));

				card.setImage(resultSet.getString("image"));

				card.setKind(new KindDaoImpl().findKindById(resultSet.getInt("kindid")));

				card.setName(resultSet.getString("name"));

				card.setState(resultSet.getInt("state"));

				card.setTel(resultSet.getString("tel"));

				card.setUser(new UserDaoImpl().findUserById(resultSet.getInt("userid")));

				list.add(card);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	@Override
	public List<Card> findCardByCompanyName(String companyName) {
		List<Card> list = new ArrayList<Card>();

		String sql = "select * from card where companyname=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, companyName);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Card card = new Card();

				card.setId(resultSet.getInt("id"));

				card.setAdd(resultSet.getString("add"));

				card.setCompany(new CompanyDaoImpl().findCompanyById(resultSet.getInt("company")));

				card.setEmail(resultSet.getString("email"));

				card.setImage(resultSet.getString("image"));

				card.setKind(new KindDaoImpl().findKindById(resultSet.getInt("kind")));

				card.setName(resultSet.getString("name"));

				card.setState(resultSet.getInt("state"));

				card.setTel(resultSet.getString("tel"));

				card.setUser(new UserDaoImpl().findUserById(resultSet.getInt("user")));

				list.add(card);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Card> findCardByKindName(String kindName) {
		List<Card> list = new ArrayList<Card>();

		Kind kind = new KindDaoImpl().findKindByName(kindName);

		String sql = "select * from card where kindid=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, kind.getId());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Card card = new Card();

				card.setId(resultSet.getInt("id"));

				card.setAdd(resultSet.getString("add"));

				card.setCompany(new CompanyDaoImpl().findCompanyById(resultSet.getInt("company")));

				card.setEmail(resultSet.getString("email"));

				card.setImage(resultSet.getString("image"));

				card.setKind(new KindDaoImpl().findKindById(resultSet.getInt("kind")));

				card.setName(resultSet.getString("name"));

				card.setState(resultSet.getInt("state"));

				card.setTel(resultSet.getString("tel"));

				card.setUser(new UserDaoImpl().findUserById(resultSet.getInt("user")));

				list.add(card);
			}

		} catch (Exception e) {

		}

		return list;
	}

	@Override
	public boolean update(Card card) {
		int a = 0;

		String sql = "update card set userId=?,name=?,companyId=?,add=?,tel=?,image=?,email=?,kindId=?,state=?";//
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, card.getUser().getId());

			preparedStatement.setString(2, card.getName());

			preparedStatement.setInt(3, card.getCompany().getId());

			preparedStatement.setString(4, card.getAdd());

			preparedStatement.setString(5, card.getTel());

			preparedStatement.setString(6, card.getImage());

			preparedStatement.setString(7, card.getEmail());

			preparedStatement.setInt(8, card.getKind().getId());

			preparedStatement.setInt(9, card.getState());

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
	public boolean delete(Card card) {
		String sql = "delete from card where id=?";

		int a = 0;

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, card.getId());

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
	public boolean add(Card card) {
		String sql = "insert into card(userid,name,companyid,add,tel,image,email,kindid,state) values(?,?,?,?,?,?,?,?,?)";

		int a = 0;

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, card.getUser().getId());

			preparedStatement.setString(2, card.getName());

			preparedStatement.setInt(3, card.getCompany().getId());

			preparedStatement.setString(4, card.getAdd());

			preparedStatement.setString(5, card.getTel());

			preparedStatement.setString(6, card.getImage());

			preparedStatement.setString(7, card.getEmail());

			preparedStatement.setInt(8, card.getKind().getId());

			preparedStatement.setInt(9, card.getState());

			a = preparedStatement.executeUpdate();

		} catch (Exception e) {

		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateSimple(Card card) {
		int a = 0;
		int id = card.getId();

		String sql = "update card set name=?,address=?,tel=?,email=? where id=" + id;//
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, card.getName());

			preparedStatement.setString(2, card.getAdd());

			preparedStatement.setString(3, card.getTel());

			preparedStatement.setString(4, card.getEmail());

			a = preparedStatement.executeUpdate();

		} catch (Exception e) {

		}

		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean addSimple(Card card) {
		String sql = "insert into card(name,address,tel,email,userid) values(?,?,?,?,?)";

		int a = 0;

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setString(1, card.getName());

			preparedStatement.setString(2, card.getAdd());

			preparedStatement.setString(3, card.getTel());

			preparedStatement.setString(4, card.getEmail());

			preparedStatement.setInt(5, card.getUser().getId());

			a = preparedStatement.executeUpdate();

		} catch (Exception e) {

			System.out.println("进入catch");
			System.out.println(e.getMessage());
		}
		if (a > 0) {

			return true;

		} else {
			return false;
		}
	}

	public boolean deleteCardByUser(User user) {

		int a = 0;

		String sql = "delete from card where userid=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, user.getId());

			a = preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (a > 0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Card> find() {
		List<Card> list = new ArrayList<Card>();

		String sql = "select * from card";
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Card card = new Card();

				card.setId(resultSet.getInt("id"));

				card.setAdd(resultSet.getString("address"));

				card.setCompany(new CompanyDaoImpl().findCompanyById(resultSet.getInt("companyid")));

				card.setEmail(resultSet.getString("email"));

				card.setImage(resultSet.getString("image"));

				card.setKind(new KindDaoImpl().findKindById(resultSet.getInt("kindid")));

				card.setName(resultSet.getString("name"));

				card.setState(resultSet.getInt("state"));

				card.setTel(resultSet.getString("tel"));

				card.setUser(new UserDaoImpl().findUserById(resultSet.getInt("userid")));

				list.add(card);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
