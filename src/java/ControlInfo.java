
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

@Named(value = "ControlInfo")
@SessionScoped
public class ControlInfo implements Serializable{
    
    
    private List<String> Integrator1;
    private List<String> Integrator2;
    private List<String> TypeIntegrator;

    public ControlInfo() {
        
         Integrator1 = new ArrayList<String>();
         Integrator1.add("YYYY");
         Integrator1.add("ZZZZ");
         Integrator1.add("TTTT");
         
         
         Integrator2 = new ArrayList<String>();
         Integrator2.add("XXXX");
         Integrator2.add("AAAA");
         Integrator2.add("WWWW");
         
         
         TypeIntegrator = new ArrayList<String>();
         TypeIntegrator.add("Dicret");
         TypeIntegrator.add("continu");
         
         
         
         
    }

    public List<String> getIntegrator1() {
        return Integrator1;
    }

    public List<String> getIntegrator2() {
        return Integrator2;
    }

    public List<String> getTypeIntegrator() {
        return TypeIntegrator;
    }

    public void setIntegrator1(List<String> Integrator1) {
        this.Integrator1 = Integrator1;
    }

    public void setIntegrator2(List<String> Integrator2) {
        this.Integrator2 = Integrator2;
    }

    public void setTypeIntegrator(List<String> TypeIntegrator) {
        this.TypeIntegrator = TypeIntegrator;
    }
    
    
    
    
    
    
}
