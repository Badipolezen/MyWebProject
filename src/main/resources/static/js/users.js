console.log("KOKOOK")
const URLS = {
    users: '/api/users',

};
// console.log({authorities})

const toString = ({id,username,firstName,lastName,authorities}) => {
let a=authorities.length;
console.log(a);



    let columns = `
    <td>${username}</td>
    <td>${firstName}</td>
    <td>${lastName}</td>`


    if(a==2){

        columns+=

            ` 
 <td>
${authorities[1]['authority']}
    </td>`


      }
    else{
        columns+=  `
        <td id="#role">
         <form class="buy-item-form" action="/users/change/${username}" method="post">
<!--<a href="/users/change/${username}"> ${authorities[0]['authority']}</a>-->
  <button class="btn btn-info"> ${authorities[0]['authority']}</button>
            </form>
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



//







