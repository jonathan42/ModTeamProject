
import java.io.Serializable;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class GlobalModel implements Serializable{
    
    private List<NewModel> Model;

    public GlobalModel(List<NewModel> Model) {
        this.Model = Model;
    }

    public List<NewModel> getModel() {
        return Model;
    }

    public void setModel(List<NewModel> Model) {
        this.Model = Model;
    }
    
    
}
