package vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookVo {
	private int no;
	private String name;
	private String publisher;
	private String writer;
	private int price;
	
	public BookVo(String name, String publisher, String writer, int price) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", name=" + name + ", publisher=" + publisher + ", writer=" + writer + ", price="
				+ price + "]";
	}
	
}


