package com.jims.work.entity;

public class City {

	private String name;//城市的名字
	private String pinyin;//城市名字的拼音
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	public City(String name, String pinyin) {
		this.name = name;
		this.pinyin = pinyin;
	}
	
	
}
