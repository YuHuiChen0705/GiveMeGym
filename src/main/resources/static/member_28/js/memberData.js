// 從 session 中獲取會員 ID
var memberId = sessionStorage.getItem('memberId');
$(document).ready(function() {
	// 發送AJAX請求
	$.ajax({
		url: '/front_Member/memberData',
		type: 'GET',
		dataType: 'json',
		data: {
			memberId: memberId
		},
		success: function(response) {
			// 在前端頁面使用 AJAX 返回的 JSON 數據
			var memberName = response.memberName;
			var memberMail = response.memberMail;
			var memberPhoneNumber = response.memberPhoneNumber;
			var memberBirthYear = response.memberBirthYear;
			var memberBirthMonth = response.memberBirthMonth;
			var memberBirthDay = response.memberBirthDay;
			var memberRegion = response.memberRegion;
			var memberDistrict = response.memberDistrict;
			var memberDetail = response.memberDetail;

			// 將數據顯示在前端頁面的相應元素中
			$('#name2').text(memberName);
			$('#email2').text(memberMail);
			$('#phonenumber2').text(memberPhoneNumber);
			$('#year').text(memberBirthYear);
			$('#month').text(memberBirthMonth);
			$('#day').text(memberBirthDay);
			$('#region').text(memberRegion);
			$('#district').text(memberDistrict);
			$('#address3').text(memberDetail);
		},
		error: function() {
			// 處理請求錯誤
			console.log('請求錯誤');
		}
	});
});
