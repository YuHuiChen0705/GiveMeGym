const cartTotalElement = document.getElementById('cart-total');
function getShopCart() {
    $.ajax({
        url: '/shopCartByMember',
        type: 'GET',
        success: function (response) {
            // 在此從後端取得處理成功回應的購物車資料  List<DetailDTO> list
            console.log(response);
            if (response != null) {
                // 迭代取出物件  變成
                const tableBody = document.getElementById("tableBody");
                let html = "";

                response.forEach(item => {
                    html += `<tr>
                                    <td>${item.productId}</td>
                                    <td>${item.productName}</td>
                                    <td>${item.quantity}</td>
                                    <td>${item.price}</td>
                                    <td class="item-total">$${item.quantity * item.price}</td>
                                  </tr>`;
                });

                tableBody.innerHTML = html;

                updateCartTotal();
            } else {
                alert("尚未登入會員，請登入");
                window.location.href = '/front_Member/login';
            }
        }
        ,
        error: function (xhr, status, error) {
            // 在此處理錯誤
            console.error(error);
        }
    });
}

getShopCart();



$('.submit_order').on('click', function() {
    if(confirm("確認下單?")){

        const cartTotalElement = document.getElementById('cart-total');
        var totalPrice = parseInt(cartTotalElement.textContent.replace('$', ''), 10);
        var name = $('#name').val();
        var phone = $('#phone').val();
        var address = $('#address').val();
        var note = $('#note').val();
    // 獲取要發送的數據
    var data = {
        totalPrice:totalPrice,
        name:name,
        phone:phone,
        address:address,
        note:note
    };


    console.log(data);
    // 發送AJAX請求
    $.ajax({
        url: '/checkoutOrder',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(response) {
            // 請求成功，可以在這裡處理後續操作或顯示成功訊息
            console.log(response);
            window.location.href = '/shopAllProduct';
        },
        error: function(xhr, status, error) {
            // 請求失敗，可以在這裡處理錯誤或顯示錯誤訊息
            console.error('請求失敗。狀態碼：' + xhr.status);
        }
    });
    }
});

function updateCartTotal() {
    const itemTotalElements = document.querySelectorAll('.item-total');
    let cartTotal = 0;
    itemTotalElements.forEach((itemTotalElement) => {
        const itemTotal = parseFloat(itemTotalElement.textContent.replace('$', ''));
        cartTotal += itemTotal;
        console.log(itemTotal);
        console.log(cartTotal);
    });
    cartTotalElement.textContent = '$' + cartTotal;
}

