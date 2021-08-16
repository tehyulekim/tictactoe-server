package assignment2_server_14068171.server;
/*

http://tutorials.jenkov.com/java-json/jackson-objectmapper.html
Jackson JSON Tree Model
Jackson has a built-in tree model which can be used to represent a JSON object.
Jackson's tree model is useful if you don't know how the JSON you will receive looks,


https://www.mkyong.com/java/jackson-tree-model-example/
ObjectNode

 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.HashMap;

public class JacksonJSON {

    //  the default configuration of an ObjectMapper instance is to only access properties that are public fields or have public getters/setters
    private int id = 1;
    public String name = "name1";

    private String privateString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JacksonJSON{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", privateString='" + privateString + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {

        JacksonJSON jacksonJSON = new JacksonJSON();

        jacksonJSON.id = 123;
        jacksonJSON.name = "name123";
        jacksonJSON.privateString = "privatestring123";

        System.out.println(jacksonJSON.toString());


//        ObjectMapper.writeValueAsString() is used to serialize Object to JSON string.
//        ObjectMapper.readValue() is used to deserialize JSON string to Java Object.

        ObjectMapper objectMapper = new ObjectMapper();

        // JavaObject -[objectMapper.WriteValueAsString()]-> JSONstring
        String jsonString = objectMapper.writeValueAsString(jacksonJSON); // JSON.stringify()
        System.out.println("jsonString = " + jsonString);

        // JSONstring -[objectMapper.readValue(, JavaClass.class)]-> JavaObject
        JacksonJSON result = objectMapper.readValue(jsonString, JacksonJSON.class); // JSON.parse()
        System.out.println(result.toString());


        // JsonNode   for any JSON object
        String stringJson1 = "{\"id\":111,\"name\":\"name111\"}";
        JsonNode jsonNode = objectMapper.readValue(stringJson1, JsonNode.class);

        // soutv then right arrow to .get()
        System.out.println("jsonNode = " + jsonNode);
        System.out.println("jsonNode.get(\"id\") = " + jsonNode.get("id"));
        System.out.println("jsonNode.get(\"name\") = " + jsonNode.get("name"));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonJSON));

        JacksonJSON jacksonJSON2 = objectMapper.readValue(stringJson1, JacksonJSON.class); // JSON.parse()
        System.out.println(jacksonJSON2); // automatically loads toString()
        System.out.println(jacksonJSON2.toString());


        // JsonNode .readTree() is equal to readValue(, JsonNode.class)
        JsonNode jsonNode1 = objectMapper.readTree(stringJson1);
        System.out.println(jsonNode1);
        ((ObjectNode) jsonNode1).put("newfield1", "newfieldvalue1");
        System.out.println("jsonNode1 = " + jsonNode1);
        JsonNode jsonNode2 = objectMapper.readValue(stringJson1, JsonNode.class);
        System.out.println("jsonNode2 = " + jsonNode2);

        // HashMap version
        HashMap hashMap1 = objectMapper.readValue(stringJson1, HashMap.class);
        System.out.println("hashMap1 = " + hashMap1);

        HashMap hashMap2 = objectMapper.readValue(jsonString, HashMap.class);
        System.out.println("hashMap2 = " + hashMap2);

        String hashMap2string = objectMapper.writeValueAsString(hashMap2);
        System.out.println("hashMap2string = " + hashMap2string);

/*
//                write to file. Path is project root
        objectMapper.writeValue(new File("test.json"), jacksonJSON);
 */





    }
}
