console.log("KOKOOK")
const URLS = {
    tracks: '/api/track',

};

let timestamp = new Date().getTime();
const toString = ({barcode,destination,location,recipientName,updateDate}) => {
    let columns = `
    <td >${barcode}</td>
    <td>${destination}</td>
    <td>${location}</td>
    <td>${recipientName}</td>
    <td>${updateDate}</td>`

    //     columns += status
    //         ? '<td> </td>'
    //         :
    // //     `
    //     <td>
    //     <form class="buy-item-form" action="/orders/details/${barcode}" method="post">
    //         <button class="btn btn-info">Forward</button>
    //     </form>
    // </td>`

    // if(location!==destination){
    //     columns+=  `
    //     <td>
    //
    // </td>`}
    // else{
        columns+=

            ` <td>
<!--            <form class="buy-item-form" action="/orders/delete/${barcode}" method="post">-->
<!--             <a href="/orders/delete/${barcode}"> ${updateDate}</a>-->
<!--                <button class="btn btn-info">Arrived</button>-->
<!--            </form>-->
        </td>`
    // }




    return `<tr style="display: none;">${columns}</tr>`
}


// loader.show();



fetch(URLS.tracks)
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




