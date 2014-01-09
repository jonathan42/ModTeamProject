
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Instance;
import org.primefaces.model.mindmap.MindmapNode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class NewModel implements Serializable {
    
     
    
    public boolean atomic;
    
    public String name;
    public String Description;
    public MindmapNode father;
    public MindmapNode sons;
    public String advanced_desc;
    public String integration_type;
    public String integration;
    public String color;
      
    //list Parameters (name value)
    private List<Parameter> Parameters ;
    //list Variable (name value derive)
    private List<Variable> variables;

    public NewModel(boolean atomic) {
        this.atomic = atomic;
    }

    public NewModel(boolean atomic, String name, String Description, MindmapNode father, String advanced_desc, String integration_type, String integration, List<Parameter> Parameters, List<Variable> variables, String color) {
        this.atomic = atomic;
        this.name = name;
        this.Description = Description;
        this.father = father;
        this.advanced_desc = advanced_desc;
        this.integration_type = integration_type;
        this.integration = integration;
        this.Parameters = Parameters;
        this.variables = variables;
        this.color =color;
    }

    public boolean isAtomic() {
        return atomic;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public MindmapNode getFather() {
        return father;
    }

    public String getAdvanced_desc() {
        return advanced_desc;
    }

    public String getIntegration_type() {
        return integration_type;
    }

    public String getIntegration() {
        return integration;
    }

    public List<Parameter> getParameters() {
        return Parameters;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setAtomic(boolean atomic) {
        this.atomic = atomic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setFather(MindmapNode father) {
        this.father = father;
    }

    public void setAdvanced_desc(String advanced_desc) {
        this.advanced_desc = advanced_desc;
    }

    public void setIntegration_type(String integration_type) {
        this.integration_type = integration_type;
    }

    public void setIntegration(String integration) {
        this.integration = integration;
    }

    public void setParameters(List<Parameter> Parameters) {
        this.Parameters = Parameters;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }
    
    
    
}
