console.log('Hello World!');

/*
    - Retrieve all employees
        - HTTP Request
            - version
            - header
            - body
            - url
                - localhost:8080/employees
            - Http method
                - GET
*/
getEmployees();

function getEmployees(){
    // create XMLHttpRequest Object

    let xhr = new XMLHttpRequest();

    // Setting callback function

    xhr.onreadystatechange = function() {
        // check that request was successful
        if( xhr.readyState === 4){
            if(xhr.status >= 200 && xhr.status < 300){
                let response = xhr.response;

                response = JSON.parse(response);

                // handling behavior
                console.log(response);
            }
        }
    }

    // Parameterize/Open request object
    xhr.open("GET", "http://localhost:8080/employees");
    // send

    xhr.send();
}