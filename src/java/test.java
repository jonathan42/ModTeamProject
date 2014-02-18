/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.mindmap.DefaultMindmapNode;  
import org.primefaces.model.mindmap.MindmapNode; 

@Named(value = "TestModel")
@SessionScoped
public class test implements Serializable{
    

        private List<Parameter> Parameters1 ;
        private List<Parameter> Parameters2 ;
        private List<Parameter> Parameters3 ;
        private List<Parameter> Parameters4 ;
        private List<Parameter> Parameters5 ;
        
        private List<Variable> Variables1 ;
        private List<Variable> Variables2 ;
        private List<Variable> Variables3 ;
        private List<Variable> Variables4 ;
        private List<Variable> Variables5 ;
   
        private MindmapNode root;  
      
        private MindmapNode selectedNode ;
        private List<MindmapNode> ListNoeud; 
        
        private List<NodeModel> Model;
        private MindmapNode tmpNode;
        
        
        private List<NodeModel> Modelson;
    
      
        private String label;
    
        private GlobalModel modeltest;         
        
        
        public test(){ 
            List<Parameter> Parameters1 = new ArrayList<Parameter>();
            List<Parameter> Parameters2 = new ArrayList<Parameter>();
            List<Parameter> Parameters3 = new ArrayList<Parameter>();
            List<Parameter> Parameters4 = new ArrayList<Parameter>();
            List<Parameter> Parameters5 = new ArrayList<Parameter>();
            
            List<Variable> Variables1 = new ArrayList<Variable>();
            List<Variable> Variables2 = new ArrayList<Variable>();
            List<Variable> Variables3 = new ArrayList<Variable>();
            List<Variable> Variables4 = new ArrayList<Variable>();
            List<Variable> Variables5 = new ArrayList<Variable>();            
      
            
         Parameters1.add(new Parameter("Fluide1", (double)1));
         Parameters1.add(new Parameter("Fluide2", (double)15)); 
         Parameters1.add(new Parameter("Fluide3", (double)48)); 
         Parameters1.add(new Parameter("Fluide4", (double)28));
         Parameters1.add(new Parameter("Fluide5", (double)89));
         
         Parameters2.add(new Parameter("Enzyme1", (double)58));
         Parameters2.add(new Parameter("Enzyme2", (double)1025)); 
         Parameters2.add(new Parameter("Enzyme3", (double)32)); 
         Parameters2.add(new Parameter("Enzyme4", (double)175));
         Parameters2.add(new Parameter("Enzyme5", (double)0));
         
         Parameters3.add(new Parameter("Plaquettes1", (double)17));
         Parameters3.add(new Parameter("Plaquettes2", (double)157)); 
         Parameters3.add(new Parameter("Plaquettes3", (double)80)); 
         Parameters3.add(new Parameter("Plaquettes4", (double)1278));
         Parameters3.add(new Parameter("Plaquettes5", (double)423));
         
         Parameters4.add(new Parameter("Bactérie1", (double)105));
         Parameters4.add(new Parameter("Bactérie2", (double)47)); 
         Parameters4.add(new Parameter("Bactérie3", (double)120127)); 

         Parameters5.add(new Parameter("Virus1", (double)7424));
         Parameters5.add(new Parameter("Virus2", (double)45)); 

         
         Variables1.add(new Variable("titi", (double)105));
         Variables1.add(new Variable("tata", (double)105, "tata=Fluide1+Fluide2"));
  
         
         Variables2.add(new Variable("Bibi", (double)105, "Bibi=Enzyme1+Enzyme3+Enzyme2+Enzyme4-Enzyme5"));
       
         
         Variables3.add(new Variable("wiwi", (double)105, "wiwi=Plaquettes1/Plaquettes2/Plaquettes3/Plaquettes4*Plaquettes5"));
         Variables3.add(new Variable("wuwu", (double)105, "wuwu=Plaquettes2*Plaquettes5"));
        
         
         Variables4.add(new Variable("Sisi", (double)105, "Sisi=Bactérie1+Bactérie2+Bactérie3"));
         Variables4.add(new Variable("soso", (double)105, "soso=Bactérie1/Bactérie3*Bactérie2"));
    
         
         Variables5.add(new Variable("Riri", (double)105, "Riri=Virus1+Virus2"));
         Variables5.add(new Variable("Fifi", (double)105, "Fifi=Virus1/Virus2"));
         Variables5.add(new Variable("Loulou", (double)105, "Loulou=Virus1-Virus2"));

        /* 
         NewModel(boolean atomic, 
                 String name, 
                 String Description, 
                 NewModel fatherNode, 
                 List<NewModel> sonsNode, 
                 String advanced_desc, 
                 String integration_type, 
                 String integration, 
                 String color, 
                 List<Parameter> Parameters, 
                 List<Variable> variables)
        */
        // geneartion noeud racine
        NodeModel test11 = new NodeModel(false, "Tete", "Root test", null, "cuicui", "M2SL_RK4", "Discret", Parameters1, Variables1, "FFCC00");
        root = new DefaultMindmapNode(test11.name, test11, test11.color, false);  
        
        // geneartion  élémént
        NodeModel test12 = new NodeModel(false, "Corps", "blazblzefpqhpfquv hqph qg fpq", root, "Niark", "Discret", "RKCK", Parameters2, Variables2, "FFCC00");
        MindmapNode Corps = new DefaultMindmapNode(test12.name, test12, test12.color, true);  
        
        NodeModel test13 = new NodeModel(true, "Coeur", "vqiohgçq_ ushqipfh qgf gq efg qpg efgqi gqdg fpg", Corps, "Blup", "Discret", "RK4IMP", Parameters3, Variables3, "FFCC00");
        MindmapNode Coeur = new DefaultMindmapNode(test13.name, test13, test13.color, true); 
        
        NodeModel test14 = new NodeModel(true, "Bras", "quidf qgusfp qiuef qusgdfiqgf ipqg qsf ", Corps, "Schtroumpf", "Discret", "GEAR1", Parameters4, Variables4, "6e9ebf");
        MindmapNode Bras = new DefaultMindmapNode(test14.name, test14, test14.color, true); 
        
        NodeModel test15 = new NodeModel(true, "Jambes", "hfubduiqg fjhfjd bdichn dnix npqm qhdfqh qshf pquigf q fgqe  qsg q", Corps, "Plip", "Continu", "EULER", Parameters5, Variables5, "6e9ebf");
        MindmapNode Jambes = new DefaultMindmapNode(test15.name, test15, test15.color , true);   
        
        List<NodeModel> Model = new ArrayList<NodeModel>();
        
        Model.add(test11);
        Model.add(test12);
        Model.add(test13);
        Model.add(test14);
        Model.add(test15);
        
        modeltest= new GlobalModel(Model);
        
        ListNoeud = new ArrayList<MindmapNode>();
        ListNoeud.add(root);
        ListNoeud.add(Corps);
        ListNoeud.add(Coeur);
        ListNoeud.add(Bras);
        ListNoeud.add(Jambes);
    }

    public List<NodeModel> getModel() {
        return Model;
    }

    public GlobalModel getModeltest() {
        return modeltest;
    }

    public void setModel(List<NodeModel> Model) {
        this.Model = Model;
    }

    public void setModeltest(GlobalModel modeltest) {
        this.modeltest = modeltest;
    }

    public List<MindmapNode> getListNoeud() {
        return ListNoeud;
    }

    public void setListNoeud(List<MindmapNode> ListNoeud) {
        this.ListNoeud = ListNoeud;
    }

        
        
        
        
        
        
}
