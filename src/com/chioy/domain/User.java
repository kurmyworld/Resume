package com.chioy.domain;

public class User {
	private int uid;
	private String email;
	private String username;
	private String userpswd;
	private int qid;
	private String answer;
	public User(String email, String username, String userpswd,
			int qid, String answer) {
		super();
		this.uid = -1;
		this.email = email;
		this.username = username;
		this.userpswd = userpswd;
		this.qid = qid;
		this.answer = answer;
	}
	public User() {
		super();
	}
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
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
	/**
	 * @return the qid
	 */
	public int getQid() {
		return qid;
	}
	/**
	 * @param qid the qid to set
	 */
	public void setQid(int qid) {
		this.qid = qid;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", username="
				+ username + ", userpswd=" + userpswd + ", qid=" + qid
				+ ", answer=" + answer + "]";
	}
	
}
