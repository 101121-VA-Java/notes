// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

// if no token is present, redirect to the login page
if (!token) {
   window.location.href = "views/login.html";
}

// targets logout button
document.getElementById('logout-button').addEventListener('click', logout);

function logout(){
   sessionStorage.clear();
   window.location.href = "views/login.html";
}
