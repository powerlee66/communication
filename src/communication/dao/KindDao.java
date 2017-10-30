package communication.dao;

import communication.bean.Kind;

public interface KindDao {

	public Kind findKindByName(String name);
	
	public Kind findKindById(int id);
	
	public boolean addKind(Kind kind);
}
