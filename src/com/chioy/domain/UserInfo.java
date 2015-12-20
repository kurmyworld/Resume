package com.chioy.domain;

/**User实体类对应数据库users表
 * @author Chioy
 *
 */
public class UserInfo {
	private int uid;
	private String email;
	private String username;
	private String userpswd;
	private String question;
	private String answer;
	public UserInfo(int uid,String email, String username, String userpswd,
			String question, String answer) {
		super();
		this.uid = -1;
		this.email = email;
		this.username = username;
		this.userpswd = userpswd;
		this.question = question;
		this.answer = answer;
	}
	public UserInfo() {
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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
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
				+ username + ", userpswd=" + userpswd + ", question="
				+ question + ", answer=" + answer + "]";
	}
	
}
