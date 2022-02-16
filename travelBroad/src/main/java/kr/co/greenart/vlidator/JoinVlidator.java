package kr.co.greenart.vlidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.greenart.model.JoinInfo;

@Component
public class JoinVlidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(JoinInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target == null) {
			errors.reject("JoinInfo.null" , "입령정보가 없습니다.");
		}
		
		JoinInfo user = (JoinInfo) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty","아이디를 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty","비밀번호를 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordCheck", "passwordCheck.empty","비밀번호를 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty","이름을 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.empty","핸드폰을 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "nickName.empty","닉네임를 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.empty","성별을 입력해주세요" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkBox", "checkBox.empty","여행지를 선택해주세요" );
		
	}

}
