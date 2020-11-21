package cn.humblecodeukco.test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author lyr
 * @Date 2020/11/20 16:42
 * @Version 1.0
 * @Description Socket Server
 */
public class TalkServer {
    public static void main(String[] args) {
        try {
            // 创建一个ServerSocket在端口4700监听客户请求
            ServerSocket server = new ServerSocket(4700);
            Socket socket;
            // 使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
            socket = server.accept();
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            // 由系统标准输入设备构造BufferedReader对象
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client: " + is.readLine());
            String line = sin.readLine();
            while (!line.equals("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Server: " + line);
                System.out.println("Client: " + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
