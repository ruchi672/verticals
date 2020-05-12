package com.mindtree.vechicle.service;

import java.util.List;

import com.mindtree.vechicle.entity.Vertical;

public interface VerticalService {

	List<Vertical> getvertical();

	void addvertical(Vertical verticalone);

	void saveUpdate(String verticalName, int id);

	void delete(int verticalId);

	Vertical getupdated(int verticalId);

}
