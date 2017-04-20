package com.jims.work.bean;


public class TestResult2 {
	/**
	 *
	 */

	//@Column
	String test_name; // ����
	//@Column
	String test_time; // ҽԺ

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getTest_time() {
		return test_time;
	}

	public void setTest_time(String test_time) {
		this.test_time = test_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((test_name == null) ? 0 : test_name.hashCode());
		result = prime * result + ((test_time == null) ? 0 : test_time.hashCode());

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
		TestResult2 other = (TestResult2) obj;
		if (test_name == null) {
			if (other.test_name != null)
				return false;
		} else if (!test_name.equals(other.test_name))
			return false;
		if (test_time == null) {
			if (other.test_time != null)
				return false;
		} else if (!test_time.equals(other.test_time))
			return false;

		return true;
	}
	public TestResult2(String test_name, String test_time) {
		super();
		this.test_name = test_name;
		this.test_time = test_time;

	}






}
