package json_server;

import java.util.ArrayList;
import java.util.Collections;

// Класс для создания игрока (все, что нужно, - это вектор имеющихся у игрока чисел, поэтому игрок будет листом).
public class Gamer {

    private ArrayList<Integer> gamers = new ArrayList<>(8);
    private int port;

    // Функция выводит содержимое листа.
    public void printGamers() {
        for(int i = 0; i < 8; i++) {
            System.out.println("Игрок " + i +" имеет число: " + gamers.get(i));
        }
        System.out.println();
    }

    // Сама игра.
    public static void GameRun(Gamer first, Gamer second, MySocket MS1, MySocket MS2) {

        int pts1=0, pts2=0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(first.gamers.get(i)>first.gamers.get(j) && first.gamers.get(i) > 0 && first.gamers.get(j) > 0) {
                    System.out.println("Игрок 1 вычитает из числа " + first.gamers.get(i) + " число " + first.gamers.get(j) + " и получает 1 балл");
                    pts1++;
                }
                if(second.gamers.get(i)>second.gamers.get(j) && second.gamers.get(i) > 0 && second.gamers.get(j) > 0) {
                    System.out.println("Игрок 2 вычитает из числа " + second.gamers.get(i) + " число " + second.gamers.get(j) + " и получает 1 балл");
                    pts2++;
                }
            }
        }

        System.out.println();
        System.out.println("Игрок 1 смог сходить  " + pts1 + " раз");
        System.out.println("Игрок 2 смог сходить  " + pts2 + " раз");

        // MS1.setLine() и MS2.setLine() - записывание сообщений игрокам (каждому свое) в сокеты. Так как эти сообщения посылаются им, то их не видно на сервере.
        if(pts1 > pts2) {
            System.out.println();
            System.out.println("Первый игрок победил!");
            MS1.setLine("Ты победил! Твои очки: " + pts1 + ". Очки твоего соперника: " + pts2);
            MS2.setLine("Ты проиграл! Твои очки: " + pts2 + ". Очки твоего соперника: " + pts1);
        }
        else if(pts1 < pts2) {
            System.out.println();
            System.out.println("Второй игрок победил!");
            MS1.setLine("Ты проиграл! Твои очки: " + pts1 + ". Очки твоего соперника: " + pts2);
            MS2.setLine("Ты победил! Твои очки: " + pts2 + ". Очки твоего соперника: " + pts1);
        }
        else {
            System.out.println();
            System.out.println("Ничья!");
            MS1.setLine("Ничья! Твои очки: " + pts1);
            MS2.setLine("Ничья! Твои очки: " + pts2);
        }
        System.out.println("Очки первого игрока: " + pts1);
        System.out.println("Очки второго игрока: " + pts2);
        System.out.println();
    }
}
