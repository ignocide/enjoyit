//package com.prj.enjoy.login.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.prj.enjoy.login.dao.AdminDao;
//
//@Controller
//public class AdminController_bak {
//	@Autowired
//	private SqlSession sqlSession;
//
//	@RequestMapping("admin")
//	public String admin() {
//		return "admin";
//	}
////�씤�룷�듃�떆 湲��옄媛� 爰좎��굹�슂 �븞爰좎��굹�슂 �뀒�뒪�듃
//	
//	@RequestMapping("/adminLoginProc")
//	public String adminLogin(HttpServletRequest request) {
//		String adid = request.getParameter("adid");
//		String adpw = request.getParameter("adpw");
//		AdminDao dao = sqlSession.getMapper(AdminDao.class);
//
//		
//		if (dao.getAdmin(adid) == null) {
//			System.out.println("no id");
//			return "/admin";
//		} else if (!dao.getAdmin(adid).getAdpw().equals(adpw)) {
//			System.out.println("wrong pw");
//			return "/admin";
//		} else {
//			System.out.println("login success");
//			return "redirect:admin/adminMain";
//		}
//	}
//
//	@RequestMapping("/admin/adminMain")
//	public String adminMain(HttpServletRequest request, Model model) {
//		System.out.println("passing adminMain");
//		String cusort = request.getParameter("sort");
//		String busort = request.getParameter("sort");
//		AdminDao dao = sqlSession.getMapper(AdminDao.class);
//		if (cusort==null) {
//			System.out.println(busort);
//		}
//		if (cusort != null && busort != null) {
//			cusort = "cu" + cusort;
//			System.out.println(cusort);
//			busort = "bu" + busort;
//			System.out.println(busort);
//			model.addAttribute("clist", dao.getCustomer(cusort));
//			model.addAttribute("blist", dao.getBusiness(busort));
//		}
//		else {
//			model.addAttribute("clist", dao.getCustomer());
//			model.addAttribute("blist", dao.getBusiness());
//			
//		}
//
//		return "admin/adminMain";
//	}
//	@RequestMapping("/admin/cuManagement")
//	public String cuManagement(HttpServletRequest request, Model model) {
//		String cunum= request.getParameter("cunum");
//		System.out.println("cunum �솕�땲?? " + cunum);
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		model.addAttribute("cu",dao.getCuInfo(cunum));
//		
//		return "admin/cuManagement";
//	}
//	@RequestMapping("/admin/buManagement")
//	public String buManagement(HttpServletRequest request, Model model) {
//		String bunum= request.getParameter("bunum");
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		model.addAttribute("bu",dao.getBuInfo(bunum));
//		
//		return "admin/buManagement";
//	}
//	@RequestMapping("/del_cu")
//	public String del_cu(HttpServletRequest request) {
//		System.out.println("passing del_cu");
//		String cunum= request.getParameter("cunum");
//		System.out.println("cunum : "+ cunum);
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		dao.del_cu(cunum);
//		return "redirect:admin/adminMain";
//		
//	}
//	
//	@RequestMapping("/del_bu")
//	public String del_bu(HttpServletRequest request) {
//		String bunum= request.getParameter("bunum");
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		dao.del_bu(bunum);
//		return "redirect:admin/adminMain";
//		
//	}
//	@RequestMapping("admin/edit_cu")
//	public String edit_cu(HttpServletRequest request, Model model) {
//		String cunum= request.getParameter("cunum");
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		model.addAttribute("cu",dao.getCuInfo(cunum));
//		return "admin/edit_cu";
//	}
//	@RequestMapping("admin/edit_bu")
//	public String edit_bu(HttpServletRequest request, Model model) {
//		String bunum= request.getParameter("bunum");
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		model.addAttribute("bu",dao.getBuInfo(bunum));
//		return "admin/edit_bu";
//	}
//
//
//	@RequestMapping("/admin/editProc_cu")
//	public String editProc_cu(HttpServletRequest request, Model model) {
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		String cunum = request.getParameter("cunum");
//		String cuid = request.getParameter("cuid");
//		String cuname = request.getParameter("cuname");
//		String cuaddr = request.getParameter("cuaddr");
//		String cuemail = request.getParameter("cuemail");
//		String cubirth = request.getParameter("cubirth");
//		String cugender = request.getParameter("cugender");
//		String cutel = request.getParameter("cutel");
//		
//		
//		dao.editProc_cu(cuid,cuname,cuaddr,cuemail,cubirth,cugender,cutel,cunum);
//		model.addAttribute("cunum",cunum);
//		return "redirect:cuManagement";
//	}
//	
//	@RequestMapping("/admin/editProc_bu")
//	public String editProc_bu(HttpServletRequest request, Model model) {
//		System.out.println("editProc_bu passing");
//		AdminDao dao =sqlSession.getMapper(AdminDao.class);
//		String bunum = request.getParameter("bunum");
//		String buid = request.getParameter("buid");
//		String buname = request.getParameter("buname");
//		String buaddr = request.getParameter("buaddr");
//		String buemail = request.getParameter("buemail");
//		String burenum = request.getParameter("burenum");
//		String butel = request.getParameter("butel");
//		dao.editProc_bu(buid,buname,buaddr,buemail,burenum,butel,bunum);
//		model.addAttribute("bunum",bunum);
//		return "redirect:buManagement";
//	}
//}