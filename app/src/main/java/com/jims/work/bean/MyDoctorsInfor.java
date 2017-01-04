package com.jims.work.bean;



import java.io.Serializable;



//@Table(name = "MyDoctor")
public class MyDoctorsInfor  implements Serializable, Cloneable {
	/**
	 * 
	 */

	//@Column
	String names; // ����
	//@Column
	String hospital; // ҽԺ
	//@Column
	String classes; // ����
	//@Column
	String position; // ְλ


	//@Column
	String goodsId; // id
	//@Column
	String goodsIcon;
	//@Column
	String attention; // 
	//@Column
	String buy; // 
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
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsIcon() {
		return goodsIcon;
	}
	public void setGoodsIcon(String goodsIcon) {
		this.goodsIcon = goodsIcon;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attention == null) ? 0 : attention.hashCode());
		result = prime * result + ((buy == null) ? 0 : buy.hashCode());
		result = prime * result + ((classes == null) ? 0 : classes.hashCode());
		result = prime * result + ((goodsIcon == null) ? 0 : goodsIcon.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		MyDoctorsInfor other = (MyDoctorsInfor) obj;
		if (attention == null) {
			if (other.attention != null)
				return false;
		} else if (!attention.equals(other.attention))
			return false;
		if (buy == null) {
			if (other.buy != null)
				return false;
		} else if (!buy.equals(other.buy))
			return false;
		if (classes == null) {
			if (other.classes != null)
				return false;
		} else if (!classes.equals(other.classes))
			return false;
		if (goodsIcon == null) {
			if (other.goodsIcon != null)
				return false;
		} else if (!goodsIcon.equals(other.goodsIcon))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (hospital == null) {
			if (other.hospital != null)
				return false;
		} else if (!hospital.equals(other.hospital))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	public MyDoctorsInfor(String names, String hospital, String classes, String position, String goodsId,
			String goodsIcon, String attention, String buy) {
		super();
		this.names = names;
		this.hospital = hospital;
		this.classes = classes;
		this.position = position;
		this.goodsId = goodsId;
		this.goodsIcon = goodsIcon;
		this.attention = attention;
		this.buy = buy;
	}
	




	
}
