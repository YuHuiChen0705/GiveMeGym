package com.givemegym.courseshowoff.controller;

import com.givemegym.courseshowoff.service.CourseShowOffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CourseShowOffController {
	private CourseShowOffService courseShowOffService;

	public CourseShowOffController(CourseShowOffService courseShowOffService) {
		this.courseShowOffService = courseShowOffService;
	}

	@GetMapping("/courseShowoff")
	public String listCourseShowoff(Model model) {
		model.addAttribute("courseShowOff", courseShowOffService.getAllCourseShowOff());
	return "courseShowoff";
	}
}
	//	@Autowired
//	CourseShowOffRepository courseShowoffRepository;
//
//
//
//
//
//
//
//
//
////新增
//	@PostMapping("/courseshowoff/insert")
//	public String insert(@RequestBody CourseShowOffVo courseshowoff) {//CourseShOWOff為VO 後面為參數
//
//		System.out.println(courseshowoff);
//
//
//		courseShowoffRepository.save(courseshowoff);//必須與商方參數相同
//
//		return "新增了一筆資料";
//
//	}

//
////update
//	@PostMapping("/courseshowoff/update/{courseShowoffId}") //改一筆資料的方式，透過courseShowoffId更改CourseShowoffState
//	public String update(
////			             @PathVariable Integer memberId,
//						 @PathVariable Integer courseShowoffId,
//						 @RequestBody CourseShowOffVo courseshowoff) {//CourseShOWOff為VO 後面為參數
//		CourseShowOffVo courseResult = courseShowoffRepository.findById(courseShowoffId).orElse(null);
//
//
//		if(courseResult != null) {
//
//			courseResult.setCourseShowoffState(courseshowoff.getCourseShowoffState());
//
//			courseShowoffRepository.save(courseResult);
//			return "update" + courseShowoffId + "successs";
//		}else {
//			return "update" + courseShowoffId + "failed";
//		}
//
//		}



