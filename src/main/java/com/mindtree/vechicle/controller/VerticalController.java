package com.mindtree.vechicle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.vechicle.entity.Vertical;
import com.mindtree.vechicle.service.VerticalService;

@Controller
public class VerticalController {

	@Autowired
	VerticalService verticalService;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		model.put("verticals", verticalService.getvertical());
		return "index";
	}

	@PostMapping("/saveDetails")
	public String addProject(Vertical verticalone, Model model) {
		verticalService.addvertical(verticalone);
		model.addAttribute("verticals", verticalService.getvertical());
		return "index";
	}

	int id = 0;
	@RequestMapping("/updatedetails")
	public String update(int verticalId,Model model) {
		id=verticalId;
		Vertical vertical=verticalService.getupdated(verticalId);
		model.addAttribute("verticals", verticalService.getvertical());
		model.addAttribute("vertical",vertical);
		System.out.println(id);
		return "index";
	}

	@RequestMapping("/saveUpdate")
	public String saveUpdate(@RequestParam("verticalName") String verticalName, Model model) {
		verticalService.saveUpdate(verticalName, id);
		model.addAttribute("verticals", verticalService.getvertical());
		return "index";
	}
	@RequestMapping("/delete")
	public String delete(Model model,@RequestParam("verticalId") int verticalId) {
		verticalService.delete(verticalId);
		model.addAttribute("verticals",verticalService.getvertical());
		return "index";
	}
}
