package org.test.newtonx.CRUDOperation.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.test.newtonx.CRUDOperation.DbManager.DbManager;
import org.test.newtonx.CRUDOperation.model.User;

import com.mysql.jdbc.Statement;

public class UserDAO {

	private Connection connection;

	public UserDAO() {
		connection = DbManager.getConnection();
	}

	public User addUser(User user) {
		int user_Id = 0;
		try {
			String insertSql = "INSERT INTO USER (FIRSTNAME,LASTNAME) VALUES (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			int affectedRows = preparedStatement.executeUpdate(); 
			if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                 user_Id = resultSet.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findUserById(user_Id);
	}

	public void deleteUser(int user_Id) {
		try {
			String deleteSql = "DELETE FROM USER WHERE USER_ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
			preparedStatement.setInt(1, user_Id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User updateUser(User user) {
		int user_Id = user.getUser_Id();
		try {
			String sql = "UPDATE USER SET FIRSTNAME=?,LASTNAME=? WHERE USER_ID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setInt(3, user.getUser_Id());
			preparedStatement.executeUpdate();
			int affectedRows = preparedStatement.executeUpdate(); 
			if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
	            if (resultSet.next()) {
	                 user_Id = resultSet.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findUserById(user_Id);
	}
	public User findUserById(int user_Id){
		User user = new User();
		String sql = "SELECT * FROM USER WHERE USER_ID=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_Id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				user.setUser_Id(resultSet.getInt("user_Id"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
			}else{
				return null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> getUsers() {
		List<User> usersDetail = new ArrayList<>();
		try {
			String sql = "SELECT * FROM USER";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setUser_Id(resultSet.getInt("user_Id"));
				user.setFirstName(resultSet.getString("firstName"));
				user.setLastName(resultSet.getString("lastName"));
				usersDetail.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersDetail;
	}

}
