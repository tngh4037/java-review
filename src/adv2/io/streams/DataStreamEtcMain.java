package adv2.io.streams;

import java.io.*;

public class DataStreamEtcMain {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/data.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A"); // UTF-8 형식
        dos.writeInt(20); // 4바이트로 저장 (자바의 int)
        dos.writeDouble(10.5); // 8바이트로 저장 (자바의 double)
        dos.writeBoolean(true); // 1바이트로 저장 (자바의 boolean)
        dos.close();

        FileInputStream fis = new FileInputStream("temp/data.dat");
        DataInputStream dis = new DataInputStream(fis);
        String userId = dis.readUTF(); // 주의) 읽을 때, 저장헀던 순서대로 읽어야 함.
        int age = dis.readInt();
        double score = dis.readDouble();
        boolean result = dis.readBoolean();
        System.out.println("userId = " + userId);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("result = " + result);
    }
}
