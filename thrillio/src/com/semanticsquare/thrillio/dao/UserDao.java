package com.semanticsquare.thrillio.dao;

import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.DataStore;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
