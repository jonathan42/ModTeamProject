
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
    
    private List<NodeModel> Model;

    public GlobalModel(List<NodeModel> Model) {
        this.Model = Model;
    }

    public List<NodeModel> getModel() {
        return Model;
    }

    public void setModel(List<NodeModel> Model) {
        this.Model = Model;
    }
    
    
}
