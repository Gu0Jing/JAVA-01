import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程的socket程序
@Slf4j
public class HttpServer01 {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8801);
        log.info("8801服务已启动！");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void service(Socket socket) throws IOException, InterruptedException {
        log.info("响应开始");
        Thread.sleep(3000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String body = "hello, my friend!";
        printWriter.println("Content-Length:" + body.getBytes().length);
        printWriter.println();
        printWriter.write(body);
        printWriter.close();
        socket.close();
        log.info("响应结束");
    }
}