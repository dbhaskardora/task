package com.tabledata.merge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tabledata.merge.entity.Table1;
import com.tabledata.merge.entity.Table2;
import com.tabledata.merge.repos.Table1Repos;
import com.tabledata.merge.repos.Table2Repos;

@Service
public class TableService {


	    @Autowired
	    private  Table1Repos table1Repos;
	    @Autowired
	    private  Table2Repos table2Repos;


	    public List<Table1> getAllRecords() {
	        return table1Repos.findAll();
	    }
	    public List<Table2> getAllRecordss() {
	        return table2Repos.findAll();
	    }

	    public void addRecord(Table1 table1) {
	        table1Repos.save(table1);
	    }
	    public void addRecord(Table2 table2) {
	        table2Repos.save(table2);
	    }

	    public void updateRecord(Table1 table1) {
	        table1Repos.save(table1);
	    }
	    public void updateRecord(Table2 table2) {
	        table2Repos.save(table2);
	    }

	    public void deleteRecord(Long id) {
	        table1Repos.deleteById(id);
	    }
	    public void deleteRecords(Long id) {
	        table2Repos.deleteById(id);
	    }
	}

