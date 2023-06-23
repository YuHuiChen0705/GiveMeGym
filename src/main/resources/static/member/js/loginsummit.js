rel = "stylesheet"
href = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css"
src = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"
// 登入頁面驗證
var mail = document.getElementById("mail");
var password = document.getElementById("password");
var mailError = document.getElementById("mail-error");
var passwordError = document.getElementById("password-error");
var submit1 = document.getElementById("submit1");

submit1.addEventListener("click", function(event) {

	if (!validateLoginForm()) {
		event.preventDefault(); // 阻止表单提交的默認行為
	}
	function validateLoginForm() {
		var mailValue = mail.value.trim();
		var passwordValue = password.value.trim();

		// 驗證帳號
		if (mailValue.length < 6) {
			mailError.innerHTML = "請輸入電子信箱。";
			Swal.fire({
				text: "請輸入電子信箱",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else if (!mailValue.match(/^\w{6,20}@\w{2,8}\.com$/)) {
			mailError.innerHTML = "請輸入正確的電子信箱。";
			Swal.fire({
				text: "請輸入正確的電子信箱",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			mailError.innerHTML = "";
		}

		// 验证密码
		if (passwordValue.length < 6 || passwordValue.length > 20) {
			passwordError.innerHTML = "密碼長度必須介於6~15個字元。";
			Swal.fire({
				text: "密碼長度必須介於6~15個字元。",
				icon: "error",
				confirmButtonText: "確定",
			});
			return false;
		} else {
			passwordError.innerHTML = "";
//			Swal.fire({
//				text: "登入成功",
//				icon: "success",
//				confirmButtonText: "確定",
//			});
		}
		// 表單驗證通過
		return true;

	}
});

