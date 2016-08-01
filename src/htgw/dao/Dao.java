package htgw.dao;

import java.util.List;

public interface Dao<T> {
	public boolean saveOrUpdate (T o);
	public boolean del(T o);
	public boolean delBycondition(String condition);
	public List<T> query(String condition);
	public boolean isRepeat(String condition);

}
