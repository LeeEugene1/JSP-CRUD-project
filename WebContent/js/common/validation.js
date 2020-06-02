String.prototype.validationID = function() {
	return /^[a-z0-9]{2,5}$/.test(this);
};
String.prototype.validationPWD = function() {
	return /^[a-z0-9]{4,8}$/.test(this);
};
String.prototype.validationNM = function() {
	return /^[가-힣]{2,5}$/.test(this);
};
String.prototype.validationRegno1 = function(){
	return /^\d{6}$/.test(this);
};
String.prototype.validationRegno2 = function(){
	return /^\d{7}$/.test(this);
};
String.prototype.validationREGNO = function() {
	var moto = this.replace('-', '');
	var magicNum = this.substr(13,1);
	var sum = 0;
	var checkSum = "234567892345";
	
	for(var i = 0; i<12; i++) {
		sum += moto.charAt(i) * checkSum.charAt(i);
	}
	
	var finalVal = (11-(sum%11))%10;
	if(finalVal == parseInt(magicNum)) {
		return true;
	} else {
		return false;
	}	
};
String.prototype.validationBIR = function() {
	return /^(19\[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\s(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/.test(this);
};
String.prototype.validationMAIL = function() {
	return /^[a-z]\d{3}@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};
// /^0[0-9]{1,2}-[0-9]{3}-[0-9]{4}$/
// 집전화번호 : 지역번호 서울 두 자리, 그 외 직역 세자리
//			국번 세 자리 또는 네 자리
//			전화번호 네 자리
String.prototype.validationHOMETEL = function() {
	return /^0[0-9]{1,2}-[0-9]{3}-[0-9]{4}$/.test(this);
};

// 회사전화번호 : 지역번호 서울 두 자리, 그 외 직역 세자리
//			국번 세 자리 또는 네 자리
//			전화번호 네 자리
String.prototype.validationCOMTEL = function() {
	return /^0[0-9]{1,2}-[0-9]{3}-[0-9]{4}$/.test(this);
};
// /^01[0,1,6,7,8]-[0-9]{4}-[0-9]{4}$/
// 핸드폰 전화번호
// '010, 011, 016, 017, 018 - 국번 세 자리 또는 네 자리 - 전화번호 네자리'
// '010-1111-1111'.validationHP()
String.prototype.validationHP = function() {
	return /^01[0,1,6,7,8]-[0-9]{4}-[0-9]{4}$/.test(this);
};
// /^[0-9]{3}-[0-9]{3}$/
// 우편번호
// '111-111'.validationZIPCODE()
String.prototype.validationZIPCODE = function() {
	return /^[0-9]{3}-[0-9]{3}$/.test(this);
};

String.prototype.validationADDR = function() {
	//return /^[가-힣]{2,5}$/.test(this);
	return /^[가-힣 ]*$/.test(this);
};


// prod

String.prototype.validationPRODID = function() {
	return /^P[0-9]{3,9}$/.test(this);
};

String.prototype.validationPRODLGU = function() {
	return /^P[0-9]{3}$/.test(this);
};

String.prototype.validationPRODNumber = function() {
	return /^[0-9]*$/.test(this);
};

String.prototype.validationPRODDate = function() {
	return /^(19\[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(this);
};


// buyer
String.prototype.validationBUYID = function() {
	return /^P[0-9]{5}$/.test(this);
};

String.prototype.validationBUYMail = function() {
	return /^[a-z0-9]*@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};


// freeboard
String.prototype.validationBOARD = function() {
	return /^[가-힣a-z0-9]+$/.test(this);
};









// MemberFormController에 입력 값 검증 적용

// 교재에서 서블릿 부분가지 정독 복습
// 상시학습의 서블릿 부분 동영상 복습
















