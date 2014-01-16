
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
@Named(value = "SerializableModel")
@SessionScoped
public class SerializableModel implements Serializable {

    private String message2 = "";
    
    //permet de sérialiser un obje
    public  void Serializable(GlobalModel model) {
        //GlobalModel model = new GlobalModel(null);
        message2 += "test serialisable \r \n " ;
        try {
            FileOutputStream fichier = new FileOutputStream("model_ser.save");
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeUTF("test fichier save");
            oos.writeObject(model);
            message2+= fichier.getFD().valid();
            oos.flush();
            oos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        message2 += "fin serialisable  <br />";
    }
    
    // permet de désérialiser un objet
    public static void Deserializable() {

        try {
            FileInputStream fichier = new FileInputStream("model_ser.save");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            GlobalModel model = (GlobalModel) ois.readObject();
            System.out.println("Personne : ");
            System.out.println("nom : " + model.getModel());
           //* RECUP
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       // return model;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    
    
    
}
