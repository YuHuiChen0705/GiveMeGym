rel = "stylesheet"
href = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css"
src = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"
//// 登入頁面驗證
//var mail = document.getElementById("mail");
//var password = document.getElementById("password");
//var mailError = document.getElementById("mail-error");
//var passwordError = document.getElementById("password-error");
//var submit1 = document.getElementById("submit1");
//
//submit1.addEventListener("click", function(event) {
//	event.preventDefault(); // 阻止默認提交行為
//	validateLoginForm(); // 調用登入頁面表單驗證函數
//});
//
//function validateLoginForm() {
//	var mailValue = mail.value.trim();
//	var passwordValue = password.value.trim();
//
//	// 驗證帳號
//	if (mailValue.length < 6) {
//		mailError.innerHTML = "請輸入電子信箱。";
//		alert("請輸入電子郵箱");
//		return false;
//	} else if (!mailValue.match(/^\w{6,20}@\w{2,8}\.com$/)) {
//		mailError.innerHTML = "請輸入正確的電子信箱。";
//		alert("請輸入正確的電子信箱");
//		return false;
//	} else {
//		mailError.innerHTML = "";
//	}
//
//	// 验证密码
//	if (passwordValue.length < 6 || passwordValue.length > 20) {
//		passwordError.innerHTML = "密碼長度必須介於6~20個字元。";
//		alert("密碼長度必須介於6~20個字元。");
//		return false;
//	} else if (!passwordValue.match(/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{6,20}$/)) {
//		passwordError.innerHTML = "密碼必須包含英文字母和數字。";
//		alert("密碼必須包含英文字母和數字。");
//		return false;
//	} else {
//		passwordError.innerHTML = "";
//
//	}
//	// 表單驗證通過
//	return true;
//
//}
//
//
// 注册頁面表單驗證
var memberName = document.getElementById("memberName");
var memberMail = document.getElementById("memberMail");
var memberPassword = document.getElementById("memberPassword");
var memberPhoneNumber = document.getElementById("memberPhoneNumber");
var memberBirthDay = document.getElementById("memberBirthDay");
var memberBirthMonth = document.getElementById("memberBirthMonth");
var memberDistrict = document.getElementById("memberDistrict");
var memberDetail = document.getElementById("memberDetail");
var nameError2 = document.getElementById("name-error2");
var mailError2 = document.getElementById("mail-error2");
var passwordError2 = document.getElementById("password-error2");
var phonenumberError2 = document.getElementById("phonenumber-error2");
var birthselectError2 = document.getElementById("birthselect-error2");
var addressError2 = document.getElementById("address-error2");
var submit2 = document.getElementById("submit2");

//submit2.addEventListener("click", function(event) {
//	event.preventDefault(); // 阻止提交的行為
//	validateRegistrationForm(); // 調用注册頁面表單驗證函數
//});

submit2.addEventListener("click", function(event) {
	if (!validateRegistrationForm()) {
		event.preventDefault(); // 阻止表单提交的默认行为
	}



	function validateRegistrationForm() {
		var nameValue2 = memberName.value.trim();
		var mailValue2 = memberMail.value.trim();
		var passwordValue2 = memberPassword.value.trim();
		var phonenumberValue2 = memberPhoneNumber.value.trim();
		var dayValue = memberBirthDay.value.trim();
		var monthValue = memberBirthMonth.value.trim();
		var districtValue = memberDistrict.value.trim();
		var addressValue3 = memberDetail.value.trim();
		var errorAllValues = document.querySelector(".error")
		errorAllValues.innerHTML = "";

		// 驗證姓名
		if (nameValue2.length <= 2) {
			memberName.value = "";
			nameError2.innerHTML = "請輸入姓名。";
			Swal.fire({
				text: "請輸入姓名",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else if (!nameValue2.match(/^[\u4E00-\u9Fa5]+$/)) {
			memberName.value = "";
			nameError2.innerHTML = "請輸入中文姓名。";
			Swal.fire({
				text: "請輸入中文姓名",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			nameError2.innerHTML = "";
		};

		// 驗證信箱
		if (mailValue2.length < 6) {
			memberMail.value = "";
			mailError2.innerHTML = "請輸入電子信箱";
			Swal.fire({
				text: "請輸入電子信箱",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else if (!mailValue2.match(/^\w{6,20}@\w{2,8}\.com$/)) {
			memberMail.value = "";
			mailError2.innerHTML = "請輸入正確的電子信箱。";
			Swal.fire({
				text: "請輸入正確的電子信箱",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			mailError2.innerHTML = "";
		};

		// 驗證密碼
		if (passwordValue2.length < 6 || passwordValue2.length > 15) {
			Swal.fire({
				text: "密碼長度需6~15個字元。",
				icon: "error",
				confirmButtonText: "確定",
			});
			passwordError2.innerHTML = "密碼長度需6~15個字元。";
			return false;
		} else if (!passwordValue2.match(/^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{6,20}$/)) {
			passwordError2.innerHTML = "密碼必須包含數字和英文。";
			Swal.fire({
				text: "密碼必須包含數字和英文。",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			passwordError2.innerHTML = "";
		};

		// 驗證手機號碼
		if (!phonenumberValue2.match(/^(09)[0-9]{8}$/)) {
			phonenumberError2.innerHTML = "手機號碼輸入錯誤。";
			Swal.fire({
				text: "手機號碼輸入錯誤",
				icon: "error",
				confirmButtonText: "確定",
			});
			memberPhoneNumber.value = "";
			return false;
		} else {
			phonenumberError2.innerHTML = "";
		};

		// 驗證出生年月日
		if (monthValue === "0") {
			birthselectError2.innerHTML = "未選擇出生日期。";
			Swal.fire({
				text: "未選擇出生日期",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			birthselectError2.innerHTML = "";
		};
		// 驗證出生年月日
		if (dayValue === "0") {
			birthselectError2.innerHTML = "未選擇出生日期。";
			Swal.fire({
				text: "未選擇出生日期",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			birthselectError2.innerHTML = "";
		};
		// 驗證地址
		if (districtValue === "0") {
			addressError2.innerHTML = "未選擇行政區。";
			Swal.fire({
				text: "未選擇行政區",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else if (addressValue3.length < 5) {
			addressError2.innerHTML = "地址輸入錯誤。";
			memberDetail.value = "";
			Swal.fire({
				text: "地址輸入錯誤",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else if (addressValue3.match(/^[a-zA-Z]+\w*/g)) {
			addressError2.innerHTML = "地址不能為英文。";
			Swal.fire({
				text: "地址不能為英文",
				icon: "error",
				confirmButtonText: "確定",
			});
			memberDetail.value = "";
			return false;
		} else {
			addressError2.innerHTML = "";
		};
		alert("已寄送驗證信至您的信箱");
		return true;

	};

});
