package day7;

import java.util.ArrayList;

public class Haversack {
	ArrayList<Haversack> parent = new ArrayList<>();
	ArrayList<Haversack> children = new ArrayList<>();
	int quantity;
	
	
	
	public ArrayList<Haversack> getParent() {
		return parent;
	}
	public void setParent(ArrayList<Haversack> parent) {
		this.parent = parent;
	}
	public ArrayList<Haversack> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Haversack> children) {
		this.children = children;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addChild(Haversack child) {
		children.add(child);
	}
	
	

}
