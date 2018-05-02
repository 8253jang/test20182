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
		//��� ���ڵ� ��������
		List<ProductDTO> list = service.select();
		model.addAttribute("list", list);//���ʿ��� ${list}
		
		return "productList";//WEB-INF/views/proudctList.jsp�̵�
	}
	
	@RequestMapping("/{url}")
	public void url() {}
	
	/**
	 * ����ϱ�
	 * */
	@RequestMapping("/insert")
	public String insert(ProductDTO dto)throws MyErrorException{
		service.insert(dto);
		
		//insert�� �����ϸ� ���� redirect�� /�� ȣ��.
		return "redirect:/";//controller�� �̵�.
	}
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/delete/{code}")
	public String delete(@PathVariable String code , String code2)throws MyErrorException {
		System.out.println("controller code : " + code);
		System.out.println("controller code2 : " + code2);
		service.delete(code);
		return "redirect:/";
	}
	
	
	
	/**
	 *  ����ó�� �޼ҵ� �ۼ� @ExceptionHanlder �̿�
	 *  ������ ���� error.jsp�̵�
	 * */
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(Exception e) {
		
		return new ModelAndView("error/error" , "errMessage", e.getMessage());
	}
}










