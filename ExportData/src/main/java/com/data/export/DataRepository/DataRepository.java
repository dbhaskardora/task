package com.data.export.DataRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.export.entity.Data;

public interface DataRepository extends JpaRepository<Data, Long>{

}
