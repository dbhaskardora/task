package com.data.export.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.export.DataRepository.DataRepository;
import com.data.export.entity.Data;

@Service
public class DataService {


	  @Autowired
	    private DataRepository dataRepository;

	    public List<Data> getAllData() {
	        return dataRepository.findAll();
	    }
}
