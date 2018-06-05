
(function(){
    const myRequest = new Request('http://localhost:8080/rest');
    const body = document.querySelector('body');
    let myArr =[];
    const myURL = myRequest.url; 
    // fetch(myRequest)
    // .then(response => {
    //   if (response.status === 200) {
    //     return response.blob();
    //   } else {
    //     throw new Error('Something went wrong on api server!');
    //   }
    // })
    var myList = document.createElement('ul');



fetch(myRequest)
  .then(function(response) { return response.json(); })
  .then(function(data) {
    for (var i = 0; i < data.length; i++) {
      var listItem = document.createElement('li');
      listItem.innerHTML = '<strong>' + data[i].title + '</strong> can be found in ' +
                           data[i].author +
                           '. Cost: <strong>£' + data[i].pages + '</strong>';
      myList.appendChild(listItem);
    }
    body.appendChild(myList)
  });
    
    // .then(response => {
    //   console.log(response);
    //   // ...
    //   myArr = response;
    //   for(let i = 0; i < myArr.length; i++){
    //       let paragraph = document.createElement('p')
    //       paragraph.innerHTML = myArr[i].title;
    //       body.appendChild(paragraph)
    //       console.log(myArr[i].title)
    //   }
    // }).catch(error => {
    //   console.log(error);
    // });
})()
