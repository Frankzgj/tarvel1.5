package com.lonton.bean;



/**
 * 从数据库读取出来的数据，包括景点名字，景点ID，景点简介，所在省份，所在城市
 * @author 张国军
 * @date 2015/8/6
 */
public class TripData {
	private int parent_target_Id;
	private int target_Id;
	private String target_Name;
	private String desc;
	private String cover;
	public int getParent_target_Id() {
		return parent_target_Id;
	}
	public void setParent_target_Id(int parent_target_Id) {
		this.parent_target_Id = parent_target_Id;
	}
	public int getTarget_Id() {
		return target_Id;
	}
	public void setTarget_Id(int target_Id) {
		this.target_Id = target_Id;
	}
	public String getTarget_Name() {
		return target_Name;
	}
	public void setTarget_Name(String target_Name) {
		this.target_Name = target_Name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "TripData [parent_target_Id=" + parent_target_Id + ", target_Id=" + target_Id + ", target_Name="
				+ target_Name + ", desc=" + desc + ", cover=" + cover + "]";
	}
	
}
