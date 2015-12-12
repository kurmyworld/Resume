package com.chioy.domain;

public class Question {
	private int qid;
	private String question;
	public Question(String question) {
		super();
		this.qid = -1;
		this.question = question;
	}
	public Question() {
		super();
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", question=" + question + "]";
	}
	
}
