/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class Parameter {
    
    private String Names;
    private Integer Values;

    public Parameter(String Names, Integer Values) {
        this.Names = Names;
        this.Values = Values;
    }

    public String getNames() {
        return Names;
    }

    public Integer getValues() {
        return Values;
    }

    public void setNames(String Names) {
        this.Names = Names;
    }

    public void setValues(Integer Values) {
        this.Values = Values;
    }
    
    
    
}
