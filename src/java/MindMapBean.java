/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


       
import java.io.Serializable;  
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;  
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;  
import org.primefaces.model.mindmap.DefaultMindmapNode;  
import org.primefaces.model.mindmap.MindmapNode;  
import org.primefaces.model.DefaultTreeNode;
 
@Named(value = "mindmapBean")
@SessionScoped
public class MindMapBean implements Serializable {  
      
    private MindmapNode root;  
      
    private MindmapNode selectedNode ;
    private List<MindmapNode> ListNoeud; 
    
    private MindmapNode tmpNode;
      
    private String label;
    
    public MindMapBean() {
        
      List<MindmapNode> List = null ;
      List = newlistNode();
        
      for (int i = 1; i <List.size(); i++){
            root.addNode(List.get(i));
        }
      selectedNode = tmpNode = root;
      
    }  
  
    public MindmapNode getRoot() {  
        return root;  
    }  
  
    public List<MindmapNode> newlistNode(){
        // geneartion noeud racine
        NewModel test = new NewModel(true, "root", label, root, label, label, label, null, null, "FFCC00");
        root = new DefaultMindmapNode(test.name, test, test.color, false);  
        
        // geneartion  élémént
        NewModel test2 = new NewModel(true, "IPs", label, root, label, label, label, null, null, "FFCC00");
        MindmapNode ips = new DefaultMindmapNode(test2.name, test2, test2.color, true);  
        
        NewModel test3 = new NewModel(true, "NS(s)", label, root, label, label, label, null, null, "FFCC00");
        MindmapNode ns = new DefaultMindmapNode(test3.name, test3, test3.color, true); 
        
        NewModel test4 = new NewModel(true, "Malware", label, root, label, label, label, null, null, "6e9ebf");
        MindmapNode malware = new DefaultMindmapNode(test4.name, test4, test4.color, true); 
        
        NewModel test5 = new NewModel(true, "Virus", label, root, label, label, label, null, null, "6e9ebf");
        MindmapNode malwa = new DefaultMindmapNode(test5.name, test5, test5.color , true); 
        
        NewModel test6 = new NewModel(true, "Toto", label, root, label, label, label, null, null, "FFCC00");
        MindmapNode malwar = new DefaultMindmapNode(test6.name, test6, test6.color, true); 
        
        NewModel test7 = new NewModel(true, "Titi", label, root, label, label, label, null, null, "6e9ebf");
        MindmapNode malwarr = new DefaultMindmapNode(test7.name, test7, test7.color, true);
         
        
        // création de la list 
        ListNoeud =null;
        ListNoeud = new ArrayList<MindmapNode>(); 
        // ajout  a la list
        ListNoeud.add(ns);
        ListNoeud.add(ips);
        ListNoeud.add(malware);
        ListNoeud.add(malwa);
        ListNoeud.add(malwar);
        ListNoeud.add(malwarr);
        
        return ListNoeud;
    }
    public void addListNode() {
        
        NewModel test = new NewModel(true);
        MindmapNode tmp = new DefaultMindmapNode(label, test, "6e9ebf", true);
        test.father = tmp ;
        tmpNode.addNode(tmp);       
        //  return  ListNoeud;   
    } 
    
    public void addListNodeCompo() {
  
        MindmapNode tmp = new DefaultMindmapNode("test", "test", "6ebf8f", true);
            tmpNode.addNode(tmp);       
        //  return  ListNoeud;    
    } 
    
    
    public MindmapNode getSelectedNode() {  
        return selectedNode;  
    }  
    public void setSelectedNode(MindmapNode selectedNode) {  
        this.selectedNode = selectedNode;  
    }  
  
    public void onNodeSelect(SelectEvent event) {  
        MindmapNode node = (MindmapNode) event.getObject();  
          
        //populate if not already loaded  
        if(node.getChildren().isEmpty()) {  
            Object label = node.getLabel();  
  
            if(label.equals("NS(s)")) {  
                for(int i = 0; i < 10; i++) {  
                    node.addNode(new DefaultMindmapNode("ns" + i + ".google.com", "Namespace " + i + " of Google", "82c542"));  
                }  
            }  
            else if(label.equals("IPs")) {  
                for(int i = 0; i < 10; i++) {  
                    node.addNode(new DefaultMindmapNode("1.1."  + i, "IP Number: 1.1." + i, "fce24f"));  
                }   
  
            }  
            else if(label.equals("Malware")) {  
                for(int i = 0; i < 10; i++) {  
                    String random = UUID.randomUUID().toString();  
                    node.addNode(new DefaultMindmapNode("Malware-"  + random, "Malicious Software: " + random, "3399ff", false));  
                }  
            }  
        }  
          
    }  
    /**
     * 
     * @param event
     * @return 
     */
    public MindmapNode NodeSelect(SelectEvent event) {  
        MindmapNode node = (MindmapNode) event.getObject();  
          tmpNode =node;
       return node;
        }
     
     public void NodeSelect2(SelectEvent event) {  
        DefaultMindmapNode node = (DefaultMindmapNode) event.getObject();  
          tmpNode =node;
          // modif couleur
         // node.setFill("6ebf8f");
   
        }
    
     //6ebf8f vert 
    
    public void onNodeDblselect(SelectEvent event) {  
        this.selectedNode = (MindmapNode) event.getObject();          
    }  

    public List<MindmapNode> getListNoeud() {
        return ListNoeud;
    }

    public void setListNoeud(List<MindmapNode> ListNoeud) {
        this.ListNoeud = ListNoeud;
    }

    public MindmapNode getTmpNode() {
        return tmpNode;
    }

    public void setTmpNode(MindmapNode tmpNode) {
        this.tmpNode = tmpNode;
    }

    public String getLabel() {
        return label;
    }

    public void setRoot(MindmapNode root) {
        this.root = root;
    }

    public void setLabel(String label) {
        this.label = label;
    }
 
    
}
