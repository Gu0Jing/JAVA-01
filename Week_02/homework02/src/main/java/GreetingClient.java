import java.io.*;
import java.net.Socket;

/**
 * 类作用:
 * 项目名称:  whale
 * 包:      PACKAGE_NAME
 * 类名称:   GreetingClient
 * 类描述:   类功能详细描述
 * 创建人:    GuoJing
 * 创建时间:  2021/1/22/0022 21:14
 */
public class GreetingClient {
    public static void main(String [] args)
    {
        String serverName = "localhost";
        int port = Integer.parseInt("8801");
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
