
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
    private boolean input;
    private boolean output;

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
