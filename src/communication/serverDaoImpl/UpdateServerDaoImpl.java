package communication.serverDaoImpl;

import communication.bean.Card;
import communication.bean.Classify;
import communication.bean.Company;
import communication.dao.impl.CardDaoImpl;
import communication.dao.impl.ClassifyDaoImpl;
import communication.dao.impl.CompanyDaoImpl;
import communication.serverDao.UpdateServerDao;

public class UpdateServerDaoImpl implements UpdateServerDao {

	@Override
	public boolean cardUpdateServer(Card card) {
		
		return new CardDaoImpl().update(card);
	}

	@Override
	public boolean classifyUpdateServer(Classify classify) {
		
		return new ClassifyDaoImpl().updateClassify(classify);
	}

	@Override
	public boolean companyUpdateServer(Company company) {
		
		return new CompanyDaoImpl().updateCompany(company);
	}

}
