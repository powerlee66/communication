package communication.serverDaoImpl;

import java.util.List;

import communication.bean.Card;
import communication.dao.impl.CardDaoImpl;
import communication.serverDao.SerchServerDao;

public class SearchServerDaoImpl implements SerchServerDao {

	@Override
	public List<Card> searchCardByConpanyName(String name) {
		
		return new CardDaoImpl().findCardByCompanyName(name);
	}

	@Override
	public List<Card> searchCardByKindName(String name) {
		
		return new CardDaoImpl().findCardByKindName(name);
	}

	@Override
	public List<Card> searchCardByName(String name) {
		
		return new CardDaoImpl().findCardByName(name);
	}

}
