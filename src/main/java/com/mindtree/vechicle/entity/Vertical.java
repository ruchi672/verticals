package com.mindtree.vechicle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vertical {
	@Id
	private int verticalId;
	private String verticalName;
	
	public Vertical() {
		super();
	}

	public Vertical(int verticalId, String verticalName) {
		super();
		this.verticalId = verticalId;
		this.verticalName = verticalName;
	}

	public int getVerticalId() {
		return verticalId;
	}

	public void setVerticalId(int verticalId) {
		this.verticalId = verticalId;
	}

	public String getVerticalName() {
		return verticalName;
	}

	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	
	
	
	
	

}
