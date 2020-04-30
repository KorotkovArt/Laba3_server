package json_server;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Network {

    // Метод формирует строку в формате JSON из полученного в качестве аргумента листа.
    static String createJSON(Gamer gamer) {
        Gson g = new Gson();
        String jsonString = g.toJson(gamer);    // Метод toJson() приводит строку к типу JSON.

        System.out.println("\nТут будет вывод из класса JSon:");
        System.out.println(jsonString);
        return jsonString;
    }

    // Метод, наоборот, из формата JSON формирует лист класса Gamer и перед возвратом листа выводит его в консоль.
    static Gamer JSONinFighter(String jsonString) {
        Gson g = new Gson();
        Gamer gamer_j = g.fromJson(jsonString, Gamer.class);  // Метод fromJson() преобразует строку jsonString из формата JSON в класс Gamer.
        gamer_j.printGamers();  // Реализованная нами функция выводит в консоль, что хранится в листе.
        return gamer_j;
    }
}
