package sae;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HistoriqueAffectation{

    public static void makeHistorique(String year, ListAffectation affectations){
        StringBuilder chemin = new StringBuilder();
        chemin.append(System.getProperty("user.dir")).append(File.separator).append("doc").append(File.separator).append(year);
        try {
            FileOutputStream fos = new FileOutputStream(chemin.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(oos);
            oos.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static Affectation getHistorique(String year){
        Affectation affectation = null;
        StringBuilder chemin = new StringBuilder();
        chemin.append(System.getProperty("user.dir")).append(File.separator).append("doc").append(File.separator).append(year);
        try {
            FileInputStream fis = new FileInputStream(chemin.toString());
            ObjectInputStream ois = new ObjectInputStream(fis);
            affectation = (Affectation) ois.readObject();
            ois.close();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch( ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
        return affectation;
    }
}
