$(document).ready(function() {
	$('#login-form').submit(function(event) {
		event.preventDefault(); // 防止表單提交

		var employeeMail = $('#mail').val();
		var employeePassword = $('#password').val();

		// 發送AJAX請求
		$.ajax({
			url: '/front_Employee/loginSummit',
			type: 'POST',
			dataType: 'json',
			data: {
				employeeMail:employeeMail,
				employeePassword: employeePassword
			},
			success: function(response) {
				// 根據伺服器的回應進行處理
				if (response > 0) {
					console.log('請求正確');
					var memberId = response; // 接收後端傳回的memberId
					alert("登入成功");
					// 登入成功後，將會員 ID 存儲到 session
					sessionStorage.setItem("memberId", memberId)
					// 登入成功，進入後台首頁
					window.location.href = '/GiveMeGym/backend/index';
				} else {
					// 登入成功，執行相應的操作
					alert("登入失敗，請確認信箱與密碼是否正確");
				}
			},
			error: function() {
				// 處理請求錯誤
				Swal.fire({
					text: "登入失敗，請確認信箱與密碼是否正確。",
					icon: "error",
					confirmButtonText: "確定",
				});
				console.log('請求錯誤');
			}
		});
	});
});