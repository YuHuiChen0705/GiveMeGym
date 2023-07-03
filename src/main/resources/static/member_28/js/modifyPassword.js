rel = "stylesheet"
href = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css"
src = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"

$(document).ready(function() {
	$('#login-form').submit(function(event) {
		event.preventDefault(); // 防止表單提交

		if (confirm("請確認是否修改資料？")) {
			var memberId = $('#memberId').text();
			console.log("memberId:" + memberId);
			var memberMail = $('#memberMail').val();
			console.log("memberMail:" + memberMail);
			var memberPassword = $('#memberPassword').val();
			console.log("memberPassword:" + memberPassword);
			var newPassword = $('#newPassword').val();
			console.log("newPassword:" + newPassword);

			// 發送AJAX請求
			$.ajax({
				url: '/front_Member/memberDataModify/summitPassword',
				//				headers: { "Content-Type": "application/json;charset=UTF-8" },
				type: 'PUT',
				dataType: 'text',
				data: {
					memberId: memberId,
					memberMail: memberMail,
					memberPassword: memberPassword,
					newPassword: newPassword
				},

				success: function(response) {
					var str =JSON.stringify(response)
					// 根據伺服器的回應進行處理
					if (str.length === 2) {
						console.log(str.length);
						console.log("印出response" + response);
						console.log('請求錯誤');
						alert("請確保新密碼不大於10個字元，並確認原密碼是否有誤!?")
					}
					else {
						console.log(str.length);
						console.log("str的長度"+str.length);
						console.log("印出response" + response);
						console.log('請求正確');
						alert("不錯嘛~資料修改成功了");
						window.location.href = '/front_Member/login';
					}
				},
				error: function() {
					// 處理請求錯誤
					alert("請確保新密碼不大於10個字元，並確認原密碼是否有誤!?")
					console.log('請求錯誤');
				}
			});
		} else {
			alert("您繼續改!")
		}
	});
});
