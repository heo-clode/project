package com.tang.pan.manager;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tang.pan.search.SchoolVO;
import com.tang.pan.signup.UserVO;

@Controller
public class ManagerController {
	@Inject
	ManagerService service;

	@RequestMapping("/mlist")
	public String managerPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");

		int m_num = Integer.parseInt(request.getParameter("m_num"));
		session.setAttribute("m_num", m_num);

		model.addAttribute("m_num", m_num);

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		switch (m_num) {
		case 1:
			model.addAttribute("mlist", service.scList());
			break;

		case 2:
			model.addAttribute("mlist", service.mmList());
			break;

		case 3:
			model.addAttribute("mlist", service.BoardAll());
			break;

		case 4:
			model.addAttribute("mlist", service.ReplyAll());
			break;
		}

		return "manager/managerPage";
	}
	
	@RequestMapping("/mReg")
	public String managerReg(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		session.setAttribute("m_num", m_num);
		
		model.addAttribute("m_num", m_num);
		
		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);
		
		switch (m_num) {
		case 1:
			model.addAttribute("mlist", service.scList());
			break;

		case 2:
			model.addAttribute("mlist", service.mmList());
			break;
		
		case 3:
			model.addAttribute("mlist",service.BoardAll());	
			break;

		case 4:
			model.addAttribute("mlist",service.ReplyAll());
			break;
		}
		
		return "manager/managerReg";
	}

	@RequestMapping("/mDel")
	public String mDel(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		int m_num = (int) session.getAttribute("m_num");
		model.addAttribute("m_num", m_num);

		switch (m_num) {
		case 1:
			// System.out.println(request.getParameter("sc_code"));
			String sc_code = request.getParameter("sc_code");
			service.sc_mmDel(sc_code);
			service.sc_boDel(sc_code);
			service.scDel(sc_code);
			model.addAttribute("mlist", service.scList());
			break;

		case 2:
			System.out.println(request.getParameter("mm_code"));
			String mm_code = request.getParameter("mm_code");
			service.mm_reDel(mm_code);
			service.mm_bpDel(mm_code);
			service.mmDel(mm_code);
			model.addAttribute("mlist", service.mmList());
			break;

		case 3:
			System.out.println(request.getParameter("bp_no"));
			service.bpDel(Integer.parseInt(request.getParameter("bp_no")));
			model.addAttribute("mlist", service.BoardAll());
			break;

		case 4:
			System.out.println(request.getParameter("re_no"));
			service.reDel(Integer.parseInt(request.getParameter("re_no")));
			model.addAttribute("mlist", service.ReplyAll());
			break;
		}
		return "manager/managerPage";
	}
	
	@RequestMapping("/mRegTRY")
	public String mReg(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		int m_num = (int) session.getAttribute("m_num");
		model.addAttribute("m_num", m_num);
		
		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);
		
		switch (m_num) {
		case 1:
			SchoolVO scvo = new SchoolVO();
			scvo.setSc_code((String) request.getParameter("sc_code"));
			scvo.setSc_name((String) request.getParameter("sc_name"));
			scvo.setSc_local((String) request.getParameter("sc_local"));
			service.scReg(scvo);
			model.addAttribute("mlist", service.scList());
			break;

		case 2:
			UserVO uvo = new UserVO();
			uvo.setMm_sccode((String) request.getParameter("mm_sccode"));
			uvo.setMm_id((String) request.getParameter("mm_id"));
			uvo.setMm_pw((String) request.getParameter("mm_pw"));
			uvo.setMm_name((String) request.getParameter("mm_name"));
			uvo.setMm_email((String) request.getParameter("mm_email"));
			uvo.setMm_pnum((String) request.getParameter("mm_pnum"));
			service.mmReg(uvo);
			model.addAttribute("mlist", service.mmList());
			break;
		}
		return "manager/managerPage";
	}
}
