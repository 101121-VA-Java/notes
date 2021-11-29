console.log('Hello from ts-demo!');

// implicitely assigns myVar to a type string
let myVar = 'myVar';

// can't reassign a string to a boolean
// myVar = true;

// explicitely declare a type using : type
let myNum: number =5;

enum colors{
    BLUE, GREEN, PURPLE
}

let myEnum:colors = colors.GREEN;

console.log(myEnum);

interface myInterface{
    myVar: string;
}

class myClass implements myInterface{
    myVar: string;
    private _myNum:number;

    constructor(someNum: number){
        this._myNum = someNum;
    }

    get myNum(){
        return this._myNum;
    }
}