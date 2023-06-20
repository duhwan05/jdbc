package koreait.jdbc.day4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder
public class JProduct {
	private String pcode;
	private String category;
	private String pname;
	private int price;
	
	@Override
	public String toString() {
		return "상품 코드 : " + pcode + "| 카테고리 : " + category + "| 상품명 : " + pname + "| 가격 : " + price;
	}

}