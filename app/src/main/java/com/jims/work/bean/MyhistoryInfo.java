package com.jims.work.bean;

public class MyhistoryInfo {
	/**
	 *
	 */


		private static final long serialVersionUID = 6851895872936891139L;
		String names; // 医生姓名
		String hospital; // 医院
		//String classes; // 科室
		String position; // 职称
		String Id; // id
		String detail; // ����
	//	Drawable Icon; // ͼƬ


		String Time; // ����
		//String tv_timetext; // �۸�
		String Percent; // ����

	String Comment; // ��������


		public MyhistoryInfo(String names, String hospital,  String position,String detail, String id,String time,  String percent, String comment) {
			this.names = names;
			this.hospital = hospital;
			//this.classes = classes;
			this.position = position;
			Id = id;
			this.detail = detail;
			//Icon = icon;
			Time = time;
			//tv_timetext = tv_timetext;
			Percent = percent;
			Comment = comment;

		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			com.jims.work.bean.MyhistoryInfo that = (com.jims.work.bean.MyhistoryInfo) o;

			if (Comment != that.Comment) return false;

			if (!names.equals(that.names)) return false;
			if (!hospital.equals(that.hospital)) return false;
			//if (!classes.equals(that.classes)) return false;
			if (!position.equals(that.position)) return false;
			if (!Id.equals(that.Id)) return false;
			if (!detail.equals(that.detail)) return false;
			//if (!Icon.equals(that.Icon)) return false;
			if (!Time.equals(that.Time)) return false;
			//if (!tv_timetext.equals(that.tv_timetext)) return false;
			return Percent.equals(that.Percent);

		}

		@Override
		public int hashCode() {
			int result = names.hashCode();
			result = 31 * result + hospital.hashCode();
			//result = 31 * result + classes.hashCode();
			result = 31 * result + position.hashCode();
			result = 31 * result + Id.hashCode();
			result = 31 * result + detail.hashCode();
			//result = 31 * result + Icon.hashCode();
			result = 31 * result + Time.hashCode();
			//result = 31 * result + tv_timetext.hashCode();
			result = 31 * result + Percent.hashCode();
			result = 31 * result + Comment.hashCode();

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

		/*public String getClasses() {
			return classes;
		}

		public void setClasses(String classes) {
			this.classes = classes;
		}
*/
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

		/*public Drawable getIcon() {
			return Icon;
		}

		public void setIcon(Drawable icon) {
			Icon = icon;
		}
*/
		public String getTime() {
			return Time;
		}

		public void setTime(String time) {
			Time = time;
		}

		/*//public String getPrice() {
			return tv_timetext;
		}

		public void setPrice(String tv_timetext) {
			tv_timetext = tv_timetext;
		}*/

		public String getPercent() {
			return Percent;
		}

		public void setPercent(String percent) {
			Percent = percent;
		}

		public String getComment() {
			return Comment;
		}

		public void setComment(String comment) {
			Comment = comment;
		}


	}
