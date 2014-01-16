
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class Parameter implements Serializable {
    
    private String Names;
    private Double Values;

    public Parameter(String Names, Double Values) {
        this.Names = Names;
        this.Values = Values;
    }

    public String getNames() {
        return Names;
    }

    public Double getValues() {
        return Values;
    }

    public void setNames(String Names) {
        this.Names = Names;
    }

    public void setValues(Double Values) {
        this.Values = Values;
    }
    
    
    
}
