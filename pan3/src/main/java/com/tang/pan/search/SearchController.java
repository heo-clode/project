package com.tang.pan.search;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tang.pan.notice.NoticeService;
import com.tang.pan.signup.UserVO;

@Controller
public class SearchController {
	@Inject
	private SearchService service;
	
	@Inject
	private NoticeService nService;

	// id/pw찾기 페이지 이동
	@RequestMapping(value = "/idPwSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public String idPwSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "idPwSearch";

	}

	// pw찾기 페이지로 이동
	@RequestMapping(value = "/pwSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public String pwSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "pwSearch";

	}

	// id찾기
	@RequestMapping(value = "/idSearch", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String idSearch(@RequestParam String postData) throws Exception {
		JsonParser jsonParser = new JsonParser();
		JsonObject recieve = (JsonObject) jsonParser.parse(postData);
		UserVO vo = new UserVO();
		vo.setMm_name(recieve.get("mm_name").toString().replace("\"", ""));
		vo.setMm_pnum(recieve.get("mm_pnum").toString().replace("\"", ""));
		try {
			return service.idSearch(vo).getMm_id();
		} catch (Exception e) {
			return "null";
		}
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/pwdSearch", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String pwSearch(@RequestParam String postData) throws Exception {
		JsonParser jsonParser = new JsonParser();
		JsonObject recieve = (JsonObject) jsonParser.parse(postData);
		UserVO vo = new UserVO();
		vo.setMm_id(recieve.get("mm_id").toString().replace("\"", ""));
		vo.setMm_name(recieve.get("mm_name").toString().replace("\"", ""));
		vo.setMm_pnum(recieve.get("mm_pnum").toString().replace("\"", ""));
		try {
			return service.pwSearch(vo).getMm_pw();
		} catch (Exception e) {
			return "null";
		}
	}

	@RequestMapping(value = "/schoolSearch", method = RequestMethod.POST)
	public String schoolSearch(Model model, HttpServletRequest request) throws Exception {
		SchoolVO vo = new SchoolVO();

		vo.setSc_name(request.getParameter("sc_name"));

		model.addAttribute("sc_name", service.schoolSearch(vo));

		// 공지사항 정보 보내주기
		model.addAttribute("list", nService.getNoticeList("B0000"));

		return "index";
	}
	
	@RequestMapping("/schoolSearchView")
	public String schoolSearchView(HttpServletRequest request) {
		return "scSearch";
	}
	
	@RequestMapping(value = "/scSearch", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ModelAndView schoolSearch(Model model, HttpServletRequest request, SchoolVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(service.scSearch(vo));
		
		model.addAttribute("sc", service.scSearch(vo));

		return mav;
	}
	

}
