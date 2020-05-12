package com.mindtree.vechicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.vechicle.entity.Vertical;

@Repository
public interface VerticalRepository extends JpaRepository<Vertical, Integer>{

}
