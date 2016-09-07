package free.co.model;

import java.io.Serializable;

/*
DROP TABLE FREEMEMBER;

CREATE TABLE FREEMEMBER(
   id varchar2(50) primary key,
   name varchar2(50) not null,
   pwd varchar2(50) not null,
   email varchar2(50) unique,
   phone varchar2(10) not null,
   auth number(1) not null      --일반 사용자 == 3, 관리자 == 1

);

SELECT * FROM FREEMEMBER;
*/

public class FreeMemberDTO implements Serializable{
	private String id;
	private String name;
	private String pwd;
	private String email;
	private String phone;
	private int auth;
	
	public FreeMemberDTO() {}

	public FreeMemberDTO(String id, String name, String pwd, String email, String phone, int auth) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "FreeMemberDTO [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", phone=" + phone
				+ ", auth=" + auth + "]";
	}
	
}
