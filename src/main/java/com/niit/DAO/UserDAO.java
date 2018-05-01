
package com.niit.DAO;

import java.util.List;

import com.niit.domain.User;

public interface UserDAO 
{
  public boolean saveOrUpdate(User user);
  public User validateUser(String email,String password);
  public List<User> userList();
  public User getUser(String email);
  public boolean deleteUser(String email);	
}
