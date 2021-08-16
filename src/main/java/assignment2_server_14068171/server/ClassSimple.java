package assignment2_server_14068171.server;

/*
Class attribute is visible by JSON converter if either has public attribute or public getAttribute.
 */

import java.util.*;

public class ClassSimple {

    private static int count = 1000;
    public int id;



    ClassSimple() {
        this.id = ++count;
    }

    public int int1 = 1;
    public char char1 = 'c';
    public String string1 = "string1";

    public char[][] char2 = {{'1', '2', '3'}, {'c', 'd', 'e'}};


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int privateint = 0;
    int int2 = 1;
    private int int3 = 3;

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public int getInt3() {
        return int3;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassSimple that = (ClassSimple) o;

        if (id != that.id) return false;
        if (int1 != that.int1) return false;
        if (char1 != that.char1) return false;
        if (privateint != that.privateint) return false;
        if (int2 != that.int2) return false;
        if (int3 != that.int3) return false;
        if (string1 != null ? !string1.equals(that.string1) : that.string1 != null) return false;
        return Arrays.deepEquals(char2, that.char2);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + int1;
        result = 31 * result + (int) char1;
        result = 31 * result + (string1 != null ? string1.hashCode() : 0);
        result = 31 * result + Arrays.deepHashCode(char2);
        result = 31 * result + privateint;
        result = 31 * result + int2;
        result = 31 * result + int3;
        return result;
    }

    public static void main(String[] args) {


        List<ClassSimple> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list1.add(new ClassSimple());
        }
        for (ClassSimple item :
                list1) {
            System.out.println("item.id = " + item.id);
        }
        System.out.println("list1.get(1).id = " + list1.get(1).id);

        HashMap<String, ClassSimple> hashMap1 = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            hashMap1.put(Integer.toString(i), new ClassSimple());
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("hashMap1.get(String.valueOf(i)).id = " + hashMap1.get(String.valueOf(i)).id);
        }

        // https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
        for (Map.Entry<String, ClassSimple> entry :
                hashMap1.entrySet()) {
            String key = entry.getKey();
            ClassSimple value = entry.getValue();
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        }

        HashMap<Integer, ClassSimple> hashMap2 = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            hashMap2.put(i, new ClassSimple());
        }
        for (int i = 0; i < 3; i++) {
            hashMap2.get(i).id = 999;
            System.out.println("hashMap2.get(i).id = " + hashMap2.get(i).id);
        }


        String string1 = "something";
        String string2 = "something";
        String string3 = "something";

        System.out.println("string1.hashCode() = " + string1.hashCode());
        System.out.println("string2.hashCode() = " + string2.hashCode());
        System.out.println("string3.hashCode() = " + string3.hashCode());

        System.out.println("list1.get(1).hashCode() = " + list1.get(1).hashCode());




        // session.setAttribute(hashcode, Game); it is equivalent to a hashmap.

        ClassSimple classSimple1 = new ClassSimple();
        ClassSimple classSimple2 = new ClassSimple();

        System.out.println("classSimple1.hashCode() = " + classSimple1.hashCode());
        System.out.println("classSimple2.hashCode() = " + classSimple2.hashCode());


    }
}
