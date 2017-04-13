package com.jims.work.bean;

/***
 * 我的服务列表
 */
public class MyServicelistInfor {
	/**
	 *
	 */

	//@Column
	String myservice_time; // 我的服务时间

	//@Column
	String myservice_evaluate; // 评价状态
	//@Column
	String myservice_content; // 服务内容



	//@Column
	String myservice_doctorimg; // 医生头像
	//@Column
	String myservice_doctorname;//医生姓名

	//@Column
	String myservice_doctorclass;//医生科室

	//@Column
	String myservice_kind;//服务种类

	public String getMyservice_time() {
		return myservice_time;
	}

	public void setMyservice_time(String myservice_time) {
		this.myservice_time = myservice_time;
	}

	public String getMyservice_evaluate() {
		return myservice_evaluate;
	}

	public void setMyservice_evaluate(String myservice_evaluate) {
		this.myservice_evaluate = myservice_evaluate;
	}

	public String getMyservice_content() {
		return myservice_content;
	}

	public void setMyservice_content(String myservice_content) {
		this.myservice_content = myservice_content;
	}

	public String getMyservice_doctorimg() {
		return myservice_doctorimg;
	}

	public void setMyservice_doctorimg(String myservice_doctorimg) {
		this.myservice_doctorimg = myservice_doctorimg;
	}

	public String getMyservice_doctorname() {
		return myservice_doctorname;
	}

	public void setMyservice_doctorname(String myservice_doctorname) {
		this.myservice_doctorname = myservice_doctorname;
	}

	public String getMyservice_doctorclass() {
		return myservice_doctorclass;
	}

	public void setMyservice_doctorclass(String myservice_doctorclass) {
		this.myservice_doctorclass = myservice_doctorclass;
	}

	public String getMyservice_kind() {
		return myservice_kind;
	}

	public void setMyservice_kind(String myservice_kind) {
		this.myservice_kind = myservice_kind;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myservice_time == null) ? 0 : myservice_time.hashCode());
		result = prime * result + ((myservice_evaluate == null) ? 0 : myservice_evaluate.hashCode());
		result = prime * result + ((myservice_content == null) ? 0 : myservice_content.hashCode());
		result = prime * result + ((myservice_doctorimg == null) ? 0 : myservice_doctorimg.hashCode());
		result = prime * result + ((myservice_doctorname == null) ? 0 : myservice_doctorname.hashCode());
		result = prime * result + ((myservice_doctorclass == null) ? 0 : myservice_doctorclass.hashCode());
		result = prime * result + ((myservice_kind == null) ? 0 : myservice_kind.hashCode());
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
		MyServicelistInfor other = (MyServicelistInfor) obj;
		if (myservice_time == null) {
			if (other.myservice_time != null)
				return false;
		} else if (!myservice_time.equals(other.myservice_time))
			return false;
		if (myservice_evaluate == null) {
			if (other.myservice_evaluate != null)
				return false;
		} else if (!myservice_evaluate.equals(other.myservice_evaluate))
			return false;
		if (myservice_content == null) {
			if (other.myservice_content != null)
				return false;
		} else if (!myservice_content.equals(other.myservice_content))
			return false;
		if (myservice_doctorimg == null) {
			if (other.myservice_doctorimg != null)
				return false;
		} else if (!myservice_doctorimg.equals(other.myservice_doctorimg))
			return false;
		if (myservice_doctorname == null) {
			if (other.myservice_doctorname != null)
				return false;
		} else if (!myservice_doctorname.equals(other.myservice_doctorname))
			return false;
		if (myservice_doctorclass == null) {
			if (other.myservice_doctorclass != null)
				return false;
		} else if (!myservice_doctorclass.equals(other.myservice_doctorclass))
			return false;
		if (myservice_kind == null) {
			if (other.myservice_kind != null)
				return false;
		} else if (!myservice_kind.equals(other.myservice_kind))
			return false;

		return true;
	}
	public MyServicelistInfor(String myservice_time, String myservice_evaluate, String myservice_content, String myservice_doctorimg,String myservice_doctorname, String myservice_doctorclass,
						   String myservice_kind) {
		super();
		this.myservice_time = myservice_time;
		this.myservice_evaluate = myservice_evaluate;
		this.myservice_content = myservice_content;
		this.myservice_doctorimg = myservice_doctorimg;
		this.myservice_doctorname = myservice_doctorname;
		this.myservice_doctorclass = myservice_doctorclass;
		this.myservice_kind = myservice_kind;

	}





}
