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
		//�߰��ϱ� ���� ��ǰ�ڵ尡 �ߺ����� üũ�ϰ�
		//�ߺ��̸� ���ܹ߻���Ų��.(���ܸ޽��� : ��ǰ�ڵ� ~�� �ߺ��Դϴ�.
		if(this.search(productDTO.getCode()) != null){
			throw new MyErrorException("��ǰ�ڵ� " + productDTO.getCode()+"�� �ߺ��Դϴ�.");
		}
		
		int re = list.add(productDTO) ? 1 : 0; 
		
		return re;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		 ProductDTO dto = this.search(code);
		 if(dto==null) {
			 throw new MyErrorException("��ǰ�ڵ� ������ ���� ���� �ʾҽ��ϴ�.");
		 }
		 
		 list.remove(dto);
		 
		return 0;
	}
	
	/**
	 * ��ǰ�ڵ忡 �ش��ϴ� ��ǰ ���� ã��
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










