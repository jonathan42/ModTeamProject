
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
    
    
    private String Integrator1V;
    private String Integrator2V;
    private String TypeIntegratorV;
    private String IntegratorV;
    
    private List<String> Integrator1;
    private List<String> Integrator2;
    private List<String> TypeIntegrator;
    private List<String> Integrator;

    
    //
    private List<Parameter> Parameters ;
    
    
    private List<String> variablesName ;
    private List<Integer> variablesValues ;
    
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
         
         
         Parameters = new ArrayList<Parameter>();
         Parameters.add(new Parameter("para", 10));
         Parameters.add(new Parameter("para2", 110));
         Parameters.add(new Parameter("para3", 120));
         
 
         
         /*variables = new ArrayList<String>();
         variables.put("Var1", 10);
         variables.put("Var2", 1);
         variables.put("Var3", 100);*/
               
    }

    public void addParameter(){
        
         Parameters.add(new Parameter("para5", 105));
       
    }
    
    public void delParameter(Object o){
        boolean val;
        val=Parameters.remove(o);
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



    public List<String> getVariablesName() {
        return variablesName;
    }

    public List<Integer> getVariablesValues() {
        return variablesValues;
    }

  

    public void setVariablesName(List<String> variablesName) {
        this.variablesName = variablesName;
    }

    public void setVariablesValues(List<Integer> variablesValues) {
        this.variablesValues = variablesValues;
    }

    //////////////////////////////////////
    public List<Parameter> getParameters() {
        return Parameters;
    }

    public void setParameters(List<Parameter> Parameters) {
        this.Parameters = Parameters;
    }

    public String getIntegrator1V() {
        return Integrator1V;
    }

    public String getIntegrator2V() {
        return Integrator2V;
    }

    public String getTypeIntegratorV() {
        return TypeIntegratorV;
    }

    public String getIntegratorV() {
        return IntegratorV;
    }

    public void setIntegrator1V(String Integrator1V) {
        this.Integrator1V = Integrator1V;
    }

    public void setIntegrator2V(String Integrator2V) {
        this.Integrator2V = Integrator2V;
    }

    public void setTypeIntegratorV(String TypeIntegratorV) {
        this.TypeIntegratorV = TypeIntegratorV;
    }

    public void setIntegratorV(String IntegratorV) {
        this.IntegratorV = IntegratorV;
    }
    
    
    
    
    
    
    
}
