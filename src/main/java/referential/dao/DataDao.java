package referential.dao;

import java.util.List;

import referential.entity.Data;

public interface DataDao {

	List<Data> getDataByKey(String key) throws Exception;

}
