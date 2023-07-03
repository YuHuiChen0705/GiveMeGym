function getShopCart() {
    $.ajax({
        url: '/shopCartByMember',
        type: 'GET',
        success: function (response) {
            // 在此從後端取得處理成功回應的購物車資料  List<DetailDTO> list
            console.log(response);
            const tableBody = document.getElementById("tableBody");
            let html = "";
            if (response && response.length > 0) {
                // 迭代取出物件  變成
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
                html += `<tr><td colspan="6">尚無商品，快去購物吧</td></tr>`;
                tableBody.innerHTML = html;
            }
        }
        ,
        error: function (xhr, status, error) {
            if (xhr.status === 404) {
                // 處理 404 錯誤，表示找不到資源
                console.error("找不到資源");
            } else if (xhr.status === 400) {
                // 處理 400 錯誤，表示未登入會員
                alert("尚未登入會員，請登入");
                window.location.href = '/front_Member/login';
            } else {
                // 處理其他錯誤
                console.error(error);
            }
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
        if (confirm("確定移除商品?")) {
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


    const cleanUpButton = document.querySelector('#cleanShopCart');
    cleanUpButton.addEventListener("click", cleanShopCart);

    function cleanShopCart() {
        if (confirm("要清空購物車嗎?")) {
            console.log("準備呼叫AJAX")
            $.ajax({
                url: '/cleanShopCart',
                type: 'GET',
                success: function (response) {
                    console.log("呼叫AJAX成功")
                    window.location.href = response;
                },
                error: function (xhr, status, error) {
                    console.error(error);
                }
            });
        }
    }
}

const checkoutButton = document.querySelector('#checkout-button');
// 監聽確認下單按鈕點擊事件
checkoutButton.addEventListener('click', () => {
    if (confirm("確認結帳?")) {
        window.location.href = "/CartToCheckout";
    }
});