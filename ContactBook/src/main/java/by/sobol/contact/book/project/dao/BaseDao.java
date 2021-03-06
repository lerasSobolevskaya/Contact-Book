package by.sobol.contact.book.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.sobol.contact.book.project.domain.Entity;
import static by.sobol.contact.book.project.dao.util.AbstractDaoMySQL.ERROR_IN_BASE_DAO_CLOSE_RESULT_SET;

public interface BaseDao<T extends Entity> {

	static final Logger LOG = Logger.getLogger(BaseDao.class);

	List<T> getList();

	int create(T entity);
	
	T read(int id);

	void update(T entity);

	void delete(int id);

	default void closeResultSet(ResultSet result) {
		if(result != null) {
			try {
				result.close();
			}catch(SQLException ex){
				LOG.error(ERROR_IN_BASE_DAO_CLOSE_RESULT_SET, ex);
			}
		}
	}

}
