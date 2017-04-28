package com.jims.work.bean;


public class CheckResult {
	/**
	 *
	 */
	int id; // id
	//@Column
	String item; // 检查项目
	//@Column
	String check_date; // 检查时间

	public int getId() {
		return id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCheck_date() {
		return check_date;
	}

	public void setCheck_date(String check_date) {
		this.check_date = check_date;
	}

	public void setId(int id) {

		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((check_date == null) ? 0 : check_date.hashCode());

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
		CheckResult other = (CheckResult) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (check_date == null) {
			if (other.check_date != null)
				return false;
		} else if (!check_date.equals(other.check_date))
			return false;

		return true;
	}
	public CheckResult(String item, String check_date) {
		super();
		this.item = item;
		this.check_date = check_date;

	}






}
