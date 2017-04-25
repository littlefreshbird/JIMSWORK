package com.jims.work.bean;

/***
 * 我的服务列表
 */
public class MyAsklistInfor {
	/**
	 *
	 */

	//@Column
	String begin_time; // 我的服务时间

	//@Column
	String myask_evaluate; // 评价状态
	//@Column
	String myask_content; // 服务内容



	//@Column
	String myask_doctorimg; // 医生头像
	//@Column
	String myask_doctorname;//医生姓名

	//@Column
	String myask_doctorclass;//医生科室

	//@Column
	String myask_kind;//服务种类


	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getMyask_evaluate() {
		return myask_evaluate;
	}

	public void setMyask_evaluate(String myask_evaluate) {
		this.myask_evaluate = myask_evaluate;
	}

	public String getMyask_content() {
		return myask_content;
	}

	public void setMyask_content(String myask_content) {
		this.myask_content = myask_content;
	}

	public String getMyask_doctorimg() {
		return myask_doctorimg;
	}

	public void setMyask_doctorimg(String myask_doctorimg) {
		this.myask_doctorimg = myask_doctorimg;
	}

	public String getMyask_doctorname() {
		return myask_doctorname;
	}

	public void setMyask_doctorname(String myask_doctorname) {
		this.myask_doctorname = myask_doctorname;
	}

	public String getMyask_doctorclass() {
		return myask_doctorclass;
	}

	public void setMyask_doctorclass(String myask_doctorclass) {
		this.myask_doctorclass = myask_doctorclass;
	}

	public String getMyask_kind() {
		return myask_kind;
	}

	public void setMyask_kind(String myask_kind) {
		this.myask_kind = myask_kind;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin_time == null) ? 0 : begin_time.hashCode());
		result = prime * result + ((myask_evaluate == null) ? 0 : myask_evaluate.hashCode());
		result = prime * result + ((myask_content == null) ? 0 : myask_content.hashCode());
		result = prime * result + ((myask_doctorimg == null) ? 0 : myask_doctorimg.hashCode());
		result = prime * result + ((myask_doctorname == null) ? 0 : myask_doctorname.hashCode());
		result = prime * result + ((myask_doctorclass == null) ? 0 : myask_doctorclass.hashCode());
		result = prime * result + ((myask_kind == null) ? 0 : myask_kind.hashCode());
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
		if (myask_evaluate == null) {
			if (other.myask_evaluate != null)
				return false;
		} else if (!myask_evaluate.equals(other.myask_evaluate))
			return false;
		if (myask_content == null) {
			if (other.myask_content != null)
				return false;
		} else if (!myask_content.equals(other.myask_content))
			return false;
		if (myask_doctorimg == null) {
			if (other.myask_doctorimg != null)
				return false;
		} else if (!myask_doctorimg.equals(other.myask_doctorimg))
			return false;
		if (myask_doctorname == null) {
			if (other.myask_doctorname != null)
				return false;
		} else if (!myask_doctorname.equals(other.myask_doctorname))
			return false;
		if (myask_doctorclass == null) {
			if (other.myask_doctorclass != null)
				return false;
		} else if (!myask_doctorclass.equals(other.myask_doctorclass))
			return false;
		if (myask_kind == null) {
			if (other.myask_kind != null)
				return false;
		} else if (!myask_kind.equals(other.myask_kind))
			return false;

		return true;
	}
	public MyAsklistInfor(String begin_time, String myask_evaluate, String myask_content, String myask_doctorimg, String myask_doctorname, String myask_doctorclass,
                          String myask_kind) {
		super();
		this.begin_time = begin_time;
		this.myask_evaluate = myask_evaluate;
		this.myask_content = myask_content;
		this.myask_doctorimg = myask_doctorimg;
		this.myask_doctorname = myask_doctorname;
		this.myask_doctorclass = myask_doctorclass;
		this.myask_kind = myask_kind;

	}





}
