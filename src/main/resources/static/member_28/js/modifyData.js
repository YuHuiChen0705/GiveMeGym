rel = "stylesheet"
href = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css"
src = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"

$(document).ready(function() {
  $('#login-form').submit(function(event) {
    event.preventDefault(); // 防止表單提交
    
    if (confirm("請確認是否修改資料？")) {
      var memberId = $('#memberId').text();
      console.log("memberId:" + memberId);
      var memberName = $('#memberName').val();
      console.log("memberName:" + memberName);
      var memberMail = $('#memberMail').val();
      console.log("memberMail:" + memberMail);
      var memberPhoneNumber = $('#memberPhoneNumber').val();
      console.log("memberPhoneNumber:" + memberPhoneNumber);
      var memberBirthYear = $('#memberBirthYear').val();
      console.log("memberBirthYear:" + memberBirthYear);
      var memberBirthMonth = $('#memberBirthMonth').val();
      console.log("memberBirthMonth:" + memberBirthMonth);
      var memberBirthDay = $('#memberBirthDay').val();
      console.log("memberBirthDay:" + memberBirthDay);
      var memberRegion = $('#memberRegion').val();
      console.log("memberRegion:" + memberRegion);
      var memberDistrict = $('#memberDistrict').val();
      console.log("memberDistrict:" + memberDistrict);
      var memberDetail = $('#memberDetail').val();
      console.log("memberDetail:" + memberDetail);

      // 發送AJAX請求
      $.ajax({
        url: '/front_Member/memberDataModify/summit',
        headers: { "Content-Type": "application/json;charset=UTF-8" },
        type: 'PUT',
        dataType: 'json',
        data: JSON.stringify({
          memberId: memberId,
          memberName: memberName,
          memberMail: memberMail,
          memberPhoneNumber: memberPhoneNumber,
          memberBirthYear: memberBirthYear,
          memberBirthMonth: memberBirthMonth,
          memberBirthDay: memberBirthDay,
          memberRegion: memberRegion,
          memberDistrict: memberDistrict,
          memberDetail: memberDetail
        }),
        success: function(response) {
          // 根據伺服器的回應進行處理
          console.log('請求正確');
          alert("不錯嘛~資料修改成功了");
          // Swal.fire({
          //   text: "你很牛逼麻，資料居然給你新增成功了XDD",
          //   icon: "success",
          //   confirmButtonText: "確定",
          // });
          // 登入成功，執行相應的操作
          window.location.href = '/front_Member/memberData';
        },
        error: function() {
          // 處理請求錯誤
          alert("請確認您的個仁資料是否正確!")
          // Swal.fire({
          //   text: "你新增個雞毛資料啊!",
          //   icon: "error",
          //   confirmButtonText: "確定",
          // });
          console.log('請求錯誤');
        }
      });
    } else {
      // 使用者點選了取消按鈕，不執行任何操作
    }
  });
});
