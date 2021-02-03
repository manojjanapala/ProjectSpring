package com.development.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.development.demo.layer1.Emi;
import com.development.demo.layer3.EmiService;

@RestController
@CrossOrigin
public class EMIController {
	
	@Autowired
	EmiService emiService;
	@RequestMapping("/getEMI")
	@ResponseBody
	@CrossOrigin
	public Emi getEMI(int EMIId)
	{
		try {
			return emiService.getEMIService(EMIId);
		}catch(Exception e) {
			System.out.println("Exception");
			return null;
		}
		
	}
	
	@RequestMapping("/getAllEMIs")
	@ResponseBody
	@CrossOrigin
	public List<Emi>getAllEMIs(){
		List<Emi> emiList= (List<Emi>)emiService.getAllEMIsService();
		return emiList;
	}
	
	@PostMapping(path="/addEMI")
	@ResponseBody
	@CrossOrigin
	public String addEMI(@RequestBody Emi emi)
	{
		try {
			emiService.addEMIService(emi);
			return "success";
		}catch(Exception e) {
			return "fail";
		}
	}
	
	@PostMapping(path="/updateEMI")
	@ResponseBody
	@CrossOrigin
	public String updateEMI(@RequestBody Emi emi)
	{
		try {
			return emiService.updateEMIService(emi);
		}catch(Exception e) {
			return "fail";
		}
	}
	
}
