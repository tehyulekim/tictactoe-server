let board;

let var1json;
let var1;

let var2json;
let var2;

let var3json;
let var3;
let var4;
let var5;
let var6;


function drawBoard() {
    document.getElementById("x1z1").innerHTML = board[1][1];
    document.getElementById("x1z2").innerHTML = board[1][2];
    document.getElementById("x1z3").innerHTML = board[1][3];
    document.getElementById("x2z1").innerHTML = board[2][1];
    document.getElementById("x2z2").innerHTML = board[2][2];
    document.getElementById("x2z3").innerHTML = board[2][3];
    document.getElementById("x3z1").innerHTML = board[3][1];
    document.getElementById("x3z2").innerHTML = board[3][2];
    document.getElementById("x3z3").innerHTML = board[3][3];
}


document.getElementById("x1z1").addEventListener("click", function () {
    console.log("x1z1 text");
});
document.getElementById("x1z2").addEventListener("click", function () {
});
document.getElementById("x1z3").addEventListener("click", function () {
});
document.getElementById("x2z1").addEventListener("click", function () {
});
document.getElementById("x2z2").addEventListener("click", function () {
});
document.getElementById("x2z3").addEventListener("click", function () {
});
document.getElementById("x3z1").addEventListener("click", function () {
});
document.getElementById("x3z2").addEventListener("click", function () {
});
document.getElementById("x3z3").addEventListener("click", function () {
});


function setMarkPlayer(x, z) {
    // AJAXGET("/ttt/move/" + x + z, )
    // send move then get board, and display board.
}


function ajaxget1() {
    AJAXGET("/2", function (xmlHttpRequest) {
        var2json = xmlHttpRequest.responseText;
        var2 = JSON.parse(var2json);
        document.getElementById("id2").innerHTML = var2json;
    });
}

function ajaxgetjson1() {
    AJAXGETJSON("/3", function (jsonData) {
        board = jsonData.board;
        document.getElementById("id2j").innerHTML = board;
        drawBoard();
    })
}

function ajaxpost1() {
    AJAXPOST("/ttt/istart", "contentdata1", function (xmlHttpRequest) {
        var3json = xmlHttpRequest.responseText;
        var3 = JSON.parse(var3json);
        document.getElementById("id3").innerHTML = var3json;

    });
}

function ajaxpost4() {
    AJAXPOST("/ttt/4", '{"contentdata4"="value4"}', function (xmlHttpRequest) {
        var4 = xmlHttpRequest.responseText;
        console.log(xmlHttpRequest.responseText);
        document.getElementById("id4").innerHTML = xmlHttpRequest.responseText;
    });
}

function ajax1() {
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let json1 = this.responseText; // string
            let object1 = JSON.parse(json1); // object

            console.log(typeof (json1)); // object
            console.log(typeof (object1)); // string

            document.getElementById("id1").innerHTML = this.responseText;
            console.log("json1: " + json1);
            console.log("object1: " + object1); // object1: [object Object]

            // saves variable to global variable to Debug in Chrome Console. var1.board[1][3]
            var1json = json1;
            var1 = object1;
        }
    };
    xmlHttpRequest.open("GET", "/ttt/3");
    xmlHttpRequest.send();
}


// https://stackoverflow.com/questions/14551194/how-are-parameters-sent-in-an-http-post-request
function ajax5() {
    let xmlHttpRequest = new XMLHttpRequest();

    xmlHttpRequest.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var5 = this.responseText; // string
            document.getElementById("id5").innerHTML = this.responseText;

        }
    };
    xmlHttpRequest.open("POST", "/ttt/move");
    xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttpRequest.send("name1=value1&name2=value2");
    // xmlHttpRequest.send("contentdata5"); // somehow this results sending string with '=' at end: "contentdata5="
    // sends parameter instead of JSON
}


// Path variable https://www.baeldung.com/spring-request-param
function ajax6() {
    AJAXGET("/6/idValue1", function (xmlHttpRequest) {
        document.getElementById("id6").innerHTML = xmlHttpRequest.responseText;
    });
}


// Post with parameter
function ajax7() {
    AJAXPOST("/7?param1=paramValue1&param2=paramValue2", "name1=value1&name2=value2", function (xmlHttpRequest) {
        document.getElementById("id7").innerHTML = xmlHttpRequest.responseText;
    });
}

function ajax8() {
    AJAXPOSTasJSON("/8?param=paramValue1", '{"a1": "b1", "a2": "b2"}', function (xmlHttpRequest) {
        document.getElementById("id8").innerHTML = xmlHttpRequest.responseText;
    });
}

