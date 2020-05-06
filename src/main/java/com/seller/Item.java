package com.seller;

public class Item {
	
	private String itemname;
	private int itemprice;
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getItemprice() {
		return itemprice;
	}
	@Override
	public String toString() {
		return "Item [itemname=" + itemname + ", itemprice=" + itemprice + "]";
	}
	public void setItemprice(int itemprice) {
		this.itemprice = itemprice;
	}

}
