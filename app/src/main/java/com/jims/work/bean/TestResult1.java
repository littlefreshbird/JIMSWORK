package com.jims.work.bean;


public class TestResult1 {
	/**
	 *
	 */

	//@Column
	String check_name; // 检查项目
	//@Column
	String check_time; // 检查时间

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getCheck_time() {
		return check_time;
	}

	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((check_name == null) ? 0 : check_name.hashCode());
		result = prime * result + ((check_time == null) ? 0 : check_time.hashCode());

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
		TestResult1 other = (TestResult1) obj;
		if (check_name == null) {
			if (other.check_name != null)
				return false;
		} else if (!check_name.equals(other.check_name))
			return false;
		if (check_time == null) {
			if (other.check_time != null)
				return false;
		} else if (!check_time.equals(other.check_time))
			return false;

		return true;
	}
	public TestResult1(String check_name, String check_time) {
		super();
		this.check_name = check_name;
		this.check_time = check_time;

	}






}
