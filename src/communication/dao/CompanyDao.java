package communication.dao;

import communication.bean.Company;

public interface CompanyDao {

	public boolean addCompany(Company company);//添加
	
	public boolean deleteCompany(Company company);//删除
	
	public Company findCompanyById(int id);//通过id查找
	
	public Company findCompanyByName(String name);//通过名字查找
	
	public boolean updateCompany(Company company);//更新信息
}
