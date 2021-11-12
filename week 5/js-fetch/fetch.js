// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let apiUrl = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {

  let userInput = document.getElementById('dataInput').value;

  let response = await fetch(`${apiUrl}/${userInput}`);

  if(response.status >= 200 && response.status < 300){
      let data = await response.json();

      populateData(data);
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