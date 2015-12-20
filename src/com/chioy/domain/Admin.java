package com.chioy.domain;
public class Admin {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [username=" + username + ", userpswd=" + userpswd + "]";
	}
	private String username;
	private String userpswd;
	public Admin(String username, String userpswd) {
		super();
		this.username = username;
		this.userpswd = userpswd;
	}
	public Admin() {
		super();
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
	/**
	 * @return the userpswd
	 */
	public String getUserpswd() {
		return userpswd;
	}
	/**
	 * @param userpswd the userpswd to set
	 */
	public void setUserpswd(String userpswd) {
		this.userpswd = userpswd;
	}
	
}
