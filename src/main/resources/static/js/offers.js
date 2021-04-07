console.log("KOKOOK")
const URLS = {
    offers: '/api/all',

};
const toString = ({id,barcode,destination,sendNumber,receiveNumber,location,recipientName}) => {
    let columns = `
    <td>${barcode}</td>
    <td>${destination}</td>
    <td>${sendNumber}</td>
    <td>${receiveNumber}</td>
    <td>${location}</td>
    <td>${recipientName}</td>`

    //     columns += status
    //         ? '<td> </td>'
    //         :
    // //     `
    //     <td>
    //     <form class="buy-item-form" action="/orders/details/${barcode}" method="post">
    //         <button class="btn btn-info">Forward</button>
    //     </form>
    // </td>`

    if(location!==destination){
        columns+=  `
        <td>
<!--        <form class="buy-item-form" action="/orders/details/${barcode}" method="post">-->
        <a href="/orders/update/${barcode}"> Forward</a>
<!--            <button class="btn btn-info">Forward</button>-->
<!--        </form>-->
    </td>`}
    else{
        columns+=

            ` <td>
<!--            <form class="buy-item-form" action="/orders/delete/${barcode}" method="post">-->
             <a href="/orders/delete/${barcode}"> Delete</a>
<!--                <button class="btn btn-info">Arrived</button>-->
<!--            </form>-->
        </td>`
    }




    return `<tr>${columns}</tr>`
}

// loader.show();
fetch(URLS.offers)
    .then(response => response.json())
    .then(items => {
        let result = '';
        items.forEach(item => {
            const itemString = toString(item);
            result += itemString;

        });
        // document.getElementById('items-table').innerHTML=result;
        $('#items-table').html(result);
        // loader.hide();

    });
$('#items-table').on('submit', '.buy-item-form', function (e) {

    const url = $(this).attr('action');
    // loader.show();
    fetch(url, {method: 'post',})

        // .then(resp=>resp.json())
        .then(data => {
            // loader.hide();
            console.log(data)

        });
    // loader.hide();

    e.preventDefault();

    console.log(this);

    return false;

});
