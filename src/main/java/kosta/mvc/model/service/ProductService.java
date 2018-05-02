package kosta.mvc.model.service;

import java.util.List;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

public interface ProductService {
	/**
	    * 검색
	    * */
		List<ProductDTO> select();
		
		/**
		 * 등록
		 * */
		int insert(ProductDTO productDTO)throws MyErrorException;
		
		/**
		 * 삭제
		 * */
		 int delete(String code)throws MyErrorException;
}
