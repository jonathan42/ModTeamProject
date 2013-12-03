
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

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
    private List<String> Integrator;

    
    //
    private HashMap<String, Integer> Parameters ;
    private HashMap<String, Integer> variables ;
    
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
         TypeIntegrator.add("Discret");
         TypeIntegrator.add("Continu");
         
         
         Parameters = new HashMap<String, Integer>();
         Parameters.put("para1", 15);
         Parameters.put("para2", 14);
         Parameters.put("para3", 150);
         
         variables = new HashMap<String, Integer>();
         variables.put("Var1", 10);
         variables.put("Var2", 1);
         variables.put("Var3", 100);
               
    }

     public void SelectedType(SelectEvent event ) {  
         
         if (event.getObject().toString().equalsIgnoreCase("Discret") ){
             Integrator = Integrator1;
         }
         else Integrator = Integrator2;
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

    public List<String> getIntegrator() {
        return Integrator;
    }

    public void setIntegrator(List<String> Integrator) {
        this.Integrator = Integrator;
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

    public HashMap<String, Integer> getParameters() {
        return Parameters;
    }

    public HashMap<String, Integer> getVariables() {
        return variables;
    }

    public void setParameters(HashMap<String, Integer> Parameters) {
        this.Parameters = Parameters;
    }

    public void setVariables(HashMap<String, Integer> variables) {
        this.variables = variables;
    }
    
    
    
    
    
    
}
