package kr.co.greenart.vlidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.greenart.model.JoinInfo;
import kr.co.greenart.model.LoginInfo;
import kr.co.greenart.model.WritInfo;

@Component
public class WriteVlidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(WritInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target == null) {
			errors.reject("WritInfo.null" , "입력정보가 없습니다.");
		}
		
		WritInfo user = (WritInfo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty","제목을 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "location.empty","여행지역을 입력해주세요" );
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "date.empty","여행 날짜를 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "text.empty","내용을 입력해주세요" );
		
		
	}

}
