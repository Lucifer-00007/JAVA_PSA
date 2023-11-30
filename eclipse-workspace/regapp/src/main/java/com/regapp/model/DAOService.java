package com.regapp.model;

import java.sql.ResultSet;

public interface DAOService {
	public boolean verifyCredentials(String email, String pass);

	public void createRegistration(String name, String email, String phone, String city);

	public ResultSet readRegistration();
}
