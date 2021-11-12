// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiUrl = 'https://pokeapi.co/api/v2/pokemon';

function getData() {

    //retrieve user input for Pokemon id
    let userInput = document.getElementById('dataInput').value;

    // 1: create XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    //2: set a callback function to the readystate change event of that object
    xhr.onreadystatechange = receiveData;

    //3: parameterize / open the request object (set request information)
    xhr.open('GET', `${apiUrl}/${userInput}`);

    //4: send the request
    xhr.send();

    function receiveData() {
        // what to be done once the data is ready
        if (xhr.readyState === 4) {
            let dataSpan = document.getElementById('data');
             // Resets the innerHTML for every request
            dataSpan.innerHTML = '';
            if (xhr.status >= 200 && xhr.status < 300) {
                let response = xhr.response;

                // Converting JSON data to JS object
                response = JSON.parse(response);

                // data processing behavior
                populateData(response);
            } else{
                dataSpan.innerHTML = 
                `<img src="https://lh3.googleusercontent.com/proxy/PwTFjS3gKK23XkUpAs0ZPWDjjABchQ9pjEOdmbPJujuZbJd1t6tZYLwCG1R4vRFMoQgTXdehLcWyWY0hVWNDzC9TwnR1VgMNLNkE4QopBJhst4ZFvKVNoCLZqSom97GfoAAH3q3tBihVMw">`;
            }
        }
    }
}

function populateData(response) {
    // console.log(response);
    console.log(response.name);
    // Using DOM manipulation, display information about pokemon to the webpage

    let dataSection = document.getElementById('data');

   let nameTag = document.createElement('h3');
   nameTag.innerHTML = response.name.toUpperCase();
   
   let abilitiesArray = response.abilities;
   let abilities = document.createElement('ul');
   // Appending list elements to a ul
   // for of loops return the object itself
   for(let ability of abilitiesArray){
       let abilityLi = document.createElement('li');
       abilityLi.innerHTML = ability.ability.name;
       abilities.appendChild(abilityLi);
   }

   // Appending h3 and List to the section tag
   dataSection.appendChild(nameTag);
   dataSection.appendChild(abilities);

   // Appending sprites to section
   let spritesObject = response.sprites;
   // for in loops return a list of keys of the object iterated over
   for(let key in spritesObject){
       if(spritesObject[key] && spritesObject[key].length > 2){
           let spriteImg = document.createElement('img');
           spriteImg.src = spritesObject[key];
           dataSection.appendChild(spriteImg);
       }
   }
}