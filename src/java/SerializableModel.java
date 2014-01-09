
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class SerializableModel {
    
    //permet de sérialiser un obje
    public static void Serializable(String argv[]) {
        GlobalModel model = new GlobalModel(null);
        try {
            FileOutputStream fichier = new FileOutputStream("model_ser.save");
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(model);
            oos.flush();
            oos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // permet de désérialiser un objet
    public static void Deserializable(String argv[]) {

        try {
            FileInputStream fichier = new FileInputStream("model_ser.save");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            GlobalModel model = (GlobalModel) ois.readObject();
            System.out.println("Personne : ");
            System.out.println("nom : " + model.getModel());
           
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
