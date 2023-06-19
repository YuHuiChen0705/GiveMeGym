// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  // 表單無效
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
        else {
          // 表單驗證通過
          // 阻止表單提交
          event.preventDefault(); 

          Swal.fire({
            title: 'Success!',
            text: 'Your form has been submitted successfully.',
            icon: 'success',
            confirmButtonText: 'OK'
          })
            .then(function () {
              // 按下確認按鈕後回到首頁
              window.location.href = 'index.html'; 
            });

        }

        form.classList.add('was-validated')
      }, false);
    })
})();






