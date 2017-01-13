package com.jims.work.bean;

public class MyhistoryseclectInfo {
	/**
	 *
	 */


		private static final long serialVersionUID = 6851895872936891139L;
		String names; // ����
		String hospital; // ҽԺ
		String classes; // ����
		String position; // ְλ
		String Id; // id
		//String detail; // ����
	//	Drawable Icon; // ͼƬ


		String Time; // ����
		String Price; // �۸�
		String Percent; // ����

	String Comment; // ��������


		public MyhistoryseclectInfo(String names, String hospital, String classes, String position, String id, String time, String price, String percent, String comment) {
			this.names = names;
			this.hospital = hospital;
			this.classes = classes;
			this.position = position;
			Id = id;
			//this.detail = detail;
			//Icon = icon;
			Time = time;
			Price = price;
			Percent = percent;
			Comment = comment;

		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			MyhistoryseclectInfo that = (MyhistoryseclectInfo) o;

			if (Comment != that.Comment) return false;

			if (!names.equals(that.names)) return false;
			if (!hospital.equals(that.hospital)) return false;
			if (!classes.equals(that.classes)) return false;
			if (!position.equals(that.position)) return false;
			if (!Id.equals(that.Id)) return false;
			//if (!detail.equals(that.detail)) return false;
			//if (!Icon.equals(that.Icon)) return false;
			if (!Time.equals(that.Time)) return false;
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
			//result = 31 * result + detail.hashCode();
			//result = 31 * result + Icon.hashCode();
			result = 31 * result + Time.hashCode();
			result = 31 * result + Price.hashCode();
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

		/*public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}*/

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

		public String getComment() {
			return Comment;
		}

		public void setComment(String comment) {
			Comment = comment;
		}


	}
