import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonTest {

    @Test
    public void jsonConverterObjectMapper() throws Exception {
        List<Book> books = Stream.of(
                new Book("Mike", "harvey", 34),
                new Book("Nick", "young", 75),
                new Book("Jack", "slater", 21),
                new Book("gary", "hudson", 55))
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //1. Convert List of Person objects to JSON
        String arrayToJson = objectMapper.writeValueAsString(books);
        System.out.println("1. Convert List of Book objects to JSON :");
        System.out.println(arrayToJson);

        //2. Convert JSON to List of Person objects
        //Define Custom Type reference for List<Person> type
        TypeReference<List<Book>> mapType = new TypeReference<List<Book>>() {
        };

        List<Book> jsonToPersonList = objectMapper.readValue(arrayToJson, mapType);
        System.out.println("\n2. Convert JSON to List of book objects :");

        //Print list of book objects output using Java 8
        jsonToPersonList.forEach(System.out::println);


    }

    @Test
    public void makingJsonObjects(){
        JsonObject person = new JsonObject();
        person.addProperty("firstName", "Sergey");
        person.addProperty("lastName", "Kargopolov");

        // Create Inner JSON Object
        JsonObject address = new JsonObject();
        address.addProperty("country", "ru");
        address.addProperty("city", "Moscow");
        person.add("address", address);
        System.out.println(person.toString());

        // Create JSON Array
        JsonArray languages = new JsonArray();
        languages.add("Russian");
        languages.add("English");
        languages.add("French");
        System.out.println(languages.toString());



    }

    @Test
    public void jsonGson() {
        // Create new JSON Object
        JsonObject person = new JsonObject();
        person.addProperty("firstName", "Sergey");
        person.addProperty("lastName", "Kargopolov");
        System.out.println(person.toString());


        // Create Inner JSON Object
        JsonObject address = new JsonObject();
        address.addProperty("country", "ru");
        address.addProperty("city", "Moscow");
        person.add("address", address);
        System.out.println(person.toString());


        // Create JSON Array
        JsonArray languages = new JsonArray();
        languages.add("Russian");
        languages.add("English");
        languages.add("French");
        System.out.println(languages.toString());


        // Create JSON Array from String
        String jsonString = "{\"firstName\":\"Sergey\",\"lastName\":\"Kargopolov\"}";
        JsonParser jsonParser = new JsonParser();
        JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
        System.out.println(objectFromString.toString());


        // Convert JSON Array String into JSON Array
        String jsonArrayString = "[\"Russian\",\"English\",\"French\"]";
        JsonArray arrayFromString = jsonParser.parse(jsonArrayString).getAsJsonArray();
        System.out.println(arrayFromString.toString());


        // Convert JSON Array String into Java Array List
        Gson googleJson = new Gson();
        ArrayList javaArrayListFromGSON = googleJson.fromJson(arrayFromString, ArrayList.class);
        System.out.println(javaArrayListFromGSON);


        //Convert Java Plain Object into JSON
        Book bookPojo = new Book("Sergey", "Kargopolov", 12 );
        Gson gsonBuilder = new GsonBuilder().create();
        String jsonFromPojo = gsonBuilder.toJson(bookPojo);
        System.out.println(jsonFromPojo);


        // Convert Java Map into JSON
        Map personMap = new HashMap();
        personMap.put("firstName", "Sergey");
        personMap.put("lastName", "Kargopolov");
        String jsonFromJavaMap = gsonBuilder.toJson(personMap);
        System.out.println(jsonFromJavaMap);


        List<Book> books = Stream.of(
                new Book("Mike", "harvey", 34),
                new Book("Nick", "young", 75),
                new Book("Jack", "slater", 21),
                new Book("gary", "hudson", 55))
                .collect(Collectors.toList());

        String jsonFromJavaArrayList = gsonBuilder.toJson(books);
        System.out.println(jsonFromJavaArrayList);

        //convert list of books in jsonformat to objects


        Gson gson = new Gson();
        //Convert to Array
        Book[] bookArray = gson.fromJson(jsonFromJavaArrayList, Book[].class);
        Arrays.stream(bookArray).forEach(System.out::print);

        System.out.println("");

        //Convert to List
        Type founderListType = new TypeToken<ArrayList<Book>>(){}.getType();
        List<Book> bookList = gson.fromJson(jsonFromJavaArrayList, founderListType);
        bookList.stream().forEach(System.out::print);
    }


    @Test
    public void objectMapperVSgsonDistilled() throws Exception{
        List<Book> books = Stream.of(
                new Book("Mike", "harvey", 34),
                new Book("Nick", "young", 75),
                new Book("Jack", "slater", 21),
                new Book("gary", "hudson", 55))
                .collect(Collectors.toList());

        /*  ----------- GSON -------------- */

        Gson gson = new Gson();

        //Convert to String
        String jsonFromJavaArrayList = gson.toJson(books);
        System.out.println(jsonFromJavaArrayList);

        //Convert to List
        Type founderListType = new TypeToken<ArrayList<Book>>(){}.getType();
        List<Book> bookList = gson.fromJson(jsonFromJavaArrayList, founderListType);
        bookList.stream().forEach(System.out::println);


        /*  ----------- Jackson -------------- */

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Convert to string
        String arrayToJson = objectMapper.writeValueAsString(books);
        System.out.println(arrayToJson);

        //Convert JSON to List of Person objects
        TypeReference<List<Book>> mapType = new TypeReference<List<Book>>() {};
        List<Book> jsonToPersonList = objectMapper.readValue(arrayToJson, mapType);

        //Print list of book objects output using Java 8
        jsonToPersonList.forEach(System.out::println);

    }

}

