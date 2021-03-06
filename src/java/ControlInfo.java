
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
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
    
    

    private String message = "";

    
    private String name;
    private String desc;
    private String descadvance;
        
    
    private List<String> Integrator1;
    private List<String> Integrator2;
    private List<String> Integrator3;
    private List<String> Integrator;
    private List<String> Equation;


    private String radioV = "continu";
    //
    private List<Parameter> Parameters  ;
    private String NamesP ;
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
         
         
         Equation= new ArrayList<String>();
         Equation.add("mon equation");
        // TypeIntegrator.add("Discret");
        // TypeIntegrator.add("Continu");
         
         
         Parameters = new ArrayList<Parameter>();
         //message += "ajout param || ";
         //Parameters.add(new Parameter("toto",  Double.parseDouble("132"))); 
         // message += "ajout fin param  ||";
          
          //message += " addparam  ||";
          //this.addParameter();
          //message += " fin addparam  ||";
         
         variables = new ArrayList<Variable>();

               
    }
 
/**
 * fonction qui change la liste déroulante  avec le bouton radio
 * @param event 
 */
    public void choixIntegration(AjaxBehaviorEvent event){
                   
       //  message += "dans de l'integration ||";
        if (event.getBehavior()!=null){
       // message += "debut de l'integration ||";
        Integrator = null;
        // Ligne pour recupere la valeur de l'object selectioner
        String valtmp =  (String) event.getComponent().getAttributes().get("value");
        // message += " ||" + valtmp +  " ||" ;
           if( valtmp.equalsIgnoreCase("continu") ){  
                  Integrator = Integrator1;
                  // message += "continu de l'integration ||";
            }  
            else if(valtmp.equalsIgnoreCase("discret")) {  
                  Integrator = Integrator2;
                  // message += "descret de l'integration ||";
                } 
            else if (valtmp.equalsIgnoreCase("algebraic")) {  
                  Integrator = Integrator3;
                   //message += "algebric de l'integration ||";
                } 
        }
       else Integrator = null;
        
       }
         
    
   /**
    * fonction de test
    */         
   /*public void addParameter(){ 
        //message += "ajout de parameter ||";
         Parameters.add(new Parameter("titi",  Double.parseDouble("132"))); 
        //message += "fin add ||";
    } 
   
   */
   
   public void addEquation(){ 
        //message += "ajout de parameter ||";
         Equation.add("new equation"); 
        //message += "fin add ||";
    } 
    public void delEquation(Object o){
        //  message += "supprimer un para ||";
        boolean val;
        val=Equation.remove(o);
         o = null;
        //   message += "fin supp para ||";
    }  
   
   
  public void addParameters(String names ,String val){ 
        
       // message += "ajout de parameter 2 para ||";
         Parameters.add(new Parameter(names, Double.parseDouble(val))); 
         NamesP=null;
         ValP=null;
         
         //message += "fin add 2 para||";
    }
    
    public void delParameter(Object o){
          //message += "supprimer un para ||";
        boolean val;
        val=Parameters.remove(o);
         o = null;
          // message += "fin supp para ||";
    }
    
    /**
     * fonction de test
     */ 
   /* public void addVariables(){      
         variables.add(new Variable("para5", (double)105)); 
    }*/
    
    
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
    
    public NodeModel saveNode (){ 
        NodeModel mode = new NodeModel(true);
        
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
    
    


    public List<String> getIntegrator() {
        return Integrator;
    }

    public void setIntegrator(List<String> Integrator) {
        this.Integrator = Integrator;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescadvance() {
        return descadvance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDescadvance(String descadvance) {
        this.descadvance = descadvance;
    }

    public List<String> getEquation() {
        return Equation;
    }

    public void setEquation(List<String> Equation) {
        this.Equation = Equation;
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

  
    
    
    
    

    
    
    
}
