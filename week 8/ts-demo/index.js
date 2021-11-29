console.log('Hello from ts-demo!');
// implicitely assigns myVar to a type string
let myVar = 'myVar';
// can't reassign a string to a boolean
// myVar = true;
// explicitely declare a type using : type
let myNum = 5;
var colors;
(function (colors) {
    colors[colors["BLUE"] = 0] = "BLUE";
    colors[colors["GREEN"] = 1] = "GREEN";
    colors[colors["PURPLE"] = 2] = "PURPLE";
})(colors || (colors = {}));
let myEnum = colors.GREEN;
console.log(myEnum);
class myClass {
    constructor(someNum) {
        this._myNum = someNum;
    }
    get myNum() {
        return this._myNum;
    }
}
