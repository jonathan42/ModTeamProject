
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class Variable implements Serializable{
    
    
    private String Names;
    private Double Values;
    private String Derive;
    private boolean input;
    private boolean output;

    
    public Variable(String Names, Double Values) {
        this.Names = Names;
        this.Values = Values;
        this.Derive = null;
    }
    
    public Variable(String Names, Double Values, String derive) {
        this.Names = Names;
        this.Values = Values;
        this.Derive = derive;
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

    public String getDerive() {
        return Derive;
    }

    public void setDerive(String Derive) {
        this.Derive = Derive;
    }

    public boolean isInput() {
        return input;
    }

    public boolean isOutput() {
        return output;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }
    
    
    
}
