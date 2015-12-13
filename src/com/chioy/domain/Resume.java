package com.chioy.domain;

public class Resume {
	private int rid;
	private int uid;
	private String pic;
	private String name;
	private int age;
	private int sex;
	private String profession;
	private String ed_exp;
	private String wk_exp;
	private String profile;
	/**
	 * @return the rid
	 */
	public int getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
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
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}
	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}
	/**
	 * @return the ed_exp
	 */
	public String getEd_exp() {
		return ed_exp;
	}
	/**
	 * @param ed_exp the ed_exp to set
	 */
	public void setEd_exp(String ed_exp) {
		this.ed_exp = ed_exp;
	}
	/**
	 * @return the wk_exp
	 */
	public String getWk_exp() {
		return wk_exp;
	}
	/**
	 * @param wk_exp the wk_exp to set
	 */
	public void setWk_exp(String wk_exp) {
		this.wk_exp = wk_exp;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Resume(int uid, String pic, String name, int age, int sex,
			String profession, String ed_exp, String wk_exp, String profile) {
		super();
		this.rid = -1;
		this.uid = uid;
		this.pic = pic;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.profession = profession;
		this.ed_exp = ed_exp;
		this.wk_exp = wk_exp;
		this.profile = profile;
	}
	public Resume() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resume [rid=" + rid + ", uid=" + uid + ", pic=" + pic
				+ ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", profession=" + profession + ", ed_exp=" + ed_exp
				+ ", wk_exp=" + wk_exp + ", profile=" + profile + "]";
	}
	
	
}
