package com.jims.work.bean;

import android.graphics.drawable.Drawable;


public class DoctorsInfo {
	/**
	 *
	 */


	private static final long serialVersionUID = 6851895872936891139L;
	String names; // ����
	String hospital; // ҽԺ
	String classes; // ����
	String position; // ְλ
	String Id; // id
	String detail; // ����
	Drawable Icon; // ͼƬ


	String Type; // ����
	String Price; // �۸�
	String Percent; // ����

	int Comment; // ��������
	int isPhone; // �Ƿ��ֻ�ר��
	int isFavor;

	public DoctorsInfo(String names, String hospital, String classes, String position, String id, String detail, Drawable icon, String type, String price, String percent, int comment, int isPhone, int isFavor) {
		this.names = names;
		this.hospital = hospital;
		this.classes = classes;
		this.position = position;
		Id = id;
		this.detail = detail;
		Icon = icon;
		Type = type;
		Price = price;
		Percent = percent;
		Comment = comment;
		this.isPhone = isPhone;
		this.isFavor = isFavor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DoctorsInfo that = (DoctorsInfo) o;

		if (Comment != that.Comment) return false;
		if (isPhone != that.isPhone) return false;
		if (isFavor != that.isFavor) return false;
		if (!names.equals(that.names)) return false;
		if (!hospital.equals(that.hospital)) return false;
		if (!classes.equals(that.classes)) return false;
		if (!position.equals(that.position)) return false;
		if (!Id.equals(that.Id)) return false;
		if (!detail.equals(that.detail)) return false;
		if (!Icon.equals(that.Icon)) return false;
		if (!Type.equals(that.Type)) return false;
		if (!Price.equals(that.Price)) return false;
		return Percent.equals(that.Percent);

	}

	@Override
	public int hashCode() {
		int result = names.hashCode();
		result = 31 * result + hospital.hashCode();
		result = 31 * result + classes.hashCode();
		result = 31 * result + position.hashCode();
		result = 31 * result + Id.hashCode();
		result = 31 * result + detail.hashCode();
		result = 31 * result + Icon.hashCode();
		result = 31 * result + Type.hashCode();
		result = 31 * result + Price.hashCode();
		result = 31 * result + Percent.hashCode();
		result = 31 * result + Comment;
		result = 31 * result + isPhone;
		result = 31 * result + isFavor;
		return result;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Drawable getIcon() {
		return Icon;
	}

	public void setIcon(Drawable icon) {
		Icon = icon;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getPercent() {
		return Percent;
	}

	public void setPercent(String percent) {
		Percent = percent;
	}

	public int getComment() {
		return Comment;
	}

	public void setComment(int comment) {
		Comment = comment;
	}

	public int getIsPhone() {
		return isPhone;
	}

	public void setIsPhone(int isPhone) {
		this.isPhone = isPhone;
	}

	public int getIsFavor() {
		return isFavor;
	}

	public void setIsFavor(int isFavor) {
		this.isFavor = isFavor;
	}
}
