/*

let v1 = {n1: "v1", n2: "v2"};
let v1json = JSON.stringify(v1);
console.log("v1json = " + v1json);

let v2json2 = '{"a1": "b1", "a2": "b2"}';
let v2 = JSON.parse(v2json2);

console.log("v2 = " + v2);



let ttt = {
    board: [
        "",
        "XXX",
        "OOX",
        "OXO"
    ],
        gameOver: true,
    winner: "X"
};


console.log("ttt.board = " + ttt.board);
console.log("ttt.gameOver = " + ttt.gameOver);
console.log("ttt.winner = " + ttt.winner);


console.log("ttt.board[2] = " + ttt.board[2]);
console.log("ttt.board[2].charAt() = " + ttt.board[2].charAt());
console.log("ttt.board[2][1] = " + ttt.board[2][1]);

let string = ["123","456"];
console.log("string[3] = " + string[1][1]);




let stringList = "1,1\n1,2\n";

function f1(x,z) {
    let string = "" + x + "," + z;
    console.log("string = " + string);

    console.log("stringList.includes(string) = " + stringList.includes(string));
    
}


f1(1, 2);

 */

x=1;
z=2;
let moveString = x + "," + z;

console.log("moveString = " + moveString);
