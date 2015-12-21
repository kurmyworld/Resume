package com.chioy.domain;

public class ConditionUser {
	private String email;
	private String username;

	public ConditionUser() {
		super();
	}
	public ConditionUser(String email, String username) {
		super();
		this.email = email;
		this.username = username;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConditionUser [email=" + email + ", username=" + username + "]";
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
}
