import java.util.*;
import java.io.*;

public class Lab7_v5 {
    public static void main(String[] args) throws IOException, EOFException {
        Scanner sc = new Scanner(System.in);
        try{
            //RAF1
            File f1 = new File("teams.txt");
            if(f1.exists()) f1.delete();
            f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1, "rw");
            rf.seek(0);

            System.out.println("T_I_1 " + rf.length());

            System.out.println("Team iterations>> ");
            int count = sc.nextInt();

            for(int i = 0; i < count; i++){
                System.out.println("Team_name>> ");
                String name = sc.next();
                rf.writeUTF(name);
                for(int j = 0; j < 20-name.length(); j++){
                    rf.writeByte(1);
                }
                System.out.println("City>> ");
                String city = sc.next();
                rf.writeUTF(city);
                for(int j = 0; j < 20-city.length(); j++){
                    rf.writeByte(1);
                }
                System.out.println("Place>> ");
                int place = sc.nextInt();
                rf.writeInt(place);
                System.out.println("Victories>> ");
                int victories = sc.nextInt();
                rf.writeInt(victories);
            }

            System.out.println("T_I_2 " + rf.length());

            //RAF2
            File f2 = new File("teamsOut.txt");
            if(f2.exists()) f2.delete();
            f2.createNewFile();
            RandomAccessFile rf2 = new RandomAccessFile(f2, "rw");
            rf.seek(0);
            rf2.seek(0);
            System.out.println("T_I_3 " + rf2.length());

            int found = 0;
            for (int i = 0; i < count; i++){
                rf.seek(52*i);
                String name = rf.readUTF();
                rf.seek(52*i + 22);
                String city = rf.readUTF();
                rf.seek(52*i + 44);
                int place = rf.readInt();
                rf.seek(52*i + 48);
                int victories = rf.readInt();
                if (place == 1 || place == 2 || place == 3){
                    rf2.writeUTF(name);
                    for(int j = 0; j < 20-name.length(); j++){
                        rf2.writeByte(1);
                    }
                    rf2.writeUTF(city);
                    for(int j = 0; j < 20-city.length(); j++){
                        rf2.writeByte(1);
                    }
                    rf2.writeInt(place);
                    rf2.writeInt(victories);
                    found++;
                }
            }

            System.out.println("T_I_4 " + rf2.length());
            System.out.println("Количество записей>> " + found);
            rf2.seek(0);
            for(int i = 0; i < found; i++){
                rf2.seek(52*i);
                String name = rf2.readUTF();
                rf2.seek(52*i + 22);
                String city = rf2.readUTF();
                rf2.seek(52*i + 44);
                int place = rf2.readInt();
                rf2.seek(52*i + 48);
                int victories = rf2.readInt();
                System.out.println("Name: " + name + " City: " + city + " Place: " + place + " Victories: " + victories);
            }
            rf.close();
            rf2.close();
        } catch (EOFException eof) {
            System.out.println("EOF");
        } catch (IOException ioe) {
            System.out.println("IOE");
        }
    }
}
