package com.qian.user;

import java.io.Serializable;

public class User implements Serializable{

 


private static final long serialVersionUID = 7175134832651443717L;

//用户编号

private int id;

//用户名

private String userName;

//密码

private String password;

 

public int getId() {

return id;

}

 

public void setId(int id) {

this.id = id;

}

 

public String getUserName() {

return userName;

}

 

public void setUserName(String userName) {

this.userName = userName;

}

 

public String getPassword() {

return password;

}

 

public void setPassword(String password) {

this.password = password;

}

 

public User(int id, String userName, String password) {

super();

this.id = id;

this.userName = userName;

this.password = password;

}

 

@Override

public int hashCode() {

final int prime = 31;

int result = 1;

result = prime * result + id;

result = prime * result

+ ((password == null) ? 0 : password.hashCode());

result = prime * result

+ ((userName == null) ? 0 : userName.hashCode());

return result;

}

 

@Override

public boolean equals(Object obj) {

if (this == obj)

return true;

if (obj == null)

return false;

if (getClass() != obj.getClass())

return false;

User other = (User) obj;

if (id != other.id)

return false;

if (password == null) {

if (other.password != null)

return false;

} else if (!password.equals(other.password))

return false;

if (userName == null) {

if (other.userName != null)

return false;

} else if (!userName.equals(other.userName))

return false;

return true;

}

}
