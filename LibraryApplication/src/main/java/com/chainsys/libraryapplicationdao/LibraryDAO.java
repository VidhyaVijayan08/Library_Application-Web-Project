package com.chainsys.libraryapplicationdao;

import java.sql.SQLException;
import java.util.List;

import com.chainsys.libraryapplicationmodel.User;

public interface LibraryDAO {
	public void saveLibrary(User user) throws ClassNotFoundException, SQLException;
	 
	public static List<User> retrieveDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
