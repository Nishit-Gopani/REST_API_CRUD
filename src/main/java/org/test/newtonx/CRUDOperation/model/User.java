package org.test.newtonx.CRUDOperation.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int user_Id;
	private String firstName;
	private String lastName;

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
