import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class HelloClassLoader extends ClassLoader {

    private static final String ROOT_DIR = "C:/Users/GuoJing/OneDrive/学习/极客时间/Java进阶1期/JAVA-01/Week_01/class/";

    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("HelloLoad").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = file2ByteArray(ROOT_DIR + name + ".class");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    private static byte[] file2ByteArray(String path) throws IOException {
        ByteArrayOutputStream byteOut;
        try (FileInputStream fileInput = new FileInputStream(path)) {
            byteOut = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 4];
            int n = 0;
            while ((n = fileInput.read(buffer)) != -1) {
                byteOut.write(buffer, 0, n);
            }
        }
        return byteOut.toByteArray();
    }
}
