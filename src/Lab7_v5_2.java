import java.io.*;
import java.util.*;

public class Lab7_v5_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try{
            Scanner sc = new Scanner(System.in);
            File f1 = new File("tems.txt");
            if(f1.exists()) f1.delete();
            f1.createNewFile();
            fos = new FileOutputStream(f1);
            oos = new ObjectOutputStream(fos);
            System.out.println("Team iterations>> ");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++) {
                Team team = new Team();
                System.out.println("Team_Name>> ");
                team.name = sc.nextLine();
                System.out.println("City>> ");
                team.city = sc.nextLine();
                System.out.println("Place>> ");
                team.place = sc.nextInt();
                System.out.println("Victories>> ");
                team.victories = sc.nextInt();
                sc.nextLine();
                oos.writeObject(team);
            }
            fis = new FileInputStream(f1);
            oin = new ObjectInputStream(fis);
            Team t = null;
            for (int i = 0; i<count; i++) {
                t = (Team) oin.readObject();
                if (t.place == 1 || t.place == 2 || t.place == 3){
                    System.out.println(t);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        finally {
            oos.flush();
            oos.close();
            fos.close();
            fis.close();
            oin.close();
        }


    }
}
