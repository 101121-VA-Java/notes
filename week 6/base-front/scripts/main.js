// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

let nav_right = document.getElementById("nav-right");


// if no token is present, redirect to the login page
if (token) {
   let tokenArr = token.split(':');
   let id = tokenArr[0];
   let role = tokenArr[1];

   let nav_right = document.getElementById("nav-right");
   let li = document.createElement('li');
   li.setAttribute('class', 'nav-item');
   let a = document.createElement('a');
   a.setAttribute('class', 'nav-link');
   a.setAttribute('href', '#');
   a.innerHTML = 'Logout';

   a.addEventListener('click', logout);

   li.appendChild(a);
   nav_right.appendChild(li);

   console.log(tokenArr);
} else {
   // let nav_right = document.getElementById("nav-right");
   // let li = document.createElement('li');
   // li.setAttribute('class', 'nav-item');
   // let a = document.createElement('a');
   // a.setAttribute('class', 'nav-link');
   // a.setAttribute('href', 'views/login.html');
   // a.innerHTML = 'Login';

   // li.appendChild(a);
   createNavElement('Login', nav_right, 'views/login.html', null);
   nav_right.appendChild(li);
}

function logout() {
   sessionStorage.clear();
   location.reload();
}

function createNavElement(innerHTML, parentElement, link, callback) {
   let li = document.createElement('li');
   li.setAttribute('class', 'nav-item');
   let a = document.createElement('a');
   a.setAttribute('class', 'nav-link');

   if (link) {
      a.setAttribute('href', link);
   } else {
      a.setAttribute('href', '#');
   }

   if(callback){
      a.addEventListener('click', callback);
   }
   
   a.innerHTML = innerHTML;

   li.appendChild(a);

   parentElement.appendChild(li);
}