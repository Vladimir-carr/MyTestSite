let List = [];
$('.add_cart').on('click', function(){
    let Products = {}
    Products.id = $(this).attr('data-id');
    Products.name = $(this).attr('data-name');
    Products.price = $(this).attr('data-price');
    Products.image = $(this).attr('data-image');
    Products.count = 1;

    let copy = false;
    List.forEach((elem) => {
        if(elem.id == Products.id)
        {
            elem.count++;
            copy = true;
        }

    })

    if(!copy)
        List.push(Products);

    localStorage.setItem('cart', JSON.stringify(List));
    console.log(List);

    render();

});

getStorage();

function getStorage()
{
    let Data = localStorage.getItem('cart');
    if(Data != null)
        List = JSON.parse(Data);

    render();
}

function render()
{
    $('#body-cart').empty();
    if(List.length > 0)
    {
        List.forEach((elem, index) => {
            $('#body-cart').append(`
                            <tr>
                                <th scope="row">
                                    <img style="width: 100px; height: 100px;" src="images/${elem.image}" alt="" class="img-fluid z-depth-0">
                                </th>
                                <td>
                                    <h5 class="mt-3">
                                        <strong>${elem.name}</strong>
                                    </h5>
                                </td>
                                <td></td>
                                <td>$ ${elem.price}</td>
                                <td class="text-center text-md-left">
                                    <div id="qty-group" class="btn-group radio-group ml-2" data-toggle="buttons">
                                        <label class="btn btn-sm btn-primary btn-rounded">
                                            <input type="radio" name="options" id="option1" class="minus" value="${index}">-
                                        </label>
                                        <span class="qty">${elem.count}</span>
                                        <label class="btn btn-sm btn-primary btn-rounded">
                                            <input type="radio" name="options" id="option2" class="plus" value="${index}">+
                                        </label>
                                    </div>
                                </td>
                                <td class="font-weight-bold">
                                    <strong>$ ${elem.price * elem.count}</strong>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-sm btn-primary remove_btn" data-toggle="tooltip"
                                            data-placement="top" value="${index}"
                                            title="Remove item">X
                                    </button>
                                </td>
                            </tr>
                            
                            `);
        });

        $('.plus').on('click', function () {
            List[$(this).val()].count++;
            localStorage.setItem('cart', JSON.stringify(List));
            render();
        })

        $('.minus').on('click', function () {
            if (List[$(this).val()].count > 1) {
                List[$(this).val()].count--;
            }
            else {
                List.splice($(this).val(), 1);
            }
            localStorage.setItem('cart', JSON.stringify(List));
            render();
        })

        $('.remove_btn').on('click', function(){
           List.splice($(this).val(), 1);
           localStorage.setItem('cart', JSON.stringify(List));
           render();
        })

    }
    else
    {
        $('#body-cart').html(`<h1>Cart is empty</h1>`);
    }

    amount();

}

function amount() {
    let amount = 0;
    List.forEach((elem) => {
        let price = elem.count * elem.price;
        amount += price;
    });

    if (List.length > 0) {
            $('#body-amount').html(
                `<td colspan="3"></td>
                    <td>
                        <h4 class="mt-2">
                        <strong>Total</strong>
                        </h4>
                    </td>
                    <td class="text-right">
                        <h4 class="mt-2">
                        <strong>$ ${amount}</strong>
                        </h4>
                    </td>
                    <td colspan="3" class="text-right">
                        <button type="button" class="btn btn-primary btn-rounded px-4">Complete purchase
                        <i class="fas fa-angle-right right"></i>
                        </button>
                    </td>
                 `
            );
    }
    else
    {
        $('#body-amount').html('');
    }
}