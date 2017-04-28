package com.jims.work.bean;

/***
 * 我的服务列表
 */
public class MyAsklistInfor {
	/**
	 *
	 */
	int id;
    int sex;
	//@Column
	String begin_time; // 我的服务时间

	//@Column
	//String myask_evaluate; // 评价状态
	//@Column
	String content; // 服务内容



	//@Column
	//String myask_doctorimg; // 医生头像
	//@Column
	String doctor;//医生姓名

	//@Column
	//String myask_doctorclass;//医生科室

	//@Column
	//String myask_kind;//服务种类

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin_time == null) ? 0 : begin_time.hashCode());
		//result = prime * result + ((myask_evaluate == null) ? 0 : myask_evaluate.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		//result = prime * result + ((myask_doctorimg == null) ? 0 : myask_doctorimg.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		//result = prime * result + ((myask_doctorclass == null) ? 0 : myask_doctorclass.hashCode());
		//result = prime * result + ((myask_kind == null) ? 0 : myask_kind.hashCode());
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
			return false;
		if (myask_kind == null) {
			if (other.myask_kind != null)
				return false;
		} else if (!myask_kind.equals(other.myask_kind))
			return false;*/

		return true;
	}
	public MyAsklistInfor(String begin_time, String myask_evaluate, String content, String myask_doctorimg, String doctor, String myask_doctorclass,
                          String myask_kind) {



		super();
		this.begin_time = begin_time;
		//this.myask_evaluate = myask_evaluate;
		this.content = content;
		//this.myask_doctorimg = myask_doctorimg;
		this.doctor = doctor;
		//this.myask_doctorclass = myask_doctorclass;
		//this.myask_kind = myask_kind;

	}





}
