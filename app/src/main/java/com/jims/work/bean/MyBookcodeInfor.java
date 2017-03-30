package com.jims.work.bean;


public class MyBookcodeInfor {
	/**
	 *
	 */

	//@Column
	String book_hospital; // 预约医院

	//@Column
	String book_class; // 预约科室
	//@Column
	String book_doctor; // 预约医生



	//@Column
	String book_price; // 挂号费
	//@Column
	String book_time;//预约诊疗时间


	public String getBook_class() {
		return book_class;
	}

	public void setBook_class(String book_class) {
		this.book_class = book_class;
	}

	String book_person; //
	public String getBook_hospital() {
		return book_hospital;
	}

	public void setBook_hospital(String book_hospital) {
		this.book_hospital = book_hospital;
	}

	public String getBook_doctor() {
		return book_doctor;
	}

	public String getBook_price() {
		return book_price;
	}

	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}

	public void setBook_doctor(String book_doctor) {

		this.book_doctor = book_doctor;
	}

	public String getBook_time() {
		return book_time;
	}

	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}

	public String getBook_person() {
		return book_person;
	}

	public void setBook_person(String book_person) {
		this.book_person = book_person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book_hospital == null) ? 0 : book_hospital.hashCode());
		result = prime * result + ((book_class == null) ? 0 : book_class.hashCode());
		result = prime * result + ((book_doctor == null) ? 0 : book_doctor.hashCode());
		result = prime * result + ((book_price == null) ? 0 : book_price.hashCode());
		result = prime * result + ((book_time == null) ? 0 : book_time.hashCode());
		result = prime * result + ((book_person == null) ? 0 : book_person.hashCode());
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
		MyBookcodeInfor other = (MyBookcodeInfor) obj;
		if (book_hospital == null) {
			if (other.book_hospital != null)
				return false;
		} else if (!book_hospital.equals(other.book_hospital))
			return false;
		if (book_class == null) {
			if (other.book_class != null)
				return false;
		} else if (!book_class.equals(other.book_class))
			return false;
		if (book_doctor == null) {
			if (other.book_doctor != null)
				return false;
		} else if (!book_doctor.equals(other.book_doctor))
			return false;
		if (book_price == null) {
			if (other.book_price != null)
				return false;
		} else if (!book_price.equals(other.book_price))
			return false;
		if (book_time == null) {
			if (other.book_time != null)
				return false;
		} else if (!book_time.equals(other.book_time))
			return false;
		if (book_person == null) {
			if (other.book_person != null)
				return false;
		} else if (!book_person.equals(other.book_person))
			return false;

		return true;
	}
	public MyBookcodeInfor(String book_hospital, String book_class, String book_doctor, String book_price, String book_time,
                           String book_person) {
		super();
		this.book_hospital = book_hospital;
		this.book_class = book_class;
		this.book_doctor = book_doctor;
		this.book_price = book_price;
		this.book_time = book_time;
		this.book_person = book_person;


	}






}
