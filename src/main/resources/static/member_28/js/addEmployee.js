// 登入頁面驗證
rel = "stylesheet"
href = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css"
src = "https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"

// 登入頁面驗證
var department = document.getElementById("department");
var name1 = document.getElementById("name1");
var mail = document.getElementById("mail");
var password = document.getElementById("password");
var submit1 = document.getElementById("submit1");

var departmentError = document.getElementById("department-error");
var nameError = document.getElementById("name-error");
var mailError = document.getElementById("mail-error");
var passwordError = document.getElementById("password-error");

submit1.addEventListener("click", function(event) {
    event.preventDefault(); // 阻止表单提交的默認行為

    if (validateLoginForm()) {
        document.getElementById("form").submit(); // 如果驗證通過，提交表單
    }

    function validateLoginForm() {
        var departmentValue = department.value.trim();
        var nameValue = name1.value.trim();
        var mailValue = mail.value.trim();
        var passwordValue = password.value.trim();

        // 驗證部門選擇
        if (departmentValue === "") {
            departmentError.innerHTML = "請選擇員工部門。";
            Swal.fire({
                text: "請選擇員工部門",
                icon: "error",
                confirmButtonText: "确定",
            });
            return false;
        } else {
            departmentError.innerHTML = "";
        }

        // 驗證姓名
        if (nameValue.length < 2) {
            name1.value = "";
            nameError.innerHTML = "請輸入姓名。";
            Swal.fire({
                text: "請輸入姓名",
                icon: "error",
                confirmButtonText: "确定",
            });
            return false;
        } else {
            nameError.innerHTML = "";
        }

        // 驗證邮箱
        if (mailValue.length < 6) {
            mailError.innerHTML = "請輸入電子信箱。";
            Swal.fire({
                text: "請輸入電子信箱",
                icon: "error",
                confirmButtonText: "確定",
            });
            return false;
        } else if (!mailValue.match(/^\w{1,20}@gmgc.com$/)) {
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

        // 驗證密码
        if (passwordValue.length < 6 || passwordValue.length > 10) {
            passwordError.innerHTML = "密碼長度必須介於 6 到 10 個字符之間。";
            Swal.fire({
                text: "密碼長度必須介於 6 到 10 個字符之間",
                icon: "error",
                confirmButtonText: "確定",
            });
            return false;
        } else {
            passwordError.innerHTML = "";
        }

        // 表單驗證通過
        return true;
    }
});
