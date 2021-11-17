console.log('Hello World!');

/*
    - Retrieve all employees
        - HTTP Request
            - version
            - header
            - body
            - url
                - http://localhost:8080/employees
            - Http method
                - GET
*/
getEmployees();
registerEmployee();
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


/*
    - Retrieve all employees
        - HTTP Request
            - version
            - header
            - body
                - JSON object with name, uname, pass
            - url
                - http://localhost:8080/employees
            - Http method
                - POST
*/
function registerEmployee(){
    // Retrieve employee info using DOM manipulation, here we're just using dummy values
    // name, username, password
    let newEmployee = {
        name: 'Kevin1', 
        username: 'kev1', 
        password: 'kevpass1'
    };

    // create XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    // Setting callback function
    xhr.onreadystatechange = function() {
        // check that request was successful
        if( xhr.readyState === 4){
            if(xhr.status === 201){
                console.log('Employee was successfully added!');
            } else{
                console.log('Employee was not added...');
                /*
                    provide user with notification that action was unable to be completed, ie:
                    document.getElementById("errorDiv").innerHtml = 'invalid info';
                */
            }
        }
    }

    // Parameterize/Open request object
    xhr.open("POST", "http://localhost:8080/employees");
    
    // Convert JS object to JSON object
    let requestBody = JSON.stringify(newEmployee);
    // send
    xhr.send(requestBody);
}