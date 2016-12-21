package com.lxy.app.dao.sys;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.lxy.app.domain.sys.User;

/*public interface UserDao extends BaseDao{
}
*/

@org.springframework.stereotype.Repository
public interface UserDao extends Repository<User, Long>{
	User findById(Long id);
	void save(User user);
	List<User> findAll();
}