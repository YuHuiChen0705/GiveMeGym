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
                                    <td><input type="number" min="1" max="5" value="${item.quantity}"></td>
                                    <td>${item.price}</td>
                                    <td class="item-total">$${item.quantity * item.price}</td>
                                    <td><button class="remove-button" data-product-id="${item.productId}">移除</button></td>
                                  </tr>`;
                });

                tableBody.innerHTML = html;

                eventButton();
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

function eventButton() {
    // 取得元素
    const removeButtons = document.querySelectorAll('.remove-button');
    const quantityInputs = document.querySelectorAll('.cart-container tbody tr input[type="number"]');
    const cartTotalElement = document.getElementById('cart-total');

    // 移除商品
    function removeItem(event) {
        if(confirm("確定移除商品?")){
            const currentItem = event.target.closest('tr');
            currentItem.remove();
            console.log("remove")
            updateCartTotal();
            console.log("update total price")

            const productId = $(this).data('product-id');
            console.log(productId);
            removeRedisCart(productId);
        }
    }

    // 更新單項商品總價
    function updateItemTotal(itemRow) {
        const quantityInput = itemRow.querySelector('input[type="number"]');
        const itemTotalElement = itemRow.querySelector('.item-total');
        const itemPriceElement = itemRow.querySelector('td:nth-child(4)');
        const quantity = parseInt(quantityInput.value);
        console.log(quantity);
        const itemPrice = parseInt(itemPriceElement.textContent);
        console.log(itemPrice);
        const itemTotal = quantity * itemPrice;
        itemTotalElement.textContent = '$' + itemTotal;
    }

    // 更新購物車總價
    function updateCartTotal() {
        const itemTotalElements = document.querySelectorAll('.item-total');
        let cartTotal = 0;
        itemTotalElements.forEach((itemTotalElement) => {
            const itemTotal = parseFloat(itemTotalElement.textContent.replace('$', ''));
            cartTotal += itemTotal;
        });
        cartTotalElement.textContent = '$' + cartTotal;
    }

    // 監聽移除按鈕點擊事件
    removeButtons.forEach((removeButton) => {
        removeButton.addEventListener('click', removeItem);
    });

    // 監聽數量輸入框變更事件
    quantityInputs.forEach((quantityInput) => {
        quantityInput.addEventListener('input', () => {
            const itemRow = quantityInput.closest('tr');
            updateItemTotal(itemRow);
            updateCartTotal();

            const productId = itemRow.querySelector('td:nth-child(1)').textContent;
            const quantity = parseInt(quantityInput.value);
            updateRedisCart(productId, quantity);
        });
    });

    // 初始化購物車總價
    updateCartTotal();

    function updateRedisCart(productId, quantity) {
        const cartItem = {
            productId: productId,
            quantity: quantity,
        };

        $.ajax({
            url: '/upDateCart',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(cartItem),
            success: function (response) {
                console.log(response);
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    }

    function removeRedisCart(productId) {
        console.log("call ajax");
        $.ajax({
            url: '/removeOneCartItem',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({productId: productId}),
            success: function (response) {
                console.log(response);
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    }


}
const checkoutButton = document.querySelector('.checkout-button');
// 監聽確認下單按鈕點擊事件
checkoutButton.addEventListener('click', () => {
    if (confirm("確認結帳?")) {
        window.location.href= "/CartToCheckout";
    }
});