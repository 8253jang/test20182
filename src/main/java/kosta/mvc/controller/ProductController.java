package kosta.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;
import kosta.mvc.model.service.ProductServiceImpl;

@Controller
public class ProductController {
	
	@Autowired  //byType --> byName
	ProductService service ;

	@RequestMapping("/")
	public String index(Model model) {
		//모든 레코드 가져오기
		List<ProductDTO> list = service.select();
		model.addAttribute("list", list);//뷰쪽에서 ${list}
		
		return "productList";//WEB-INF/views/proudctList.jsp이동
	}
	
	@RequestMapping("/{url}")
	public void url() {}
	
	/**
	 * 등록하기
	 * */
	@RequestMapping("/insert")
	public String insert(ProductDTO dto)throws MyErrorException{
		service.insert(dto);
		
		//insert가 성공하면 나면 redirect로 /를 호출.
		return "redirect:/";//controller로 이동.
	}
	
	/**
	 * 삭제하기
	 * */
	@RequestMapping("/delete/{code}")
	public String delete(@PathVariable String code , String code2)throws MyErrorException {
		System.out.println("controller code : " + code);
		System.out.println("controller code2 : " + code2);
		service.delete(code);
		return "redirect:/";
	}
	
	
	
	/**
	 *  예외처리 메소드 작성 @ExceptionHanlder 이용
	 *  오류가 나면 error.jsp이동
	 * */
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(Exception e) {
		
		return new ModelAndView("error/error" , "errMessage", e.getMessage());
	}
}










