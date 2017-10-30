package communication.serverDao;

import communication.bean.Card;
import communication.bean.Classify;
import communication.bean.Company;

public interface UpdateServerDao {
	
	public boolean cardUpdateServer(Card card);
	
	public boolean classifyUpdateServer(Classify classify);
	
	public boolean companyUpdateServer(Company company);
	
}
