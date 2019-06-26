package jp.te4a.spring.boot.myapp11;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
public class TestValidator implements ConstraintValidator<TestValid,String>{
	String param;
	@Override
	public void initialize(TestValid nv){ param =  nv.param(); }
	@Override
	public boolean isValid(String in,ConstraintValidatorContext cxt){
		if(in == null){
			return false;
		}
		System.out.println(in.equals(param));
		return !in.equals(param);
	}
	@Data
	@NoArgsConstructor
	public class BookForm {
		private Integer id ;
		@NotNull
		@Size(min = 3)
		@TestValid(param = "abc")
		private String title;
		@Size(min = 3, max = 20)
		private String writter;
		private String publisher;
		@Min(0)
		private Integer price;
	}

}