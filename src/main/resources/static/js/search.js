var search_input=document.querySelector("#search");

search_input.addEventListener('keyup', function (e){

  // console.log(e.target.value)  ;
  var search_item=e.target.value.toLowerCase();

  var td_items=document.querySelectorAll('#items-table > tr > td:nth-child(1)');

  //
  // td_items.forEach(function (item){
  //
  //     if(item.textContent.toLowerCase().indexOf(search_item)==-1){
  //         item.closest("tr").style.display='none';
  //     }
  //     else{
  //         item.closest("tr").style.display='';
  //     }
  //
  //
  //
  //   });
// console.log(td_items);

    var row=document.querySelectorAll('#items-table > tr');


    for(let i=1;i<row.length;i++){

        let cell=row[i].querySelector('td');

        console.log(cell);

        if(cell.innerText.toLowerCase()===search_item){
            row[i].closest("tr").style.display='';
        }
        else{
            row[i].closest("tr").style.display='none';
        }

    }



});

