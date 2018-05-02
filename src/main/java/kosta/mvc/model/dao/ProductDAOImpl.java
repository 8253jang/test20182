package kosta.mvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository //id="productDAOImpl"
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private List<ProductDTO> list;
	
	@Override
	public List<ProductDTO> select() {
		
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//추가하기 전에 상품코드가 중복인지 체크하고
		//중복이면 예외발생시킨다.(예외메시지 : 상품코드 ~는 중복입니다.
		if(this.search(productDTO.getCode()) != null){
			throw new MyErrorException("상품코드 " + productDTO.getCode()+"는 중복입니다.");
		}
		
		int re = list.add(productDTO) ? 1 : 0; 
		
		return re;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		 ProductDTO dto = this.search(code);
		 if(dto==null) {
			 throw new MyErrorException("상품코드 오류로 삭제 되지 않았습니다.");
		 }
		 
		 list.remove(dto);
		 
		return 0;
	}
	
	/**
	 * 상품코드에 해당하는 상품 정보 찾기
	 * */
	public ProductDTO search(String code) {
		System.out.println("code : "+code);
		 for(ProductDTO dto : list) {
			 if(dto.getCode().equals(code)) {
				 return dto;
			 }
		 }
		 
		 return null;
	}

}










