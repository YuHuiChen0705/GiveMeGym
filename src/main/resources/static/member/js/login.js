$(document).ready(function() {
	$('#login-form').submit(function(event) {
		event.preventDefault(); // 防止表單提交

		var memberMail = $('#mail').val();
		var memberPassword = $('#password').val();

		// 發送AJAX請求
		$.ajax({
			url: '/front_Member/loginSummit',
			type: 'POST',
			dataType: 'json',
			data: {
				memberMail: memberMail,
				memberPassword: memberPassword
			},
			success: function(response) {
				// 根據伺服器的回應進行處理
				if (response > 0) {
					console.log('請求正確');
					var memberId = response; // 接收后端传回的memberId
					alert("登入成功");
					// 登入成功後，將會員 ID 存儲到 session
					sessionStorage.setItem("memberId", memberId)
					// 登入成功，執行相應的操作
					window.location.href = '/front_Member/memberData';
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