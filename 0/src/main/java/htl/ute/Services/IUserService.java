package htl.ute.Services;

import htl.ute.model.UserModel;


public interface IUserService {
	UserModel findbyUserName(String username);
	UserModel login(String username, String password);
	void insert(UserModel user);
	boolean register(String username,String email, String password,  String 
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	UserModel findPassword(String username, String password);
}
