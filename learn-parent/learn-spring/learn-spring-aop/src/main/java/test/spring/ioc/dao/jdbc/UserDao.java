package test.spring.ioc.dao.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import test.spring.ioc.business.User;
import test.spring.ioc.dao.IUserDao;

public class UserDao extends JdbcDaoSupport implements IUserDao {

	public void createUser(User user) {
		getJdbcTemplate().execute(
				"insert into t_user (" + " user_id, " + " user_name," + " user_pwd," + " address," + " phone,"
						+ " mobile" + ") values ( " + " '" + user.getUserId() + "'" + " '" + user.getUserName() + "'"
						+ " '" + user.getPassword() + "'" + " '" + user.getAddress() + "'" + " '" + user.getPhone()
						+ "'" + " '" + user.getMobile() + "'" + ") ");

	}
}
