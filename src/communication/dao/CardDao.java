package communication.dao;

import java.util.List;

import communication.bean.Card;

public interface CardDao {

	public Card findCardById(int id);
	
	public List<Card> findCardByName(String name);
	
	public List<Card> findCardByCompanyName(String companyName);
	
	public List<Card> findCardByKindName(String kindName);
	//........................................查找
	public boolean update(Card card);
	//更改........arg0为需要更改的列名，arg1为对应要改的值
	public boolean delete(Card card);
	//删除...........................................
	public boolean add(Card card);
	//添加...........................................
	
}
