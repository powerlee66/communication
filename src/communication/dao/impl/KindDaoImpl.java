package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import communication.bean.Kind;
import communication.dao.KindDao;
import communication.util.Util;

public class KindDaoImpl implements KindDao {

	@Override
	public Kind findKindByName(String name) {
		Kind kind = new Kind();
		
		String sql = "select * from kind where name=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				kind.setId(resultSet.getInt("id"));
				
				kind.setName(resultSet.getString("name"));
				
				kind.setNum(resultSet.getInt("num"));
			}
		} catch (Exception e) {
			
		}
		return kind;
	}

	@Override
	public boolean addKind(Kind kind) {
		int a = 0;
		
		String sql = "insert into kind(name,num) values(?,?)";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, kind.getName());
			
			preparedStatement.setInt(2, kind.getNum());
			
			a = preparedStatement.executeUpdate();
		} catch (Exception e) {
			
		}
		if (a>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Kind findKindById(int id) {
Kind kind = new Kind();
		
		String sql = "select * from kind where id=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				kind.setId(resultSet.getInt("id"));
				
				kind.setName(resultSet.getString("name"));
				
				kind.setNum(resultSet.getInt("num"));
			}
		} catch (Exception e) {
			
		}
		return kind;
	}//终于写完了这些蛇皮接口，妈的，竟然写了3天，效率真的是无敌低，吃了个榴莲千层之后一下写完了6个接口
	//看来效率还是看心情决定，心情靠美食决定
	//接下来就是开始写服务的接口，大概需要花个2天吧，明天后天没空，写不了，等放假回来再写
	//写到今晚能写多少就是多少
	//power lee

}
