package htl.ute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import htl.ute.controller.DBconnectionSQL;
import htl.ute.dao.IUserDao;
import htl.ute.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DBconnectionSQL implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql ="select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"),
								rs.getString("password"),
								rs.getString("email"),
								rs.getString("fullname"),
								rs.getString("images"),
								rs.getInt("roleid"),
								rs.getString("phone"),
								rs.getDate("createdDate")));
			}	
		return list;
		}catch(Exception e) {
			
		}
		return null;
	}
	@Override
	public void insert(UserModel user) {
	    String sql = "INSERT INTO users(username, email, password, fullname, images, roleid, phone, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try {
	    	new DBconnectionSQL();
			conn = super.getConn();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getFullname());
	        ps.setString(5, user.getImages());
	        ps.setInt(6, user.getRoleid());
	        ps.setString(7, user.getPhone());
	        ps.setDate(8, user.getCreatedDate());  
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();  // Xử lý hoặc ghi log tốt hơn.
	    }
	}

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> list = userDao.findAll();
		for(UserModel user : list) {
			System.out.println(user);
		}
	}
	@Override
	public UserModel findbyUserName(String username) {
		String sql = "SELECT * FROM users WHERE username= ?";
		try {
			new DBconnectionSQL();
			conn = DBconnectionSQL.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));			
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;			
			}
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	@Override
	public UserModel findPassword(String username, String email) {
		String sql ="SELECT * FROM users WHERE username=? AND email=?";
		try {
			new DBconnectionSQL();
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));			
				user.setPhone(rs.getString("phone"));
				user.setRoleid(rs.getInt("roleid"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			new DBconnectionSQL();
			conn = super.getConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			new DBconnectionSQL();
			conn = super.getConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}
}
