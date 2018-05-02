package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service  //id="productServiceImpl"
public class ProductServiceImpl implements ProductService {

   @Autowired  //byType --> byName ����
   private ProductDAO productDAO;
	
	@Override
	public List<ProductDTO> select() {
		
		return productDAO.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		// ������ ������ 1000~ 10000�� ���̰� �ƴϸ� ���ܹ߻���Ų��.
		//���ܸ޽����� "������ 1000�� ~ 10000�� ���̸� �Է� �����մϴ�."
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) {
			throw new MyErrorException("������ õ�� ~ ���� ���̸� �Է��ϼ���. ");
		}
		
		return productDAO.insert(productDTO);
	}

	@Override
	public int delete(String code) throws MyErrorException {
		 productDAO.delete(code);
		return 0;
	}

}






