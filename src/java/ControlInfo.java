
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private List<String> Integrator3;
    private List<String> Integrator;

     private String radioV = "continu";
    //
    private List<Parameter> Parameters ;
    private String NamesP;
    private String ValP;
    
    private List<Variable> variables;
    private String NamesV;
    private String ValV;
   
    
    public ControlInfo() {
        
        Integrator = new ArrayList<String>();
         
        Integrator1 = new ArrayList<String>();
        Integrator1.add("NONE"); 	
        Integrator1.add("EULER"); 	
        Integrator1.add("M2SL_RK4"); 	
        Integrator1.add("RK2"); 	
        Integrator1.add("RK4");	
        Integrator1.add("RKF45"); 	
        Integrator1.add("RKCK"); 	
        Integrator1.add("RK8PD"); 	
        Integrator1.add("RK2IMP"); 	
        Integrator1.add("RK4IMP"); 	
        Integrator1.add("BSIMP"); 	
        Integrator1.add("GEAR1"); 	
        Integrator1.add("GEAR2"); 	

         Integrator2 = new ArrayList<String>();
         Integrator2.add("NONE"); 	 	
         Integrator2.add("DTIME"); 	
        
         
         Integrator3 = new ArrayList<String>();
         Integrator3.add("NONE"); 	 	
         Integrator3.add("AE"); 
         //TypeIntegrator = new ArrayList<String>();
        // TypeIntegrator.add("Discret");
        // TypeIntegrator.add("Continu");
         
         
         Parameters = new ArrayList<Parameter>();
    
         variables = new ArrayList<Variable>();

               
    }
 
    public void choixIntegration(String event){
                 
      //   try {
   
           if(event.equalsIgnoreCase("Continu") ){  
                  Integrator = Integrator1;
            }  
            else if(event.equalsIgnoreCase("Discret")) {  
                  Integrator = Integrator2;
                } 
            else if(event.equalsIgnoreCase("Algebraic")) {  
                  Integrator = Integrator3;
                } 
            else Integrator = null;
      //  } // try

     //   catch (Exception e) {
     //       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  e.toString() );
          
      //  }
         
    }
            
    public void addParameter(){      
         Parameters.add(new Parameter("para5", (double)105)); 
    }
    
    public void addParameter(String names ,String val){ 
        
         Parameters.add(new Parameter(names, Double.parseDouble(val))); 
         NamesP=null;
         ValP=null;
    }
    
    public void delParameter(Object o){
        
        boolean val;
        val=Parameters.remove(o);
         o = null;
    }
    
    
    public void addVariables(){      
         variables.add(new Variable("para5", (double)105)); 
    }
    
    
    public void addVariables(String names ,String val){ 
        
         variables.add(new Variable(names, Double.parseDouble(val)));
         NamesV=null;
         ValV=null;
    }
    
    public void delVariables(Object o){
       // FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirm delete ",  "Variable delete .");  
          
        //FacesContext.getCurrentInstance().addMessage(null, message); 
        
        boolean val2;
        val2=variables.remove(o);
        // faire un message erreur si erreur
        o = null;
        
    }
    
    public NewModel saveNode (){ 
        NewModel mode = new NewModel(true);
        
        //mode.name =;
        //mode.Description = ;
        //mode.advanced_desc = ;
        //mode.father =;
        mode.setParameters(Parameters);
        mode.setVariables(variables);
        
        return mode;
    }
    
     public void SelectedType(String event ) {  
         
         if (event.toString().equalsIgnoreCase("Discret") ){
             Integrator = Integrator2;
         }
         else Integrator = Integrator1;
    } 
    
    
    public List<String> getIntegrator1() {
        return Integrator1;
    }

    public List<String> getIntegrator2() {
        return Integrator2;
    }

    public List<String> getIntegrator3() {
        return Integrator3;
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

    public void setIntegrator3(List<String> Integrator3) {
        this.Integrator3 = Integrator3;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public String getValP() {
        return ValP;
    }

    public String getValV() {
        return ValV;
    }

    public void setValP(String ValP) {
        this.ValP = ValP;
    }

    public void setValV(String ValV) {
        this.ValV = ValV;
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

    public String getNamesP() {
        return NamesP;
    }
    
    public void setNamesP(String NamesP) {
        this.NamesP = NamesP;
    }

    public String getNamesV() {
        return NamesV;
    }

    public void setNamesV(String NamesV) {
        this.NamesV = NamesV;
    }

    public String getRadioV() {
        return radioV;
    }

    public void setRadioV(String radioV) {
        this.radioV = radioV;
    }

  
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////
    public void deleteWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
    
    
    
}
