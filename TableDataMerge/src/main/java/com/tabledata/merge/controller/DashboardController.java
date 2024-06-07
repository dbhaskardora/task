package com.tabledata.merge.controller;

//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.tabledata.merge.entity.Table1;
import com.tabledata.merge.entity.Table2;
import com.tabledata.merge.repos.Table1Repos;
import com.tabledata.merge.repos.Table2Repos;
//import com.tabledata.merge.service.TableService;

//import jakarta.servlet.http.HttpServletResponse;

@Controller
	public class DashboardController {

	    @Autowired
	    private Table1Repos table1Repos;

	    @Autowired
	    private Table2Repos table2Repos;
	    @Autowired
//	    private TableService tableService;

	    @GetMapping("/dashboard")
	    public String dashboard(Model model) {
	        List<Table1> table1Data = table1Repos.findAll();
	        List<Table2> table2Data = table2Repos.findAll();

	        model.addAttribute("table1Data", table1Data);
	        model.addAttribute("table2Data", table2Data);

	        return "dashboard";
	    }

	    @PostMapping("/merge")
	    public String mergeTables() {
	        List<Table1> table1Data = table1Repos.findAll();
	        for (Table1 table1Record : table1Data) {
	            Table2 table2Record = new Table2();
	            table2Record.setId(table1Record.getId());
	            table2Record.setName(table1Record.getName());
	            table2Record.setAddress(table1Record.getAddress());
	            table2Repos.save(table2Record);
	        }
			return "redirect:/dashboard";
	    }

	    
//	    @GetMapping("/export/csv")
//	    public void exportToCSV(HttpServletResponse response) throws IOException {
//	        List<Table2> dataList = tableService.getAllRecordss();
//
//	        response.setContentType("text/csv");
//	        response.setHeader("Content-Disposition", "attachment; filename=\"dashboard.csv\"");
//
//	        PrintWriter writer = response.getWriter();
//	        writer.println("ID,Name,Value");
//	        for (Table2 table2 : dataList) {
//	            writer.println(table2.getId() + "," + table2.getName() + "," + table2.getAddress());
//	        }
//	    }
	}
