package com.tang.pan.board;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tang.pan.category.CategoryService;
import com.tang.pan.category.CategoryVO;
import com.tang.pan.like.BoardLikeVO;
import com.tang.pan.reply.ReplyService;

@Controller
public class BoardController {
	@Inject
	private BoardService service;

	@Inject
	private CategoryService cService;

	@Inject
	private ReplyService rService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardList(Model model, HttpServletRequest request, @ModelAttribute("scri") SearchCriteria scri)
			throws Exception {
		// 세션을 통해 저장한 정보 받기
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_sccode = (String) session.getAttribute("mm_sccode");
		String mm_lev = (String) session.getAttribute("mm_lev");
		
		CategoryVO categoryvo = new CategoryVO();
		String bo_num;
		String bo_code = null;

		// 회원 이름/레벨 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		// 게시판 넘버 받아오기
		bo_num = request.getParameter("bo_num");

		// 페이징 처리할떄 bo_num == null이라서
		// bo_num == null이면, 처음에 list 불러올때 session에 넣은 값 대체
		if (bo_num == null) {
			bo_num = (String) session.getAttribute("bo_num");
		}

		session.setAttribute("bo_num", bo_num);

		int bo_num2 = Integer.parseInt(bo_num);

		categoryvo.setBo_num(bo_num2);

		// 학교코드 받아오기
		// bo_num == 0이면 공지사항 -> 학교코드 S0000으로 고정
		if (bo_num2 == 0) {
			categoryvo.setBo_sccode("S0000 ");
		} else {
			categoryvo.setBo_sccode(mm_sccode);
		}
		// categoryvo(bo_num, bo_scccode)를 통해 bo_code 받아오기
		bo_code = cService.getBocode(categoryvo);
		session.setAttribute("bo_code", bo_code);

		scri.setBo_code(bo_code);

		model.addAttribute("list", service.getBoardList(scri));
		model.addAttribute("bo_code", bo_code);
		model.addAttribute("bo_num", bo_num2);

		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);

		return "board/list";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");

