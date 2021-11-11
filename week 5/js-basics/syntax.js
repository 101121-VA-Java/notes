// Line Comments

/*
    Block Comments
    add
    lines
    here
*/

//"use strict"; // See line 83.

helloLog();

/* Functions */
function helloLog() {
    console.log('Hello from helloLog!');
}

function logMessage(message) {
    console.log(message);
}

var globalVar = 'Hello World!';
globalVar = false;
console.log(globalVar);
// hoisting only happens with var declared variables
// console.log(letVar);

helloLog();
logMessage('Hello from the logMessage argument!');
logMessage(1234567890);
logMessage(20 / 5);
logMessage(8 == '8'); // True (type coercion)
logMessage(8 === '8'); // False
logMessage(null);
var m; // Undefined
logMessage(m);

// truthy/falsy values
if ('false') {
    console.log('This is true');
} else {
    console.log('This is false')
}

function logMessageFromInput() {
    /* JavaScript is dynamically-typed. */
    var message = 5;
    message = true;
    message = document.getElementById('messageInput').value;
    console.log(message);
}

var myFunc = function (x, y) {
    return x + y;
};

console.log('this is my func ' + myFunc(1, 3));

var logBtn = document.getElementById('logBtn');
/* Two different ways of adding an event listener */
logBtn.addEventListener('click', logMessageFromInput);
// logBtn.onclick = logMessageFromInput;

/* Objects and Arrays */
var obj = {
    'id': 1,
    'name': 'Revature',
    'favoriteColor': 'orange',
    'isObject': true
};
var arr = [1, 'Revature', 'orange', true];
// Be familiar with some of the array functions
arr.indexOf(1);

console.log(obj);
console.log(arr);
console.log(typeof obj + ', ' + typeof arr);
console.log('Type of NaN:' + typeof NaN);

var obj2 = {
    'firstName': 'Hello',
    'lastName': 'World',
    'fullName': function () {
        console.log(this.firstName + ' ' + this.lastName);
    }
}

obj2.fullName();
obj2.firstName = 'Goodbye';
obj2.fullName();

/* Scopes */
/*
    declaration:
        var globalVar
    assignment
        globalVar = 'something';
*/
var globalVar = 'I\'m a global-scope variable.';
var globalVar = 'Something else'; // fine
function myFunction() {
    var functionVar = 'I\'m a function-scope variable.'

    /* ES6+ added block scope. */
    if (true) {
        let blockVar = 'I\'m a block-scope variable.';
        // let blockVar = 'Something new'; // cannot redeclared let
        blockVar = 'reassigned!';
        const blockConst = 'I\'m also a block-scope variable.';
        // blockConst = 'something else'; // throws an error
    }

    funcitonVar = ''; // will throw an error in strict mode

    console.log(functionVar);
    //var functionVar = 'I\'m a function-scope variable.'
}
//console.log('outside of scope' + functionVar); // cannot be accessed outside of function
/* Immediately Invoked Function Expression */
(function () { console.log('Hello from the IIFE') })();
var returnVal = (function () { return 'IIFE result' })();
console.log(returnVal);

let letVar = 0;

x = "Hello"; // If "use strict" is used at the top of the file, this will throw an error in the console.
myFunction(); // will throw an error in strict mode (line 79)