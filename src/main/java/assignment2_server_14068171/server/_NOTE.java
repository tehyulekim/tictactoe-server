package assignment2_server_14068171.server;

import java.util.Arrays;

/*
Regular expression to decide winner.
"xxx______"
___xxx___"



Java is object language
Game object
start game > Create game object

JUnit 5

HTTP request server to server.
Dynamically generating HTML pages, using JSP


axis1 vertical
axis2 horizontal

different browser = new game. Thread for each game
save by session

1. Program without http communication
2. Axios http request plugin

Tic tac toe spring boot
Game state in URL?
Store game state in JSON
Check game state if win.




https://www.baeldung.com/spring-request-response-body
@RequestBody



All data transferred is JSON = Object, not string text.







https://www.w3schools.com/js/js_window_location.asp
Javascript to redirect to page

window.location.assign("http://localhost:8080/ttt")










        HashMap<String, TTT> hashMap = new HashMap<>();


        String position = "x1z3";

        int x = Character.getNumericValue(position.charAt(1));
        int z = Character.getNumericValue(position.charAt(3));

        System.out.println("x = " + x);
        System.out.println("z = " + z);











        String string1 = null;
        String string2 = null;

        System.out.println("string1 = " + string1);
        System.out.println("string1 == null = " + string1 == null); // will evaluate ( "" + string1 )  == null
        System.out.println("(string1 == null) = " + (string1 == null));

        System.out.println("(string1 == string2) = " + (string1 == string2));
        System.out.println("string1 == string2 = " + string1 == string2);


        Object object1 = null;
        System.out.println("object1 == null = " + (object1 == null));











// check if character is digit

        String position = "xyz2";
        int x = Character.getNumericValue(position.charAt(1));
        System.out.println("x = " + x);


        System.out.println("Character.isDigit(position.charAt(1)) = " + Character.isDigit(position.charAt(1)));
        System.out.println("Character.isDigit(position.charAt(1)) = " + Character.isDigit(position.charAt(3)));




 */
public class _NOTE {
    public static void main(String[] args) {

        int[][] int1 = {{1,1},{2,3},{4,5}};

        char[][] char1 = {{'1','2'},{'3','4'}};
        System.out.println(Arrays.deepToString(int1));
        System.out.println(Arrays.deepToString(char1));
    }
}
