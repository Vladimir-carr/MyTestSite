package app.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ConverterToJson {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void toJson() throws FileNotFoundException {
        String json = GSON.toJson(ProductDB.select());
        File fileJson = new File("C:\\Users\\Samhain666\\IdeaProjects\\MyTestSite\\src\\main\\webapp\\JSON\\products.json");
        PrintWriter pw = new PrintWriter(fileJson);
        pw.println(json);
        pw.close();
    }
}
