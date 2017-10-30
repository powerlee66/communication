package communication.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import communication.bean.Company;
import communication.dao.CompanyDao;
import communication.util.Util;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	public boolean addCompany(Company company) {
		int a = 0;
		
		String sql = "insert into company(name,tel,add) values(?,?,?)";
				
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, company.getName());
			
			preparedStatement.setString(2, company.getTel());
			
			preparedStatement.setString(3, company.getAdd());
			
			a = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
			 /*	private int id;
				
				private String name;
				
				private String tel;
				
				private String add;
			 */
		if (a>0) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public boolean deleteCompany(Company company) {
		int a = 0;
		
		String sql = "delete from company where id=?";
		
		try {
			PreparedStatement preparedStatement  = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setInt(1, company.getId());
			
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
	public Company findCompanyById(int id) {
		
		return null;
	}

	@Override
	public Company findCompanyByName(String name) {
		Company company = new Company();
		
		String sql = "select * from company where name=?";
		
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				company.setAdd(resultSet.getString("add"));
				
				company.setId(resultSet.getInt("id"));
				
				company.setName(resultSet.getString("name"));
				
				company.setTel(resultSet.getString("tel"));
			}
		} catch (Exception e) {
			return null;
		}
		
		return company;
	}

	@Override
	public boolean updateCompany(Company company) {
		int a = 0;
		
		String sql = "update company set(name,add,tel) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = new Util().getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1, company.getName());
			
			preparedStatement.setString(2, company.getAdd());
			
			preparedStatement.setString(3, company.getTel());
			
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
