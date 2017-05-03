package com.jims.work.bean;

/***
 * 我的服务列表
 */
public class MyAsklistInfor {
	/**
	 *
	 */
	int id;


	String sysuserid;
	String sex;//性别
	String age;//年龄
	//@Column
	String begin_time; // 问诊开始时间

	//@Column
	//String myask_evaluate; // 评价状态
	//@Column
	String content; // 问诊内容



	//@Column
	//String myask_doctorimg; // 医生头像
	//@Column
	String doctor;//回复医生姓名

	//@Column
	//String myask_doctorclass;//医生科室




	String ispay;//是否付费


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysuserid() {
		return sysuserid;
	}

	public void setSysuserid(String sysuserid) {
		this.sysuserid = sysuserid;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getIspay() {
		return ispay;
	}

	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin_time == null) ? 0 : begin_time.hashCode());
		//result = prime * result + ((myask_evaluate == null) ? 0 : myask_evaluate.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		//result = prime * result + ((myask_doctorimg == null) ? 0 : myask_doctorimg.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		//result = prime * result + ((myask_doctorclass == null) ? 0 : myask_doctorclass.hashCode());
		result = prime * result + ((ispay == null) ? 0 : ispay.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAsklistInfor other = (MyAsklistInfor) obj;
		if (begin_time == null) {
			if (other.begin_time != null)
				return false;
		} else if (!begin_time.equals(other.begin_time))
			return false;
		/*if (myask_evaluate == null) {
			if (other.myask_evaluate != null)
				return false;
		} else if (!myask_evaluate.equals(other.myask_evaluate))
			return false;*/
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		/*if (myask_doctorimg == null) {
			if (other.myask_doctorimg != null)
				return false;
		} else if (!myask_doctorimg.equals(other.myask_doctorimg))
			return false;*/
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
	/*	if (myask_doctorclass == null) {
			if (other.myask_doctorclass != null)
				return false;
		} else if (!myask_doctorclass.equals(other.myask_doctorclass))
			return false;*/
		if (ispay == null) {
			if (other.ispay != null)
				return false;
		} else if (!ispay.equals(other.ispay))
			return false;

		return true;
	}
	public MyAsklistInfor(String begin_time, String myask_evaluate, String content,String sex,String age, String myask_doctorimg, String doctor, String myask_doctorclass,
                          String ispay) {



		super();
		this.begin_time = begin_time;
		//this.myask_evaluate = myask_evaluate;
		this.content = content;
		this.sex = sex;
		this.age = age;
		//this.myask_doctorimg = myask_doctorimg;
		this.doctor = doctor;
		//this.myask_doctorclass = myask_doctorclass;
		this.ispay = ispay;

	}





}
