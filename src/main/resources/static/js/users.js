console.log("KOKOOK")
const URLS = {
    users: '/api/users',

};


const toString = ({username,firstName,lastName,officeName,authorities[0]}) => {
    let columns = `
    <td ></td>
     <td>${username}</td>
    <td>${firstName}</td>
    <td>${lastName}</td>
    <td>${officeName}</td>
    <td>${authorities}</td>`


    //     columns += status
    //         ? '<td> </td>'
    //         :
    // //     `
    //     <td>
    //     <form class="buy-item-form" action="/orders/details/${barcode}" method="post">
    //         <button class="btn btn-info">Forward</button>
    //     </form>
    // </td>`

    if(username){
        columns+=  `
        <td>
${status}
    </td>`}
    else{
        columns+=

            ` <td>
<!--            <form class="buy-item-form" action="/orders/delete/${barcode}" method="post">-->
             <a href="/orders/delete/${barcode}"> ${updateDate}</a>
<!--                <button class="btn btn-info">Arrived</button>-->
<!--            </form>-->
        </td>`
    }




    return `<tr class="col">${columns}</tr>`
}


// loader.show();



fetch(URLS.users)
    .then(response => response.json())
    .then(items => {
        let result = '';
        items.forEach(item => {

            console.log(item);
            const itemString = toString(item);
            result += itemString;

        });
        // document.getElementById('items-table').innerHTML=result;




        $('#items-table').html(result);
        // loader.hide();
    });