		// 회원 이름/레벨 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		return "board/write";
	}

	@RequestMapping("/writeTRY")
	public ModelAndView writeTRY(HttpServletRequest request, @ModelAttribute("scri") SearchCriteria scri)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		String bo_code = (String) session.getAttribute("bo_code"); // 세션에 저장해둔 bo_code 받기
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");

		BoardVO boardvo = new BoardVO();

		boardvo.setBp_bocode(bo_code);
		boardvo.setBp_name(request.getParameter("bp_name"));
		boardvo.setBp_content(request.getParameter("bp_content"));
		boardvo.setBp_writer(mm_name);
		boardvo.setBp_mmcode((String) session.getAttribute("mm_code"));

		if (bo_code.equals("B0000")) {
			if (mm_lev.equals("E ")) {
				mav.addObject("msg", "권한이 없습니다.");
			} else {
				service.insertBoard(boardvo);
			}
		} else {
			service.insertBoard(boardvo);
		}

		// 게시글 목록 / 회원 이름 불러오기
		scri.setBo_code(bo_code);
		mav.addObject("list", service.getBoardList(scri));
		mav.addObject("mm_name", mm_name);
		mav.addObject("mm_lev", mm_lev);

		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		mav.addObject("pageMaker", pageMaker);

		mav.setViewName("board/list");

		return mav;
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_code = (String) session.getAttribute("mm_code");
		String mm_lev = (String) session.getAttribute("mm_lev");

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		// 게시글 정보 가져오기
		BoardVO boardvo = new BoardVO();
		String bp_no = request.getParameter("bp_no");

		boardvo.setBp_bocode((String) session.getAttribute("bo_code")); // 세션에 넣은 값 받는거

		if (bp_no == null) {
			boardvo.setBp_no(Integer.parseInt(request.getParameter("re_bpno")));
		} else {
			boardvo.setBp_no(Integer.parseInt(bp_no));
		}

		service.viewCnt(Integer.parseInt(bp_no));

		boardvo.setBp_mmcode(mm_code);

		// System.out.println(boardvo);

		session.setAttribute("view", boardvo);

		model.addAttribute("view", service.view(boardvo));
		model.addAttribute("bo_num", session.getAttribute("bo_num"));
		model.addAttribute("mm_code", mm_code);
		
		// 좋아요
		int boardlike = service.getBoardLike(boardvo);
		model.addAttribute("heart", boardlike);
		
		return "board/view";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_lev = (String) session.getAttribute("mm_lev");

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		// 게시글 정보 가져오기
		BoardVO boardvo = new BoardVO();

		boardvo.setBp_bocode((String) session.getAttribute("bo_code"));
		boardvo.setBp_no(Integer.parseInt(request.getParameter("bp_no")));

		model.addAttribute("view", service.view(boardvo));
		model.addAttribute("bo_num", session.getAttribute("bo_num"));

		return "board/delete";
	}

	@RequestMapping("/deleteTRY")
	public String deleteTRY(HttpServletRequest request, Model model, @ModelAttribute("scri") SearchCriteria scri)
			throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String bo_code = (String) session.getAttribute("bo_code");
		String mm_lev = (String) session.getAttribute("mm_lev");
		BoardVO boardvo = new BoardVO();

		int bp_no = Integer.parseInt(request.getParameter("bp_no"));

		// 게시글 삭제
		boardvo.setBp_bocode(bo_code);
		boardvo.setBp_no(bp_no);

		// 댓글o -> 댓글 먼저 삭제
		rService.replyAllDelete(bp_no);

		service.deleteBoard(boardvo);

		// 게시글 목록 받아오기
		scri.setBo_code(bo_code);

		model.addAttribute("list", service.getBoardList(scri));
		model.addAttribute("mm_name", mm_name);
		model.addAttribute("mm_lev", mm_lev);

		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);

		return "board/list";
	}

	@RequestMapping("/update")
	public String update(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);

		// 게시글 정보 가져오기
		BoardVO boardvo = new BoardVO();

		boardvo.setBp_bocode((String) session.getAttribute("bo_code"));
		boardvo.setBp_no(Integer.parseInt(request.getParameter("bp_no")));

		model.addAttribute("view", service.view(boardvo));
		model.addAttribute("bo_num", session.getAttribute("bo_num"));

		return "board/update";
	}

	@RequestMapping("/updateTRY")
	public String updateTRY(HttpServletRequest request, Model model, @ModelAttribute("scri") SearchCriteria scri)
			throws Exception {
		HttpSession session = request.getSession();
		String mm_name = (String) session.getAttribute("mm_name");
		String mm_code = (String) session.getAttribute("mm_code");

		// 회원 이름 받아오기
		model.addAttribute("mm_name", mm_name);

		// 게시글 정보 가져오기
		BoardVO boardvo = new BoardVO();

		boardvo.setBp_bocode((String) session.getAttribute("bo_code"));
		boardvo.setBp_no(Integer.parseInt(request.getParameter("bp_no")));
		boardvo.setBp_mmcode(mm_code);
		boardvo.setBp_name(request.getParameter("bp_name"));
		boardvo.setBp_content(request.getParameter("bp_content"));

		service.updateBoard(boardvo);

		model.addAttribute("view", service.view(boardvo));
		model.addAttribute("bo_num", session.getAttribute("bo_num"));
		model.addAttribute("mm_code", mm_code);

		return "board/view";
	}

	// 좋아요
	@ResponseBody
	@RequestMapping(value = "/heart", method = RequestMethod.POST, produces = "application/json")
	public int heart(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int heart = Integer.parseInt(request.getParameter("heart"));
		int li_bpno = Integer.parseInt(request.getParameter("li_bpno"));
		String li_mmcode = (String) session.getAttribute("mm_code");

		BoardLikeVO boardLikeVO = new BoardLikeVO();

		boardLikeVO.setLi_bpno(li_bpno);
		boardLikeVO.setLi_mmcode(li_mmcode);
		
		if (heart >= 1) {
			service.deleteBoardLike(boardLikeVO);
			heart = 0;
		} else {
			service.insertBoardLike(boardLikeVO);
			heart = 1;
		}

		return heart;

	}

}
