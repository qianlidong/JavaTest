package com.lxy.app.service.sys;

import java.util.List;

import com.lxy.app.domain.sys.User;

/*public interface UserService extends BaseService{

}*/

public interface UserService {
	User findById(Long id);

	void save(User user);

	List<User> findAll();
}
