package assignment2_server_14068171.server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/ttt")
@SessionAttributes({"sessionGame"})
public class ServerController {

    @RequestMapping("")
    public String ttt(ModelMap modelMap) {
        System.out.println("ServerController.ttt");
        System.out.println("modelMap.get(\"sessionGame\") = " + modelMap.get("sessionGame"));
        if (modelMap.get("sessionGame") == null) {
            modelMap.addAttribute("sessionGame", new TTT());
        }
        return "ttt";
    }




    // @RestController and @ResponseBody returns java class as JSON
    // create a new game, user starts
    @RequestMapping(value = "/istart", method = RequestMethod.POST)
    @ResponseBody
    public String istart(ModelMap modelMap, @RequestBody(required = false) String string) {
        System.out.println("ServerController.istart"); // soutm
        // a new game/session is created, and saved into session attribute
        modelMap.addAttribute("sessionGame", new TTT());
        return "istart done";
    }


    // create a new game, computer starts
    @RequestMapping(value = "/ustart", method = RequestMethod.POST)
    @ResponseBody
    public String ustart(ModelMap modelMap, @RequestBody(required = false) String string) {
        System.out.println("ServerController.ustart");
        modelMap.addAttribute("sessionGame", new TTT("computer"));
        return "ustart done";
    }

    // place a cross into the position encoded in the last part of the URL, in the example ttt/move/x3y1 : 3rd column (x=3) and 1st row
    @RequestMapping(value = "/move/{position}", method = RequestMethod.POST)
    @ResponseBody
    public String move(ModelMap modelMap, @RequestBody(required = false) String string1, @PathVariable String position) {
        TTT ttt = (TTT) modelMap.get("sessionGame");
        // On the server, this will trigger the computation of the next nought to be placed.
        int x = Character.getNumericValue(position.charAt(1));
        int z = Character.getNumericValue(position.charAt(3));

        boolean moved = ttt.movePlayer(x, z);

        // 400 Bad Request If the last token of the URL is malformed, or if this position is not valid move on the current board
        if (!moved || !Character.isDigit(position.charAt(1)) || !Character.isDigit(position.charAt(3)))
            return "400 Bad Request";
        // 404 Not Found If there is not active game
        if (ttt == null || ttt.isGameOver())
            return "404 Not Found";

        return "move done";
    }

    // @ResponseBody returns java class as JSON, which is string.
    // get the current board, the format parameter is either txt or png.   /ttt/state?format=txt
    @RequestMapping(value = "/state", method = RequestMethod.GET)
    @ResponseBody
    public char[][] state(ModelMap modelMap, @RequestParam(required = false) String format) {
        System.out.println("ServerController.state");
        // the respective content type is text/plain and image/png, respectively, for txt encoding use this format:
        // ox_
        // xox
        // __x

        TTT ttt = (TTT) modelMap.get("sessionGame");
        return ttt.getBoard();
    }


    @RequestMapping(value = "/won", method = RequestMethod.GET)
    @ResponseBody
    public String won(ModelMap modelMap) {
        // content type is text/plain, value is one line: “user” , “computer”, ”draw” or “none”

        TTT ttt = (TTT) modelMap.get("sessionGame");

        // 404 Not Found If there is not active game
        if (ttt == null)
            return "404 Not Found";
        return ttt.getWinner();
    }


    @RequestMapping(value = "/possiblemoves", method = RequestMethod.GET)
    @ResponseBody
    public String possiblemoves(ModelMap modelMap) {
        // the content type is text/plain, possible coordinates are encoded as one point per line (example: 1,1\n2,3\n)
        TTT ttt = (TTT) modelMap.get("sessionGame");

        return ttt.possiblemoves();
    }



    // Optional method, not in game logic: fills board with moves for quick testing
    @RequestMapping(value = "/moveAll", method = RequestMethod.GET)
    @ResponseBody
    public TTT moveAll(ModelMap modelMap) {
        System.out.println("ServerController.moveAll");

        TTT ttt = (TTT) modelMap.get("sessionGame");

        ttt.movePlayer(1, 2);
        ttt.movePlayer(2, 1);
        ttt.movePlayer(2, 3);
        ttt.movePlayer(3, 2);

        ttt.movePlayer(1, 1);
        ttt.movePlayer(3, 3);
        ttt.movePlayer(1, 3);
        ttt.movePlayer(3, 1);
        ttt.movePlayer(2, 2);

        ttt.printBoard();

        return (TTT) modelMap.get("sessionGame");
    }

}
