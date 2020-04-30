package json_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JSON_server {

    public static void main(String[] args) throws IOException {

        Gamer F1;
        Gamer F2;

        // Создаем 2 сокета для коммуникации с от игроками. В скобках указывается номер ожидаемого порта.
        MySocket MS1 = new MySocket(3222);
        MS1.recieveMessage();
        System.out.println(MS1.getLine());  // Метод getLine() возвращает строку в "сыром" формате JSON.
        System.out.println();

        MySocket MS2 = new MySocket(2015);
        MS2.recieveMessage();
        System.out.println(MS2.getLine());
        System.out.println();

        // Сначала при помощи метода JSONinFighter формируем лист из формата JSON, а затем записываем листы в F1 и F2.
        F1 = Network.JSONinFighter(MS1.getLine());
        F2 = Network.JSONinFighter(MS2.getLine());

        // Запускаем игру.
        Gamer.GameRun(F1,F2,MS1,MS2);

        // Отправляем игрокам строки в кодировке UTF-8.
        MS1.sendLine();
        MS2.sendLine();

        // Вызываем методы для закрытия потоков.
        MS1.finishWork();
        MS2.finishWork();
    }
}