// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

// if no token is present, redirect to the login page
if (token) {
   window.location.href = "/index.html";
}

document.getElementById("submitButton").addEventListener("click", login);

let apiUrl = "http://localhost:8080";

function login(){
    // resetting error div
    document.getElementById("error-div").innerHTML = "";
    
    //retrieving user credentials
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();
    
    xhr.open("POST", `${apiUrl}/auth`);

    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let authToken = xhr.getResponseHeader("Authorization");

            /*
             storing authtoken in the session storage to be retrieved in different views
                - an item of key "token" and value authToken (Authorization token passed back from Javalin) is stored in the sessionStorage
             */
            sessionStorage.setItem("token", authToken);

            // navigate to a different view (ie: homepage)
            window.location.href="/index.html";

        } else if (xhr.readyState === 4){
            // provide user with feedback of failure to login
            document.getElementById("error-div").innerHTML = "Unable to login.";
        }
    } 

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    let requestBody = `username=${username}&password=${password}`;

    xhr.send(requestBody);
}

