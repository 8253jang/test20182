package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service  //id="productServiceImpl"
public class ProductServiceImpl implements ProductService {

   @Autowired  //byType --> byName 주입
   private ProductDAO productDAO;
	
	@Override
	public List<ProductDTO> select() {
		
		return productDAO.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// 가격의 범위가 1000~ 10000원 사이가 아니면 예외발생시킨다.
		//예외메시지는 "가격은 1000원 ~ 10000원 사이만 입력 가능합니다."
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) {
			throw new MyErrorException("가격은 천원 ~ 만원 사이만 입력하세요. ");
		}
		
		return productDAO.insert(productDTO);
	}

	@Override
	public int delete(String code) throws MyErrorException {
		 productDAO.delete(code);
		return 0;
	}

}






