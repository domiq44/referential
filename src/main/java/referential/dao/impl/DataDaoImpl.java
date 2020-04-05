package referential.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import referential.dao.DataDao;
import referential.dao.SingletonConnection;
import referential.entity.Data;

public class DataDaoImpl implements DataDao {

	@Override
	public List<Data> getDataByKey(String key) throws Exception {
		final List<Data> datas = new ArrayList<>();
		try {
			final Connection connection = SingletonConnection.getInstance().getConnection();
			final PreparedStatement ps = connection.prepareStatement("select * from data where key like ?");
			ps.setString(1, "%" + key + "%");
			final ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				final Data data = new Data();
				data.setKey(rs.getString("key"));
				data.setValue(rs.getString("value"));
				data.setComment(rs.getString("comment"));
				datas.add(data);

			}
		} catch (final Exception e) {
			throw e;
		}
		return datas;
	}

}
