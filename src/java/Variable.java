/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class Variable {
    
    
    private String Names;
    private Integer Values;
    private String Derive;

    
    public Variable(String Names, Integer Values) {
        this.Names = Names;
        this.Values = Values;
        this.Derive = null;
    }
    
    public Variable(String Names, Integer Values, String derive) {
        this.Names = Names;
        this.Values = Values;
        this.Derive = derive;
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

    public String getDerive() {
        return Derive;
    }

    public void setDerive(String Derive) {
        this.Derive = Derive;
    }
    
    
    
}
