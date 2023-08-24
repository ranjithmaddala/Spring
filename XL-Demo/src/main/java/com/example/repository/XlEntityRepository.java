package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.entity.XlEntity;

public interface XlEntityRepository extends JpaRepository<XlEntity, Integer>{
	
}
