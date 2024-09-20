package htl.ute.Services.Implement;

import htl.ute.Services.IUserService;
import htl.ute.model.UserModel;
import htl.ute.dao.IUserDao;
import htl.ute.dao.impl.UserDaoImpl;

public class IUserServiceImpl implements IUserService {
	// lấy toàn bộ hàm trong tầng DAO của user
	IUserDao userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findbyUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
		
	}

	@Override
	public UserModel findbyUserName(String username) {
		return userDao.findbyUserName(username);
	}
	@Override
	public boolean register(String username,String email, String password,  String 
	fullname, String phone ) {
	if (userDao.checkExistUsername(username)) {
	return false;
	}
	long millis=System.currentTimeMillis(); 
	java.sql.Date date=new java.sql.Date(millis);
	userDao.insert(new UserModel(username, email,password , fullname, 
	null,5,phone,date));
	return true;
	}
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}
	@Override
	public boolean checkExistPhone(String phone) {
	return userDao.checkExistPhone(phone);
	}
	@Override
	public void insert(UserModel user) {
	userDao.insert(user);
	}
	@Override 
	public UserModel findPassword(String username, String email) {
		return userDao.findPassword(username,email);
	}
}
