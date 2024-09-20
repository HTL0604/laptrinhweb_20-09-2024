package htl.ute.dao;

import java.util.List;

import htl.ute.model.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll(); 
	void insert(UserModel user);
	UserModel findbyUserName(String username);
	boolean checkExistUsername(String username);
	boolean checkExistEmail(String email);
	boolean checkExistPhone(String phone);
	UserModel findPassword(String username, String email);
}
