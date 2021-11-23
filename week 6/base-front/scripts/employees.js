let apiUrl = 'http://localhost:8080/employees';

if (!token || token.split(':')[1] === 'BASIC_EMPLOYEE') {
    window.location.href = '/index.html';
} else {
    document.getElementById('option1').addEventListener('click', getAll);
    document.getElementById('option2').addEventListener('click', getByManId);
    
    populateTable();
}

function getAll() {
    apiUrl = 'http://localhost:8080/employees';
    populateTable();
}

function getByManId() {
    apiUrl = 'http://localhost:8080/employees?manager-id=' + token.split(':')[0];
    populateTable();
}

async function populateTable() {
    let response = await fetch(apiUrl, {
        headers: {
            'Authorization': token
        }
    });

    let employees = await response.json();

    let tableBody = document.getElementById('employee-tbody');

    tableBody.innerHTML = '';

    for (employee of employees) {
        let row = document.createElement('tr');

        if (token.split(':')[1] === 'ADMIN') {
            row.setAttribute('data-toggle', 'modal');
            row.setAttribute('data-target', '#updateEmployeeModal');
            row.addEventListener('click', setupModal);
            
        }

        let idTd = document.createElement('td');
        idTd.innerHTML = employee.id;

        let nameTd = document.createElement('td');
        nameTd.innerHTML = employee.name;

        let usernameTd = document.createElement('td');
        usernameTd.innerHTML = employee.username;

        let roleTd = document.createElement('td');
        roleTd.innerHTML = employee.role;

        let manIdTd = document.createElement('td');
        manIdTd.innerHTML = employee.manager.id;

        row.appendChild(idTd);
        row.appendChild(nameTd);
        row.appendChild(usernameTd);
        row.appendChild(roleTd);
        row.appendChild(manIdTd);

        tableBody.appendChild(row);
    }

    document.getElementById('update-button').addEventListener('click', updateEmployee);
}

async function setupModal(event) {
    let row = event.target.parentNode;
    let tds = row.childNodes;

    document.getElementById('modal-employee-name').innerHTML = tds[1].innerHTML;
    document.getElementById('modal-employee-id').innerHTML = tds[0].innerHTML;

    let managerDropdown = document.getElementById('employee-manager');

    managerDropdown.innerHTML = '';

    let response = await fetch('http://localhost:8080/employees/managers', {
        headers: {
            'Authorization': token
        }
    });

    let managers = await response.json();

    for(manager of managers){
        let option = document.createElement('option');
        option.setAttribute('value', manager.id);
        option.innerHTML = manager.name;

        managerDropdown.appendChild(option);
    }
}

async function updateEmployee(){
    let empManager = document.getElementById('employee-manager').value;
    let empRole = document.getElementById('employee-role').value;
    let employeeId = document.getElementById('modal-employee-id').innerHTML;

    let updatedEmployee = {
        id : employeeId,
        role : empRole,
        manager: {
            id : empManager
        }
    }

    let response = await fetch(`http://localhost:8080/employees/${employeeId}/admin`, {
        method: 'PUT',
        headers: {
            'Authorization': token
        },
        body: JSON.stringify(updatedEmployee)
    });

    if(response.status == 200){
        window.location.reload();
    } else {
        document.getElementById('error-div').innerHTML='Unable to update employee.'
    }
    
}
