package com.mindtree.vechicle.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.vechicle.entity.Vertical;
import com.mindtree.vechicle.repository.VerticalRepository;
import com.mindtree.vechicle.service.VerticalService;

@Service
public class VerticalServicalImpl implements VerticalService {

	
	@Autowired
	VerticalRepository verticalreo;

	@Override
	public List<Vertical> getvertical() {
		return verticalreo.findAll();
	}

	@Override
	public void addvertical(Vertical verticalone) {
		verticalreo.save(verticalone);
		
	}

	@Override
	public void saveUpdate(String verticalName, int id) {
		// TODO Auto-generated method stub
		Vertical vertical=verticalreo.findById(id).get();
		vertical.setVerticalName(verticalName);
		verticalreo.save(vertical);
	}

	@Override
	public void delete(int verticalId) {
		// TODO Auto-generated method stub
		verticalreo.deleteById(verticalId);
	}

	@Override
	public Vertical getupdated(int verticalId) {
		return verticalreo.findById(verticalId).get();
	}
	
	
	
}
