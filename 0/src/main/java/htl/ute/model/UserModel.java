package htl.ute.model;

import java.io.Serializable;
import java.sql.Date;
@SuppressWarnings("serial")
public class UserModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String images;
	private int roleid;
	private String phone;
	private Date createdDate;
	public UserModel() {
		super();
	}
	public UserModel(int id, String username, String email, String password, String fullname, String images,
			int roleid,	 String phone,Date createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}
	public UserModel( String username2, String email2,String password2,String fullname2,  String images2, int roleid2,
			String phone2, Date date) {
		super();
		this.username = username2;
		this.email = email2;
		this.password = password2;
		this.fullname = fullname2;
		this.images = images2;
		this.roleid = roleid2;
		this.phone = phone2;
		this.createdDate = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", images=" + images +  ", roleid=" + roleid
				+ ", phone=" + phone + ", createdDate=" + createdDate + "]";
	}
	
}
