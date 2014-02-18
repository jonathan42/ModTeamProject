
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
public class NodeModel implements Serializable {
    
     
    
    public boolean atomic;
    
    public String name;
    public String Description;
    
    public MindmapNode father;
    public List<MindmapNode> sons;
    
    public NodeModel fatherNode;
    public List<NodeModel> sonsNode;
    
    public String advanced_desc;
    public String integration_type;
    public String integration;
    public String color;
      
    //list Parameters (name value)
    private List<Parameter> Parameters ;
    //list Variable (name value derive)
    private List<Variable> variables;

    public NodeModel(boolean atomic) {
        this.atomic = atomic;
    }

    // construction V1 mais pas avec les ellements correct
    
    public NodeModel(boolean atomic, String name, String Description, MindmapNode father, String advanced_desc, String integration_type, String integration, List<Parameter> Parameters, List<Variable> variables, String color) {
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

    /**
     * Constructeur a utilisez pour le modele
     * @param atomic
     * @param name
     * @param Description
     * @param fatherNode
     * @param sonsNode
     * @param advanced_desc
     * @param integration_type
     * @param integration
     * @param color
     * @param Parameters
     * @param variables 
     */    
    public NodeModel(boolean atomic, String name, String Description, NodeModel fatherNode, List<NodeModel> sonsNode, String advanced_desc, String integration_type, String integration, String color, List<Parameter> Parameters, List<Variable> variables) {
        this.atomic = atomic;
        this.name = name;
        this.Description = Description;
        this.fatherNode = fatherNode;
        this.sonsNode = sonsNode;
        this.advanced_desc = advanced_desc;
        this.integration_type = integration_type;
        this.integration = integration;
        this.color = color;
        this.Parameters = Parameters;
        this.variables = variables;
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
