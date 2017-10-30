package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import communication.bean.Classify;
import communication.bean.Collection;
import communication.dao.CollectionDao;
import communication.util.Util;

public class CollectionDaoImpl implements CollectionDao {

	@Override
	public Collection findById(int id) {
		Collection collection = new Collection();

		String sql = "select * from collection where id=?";

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				collection.setCard(new CardDaoImpl().findCardById(resultSet.getInt("cardid")));

				collection.setId(resultSet.getInt("id"));

				collection.setClassify(new ClassifyDaoImpl().findById(resultSet.getInt("classifyid")));

			}
		} catch (Exception e) {

		}
		return collection;
	}

	@Override
	public List<Collection> findByclassifyName(Classify classify) {

		// 蛇皮象拔蚌，图书馆没开空调不想写了，明天再写。明天之前把实现类都写完，
		// 周五把servers的接口写完
		// 周六把server的接口实现，并且开始写action
		// 周日回家，什么瓜皮都不写。
		// 回家之后尽量把action写完，并且尽量写一下界面
		// 争取在放假回来的时候能够把项目的第一阶段弄完。。。。。。。。。。
		// 感觉到时候这些代码写完之后，光是注释就能整合成一本日记。。。。
		String sql = "select * from collection where classifyid=?";

		List<Collection> list = new ArrayList<Collection>();

		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);

			preparedStatement.setInt(1, classify.getId());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Collection collection = new Collection();

				collection.setCard(new CardDaoImpl().findCardById(resultSet.getInt("cardid")));

				collection.setId(resultSet.getInt("id"));
				
				System.out.println(resultSet.getInt("id"));

				collection.setClassify(new ClassifyDaoImpl().findById(resultSet.getInt("classifyid")));

				list.add(collection);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public boolean add(Collection collection){
		int a = 0;
		String sql = "insert into collection(cardid,classifyid) values(?,?)";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, collection.getCard().getId());
			
			preparedStatement.setInt(2, collection.getClassify().getId());
			
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
	
	public boolean delete(int cardid,int classifyid){
		String sql = "delete from collection where cardid=? and classifyid=?";
		
		int a = 0;
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, cardid);
			
			preparedStatement.setInt(2, classifyid);
			
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
	public boolean delete(int classifyid){
		String sql = "delete from collection where classifyid=?";
		
		int a = 0;
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			
			preparedStatement.setInt(2, classifyid);
			
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
