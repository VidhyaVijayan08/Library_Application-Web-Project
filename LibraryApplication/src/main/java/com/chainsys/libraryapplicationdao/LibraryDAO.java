package com.chainsys.libraryapplicationdao;

import java.sql.SQLException;
import java.util.List;
import com.chainsys.libraryapplicationmodel.Lending;
import com.chainsys.libraryapplicationmodel.User;

public interface LibraryDAO {
	public void saveLibrary(User user) throws ClassNotFoundException, SQLException;
	 
	public static List<User> retrieveDetails() throws ClassNotFoundException, SQLException {
		return null;
	}
	
	public static List<Lending> retrieveDetail()throws ClassNotFoundException, SQLException {
		return null;
	}

	void approveBorrower(Lending lending) throws ClassNotFoundException, SQLException;
}
