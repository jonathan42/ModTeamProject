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
    
    private MindmapNode tmpNode = null;
      
    public MindMapBean() {
        
      List<MindmapNode> List = null ;
      List = newlistNode();
        
      for (int i = 1; i <List.size(); i++){
            root.addNode(List.get(i));
        }
      selectedNode = root;
      
    }  
  
    public MindmapNode getRoot() {  
        return root;  
    }  
  
    public List<MindmapNode> newlistNode(){
        // geneartion noeud racine
        root = new DefaultMindmapNode("google.com", "Google WebSite", "FFCC00", false);  
        
        // geneartion  élémént
        MindmapNode ips = new DefaultMindmapNode("IPs", "IP Numbers", "FFCC00", true);  
        MindmapNode ns = new DefaultMindmapNode("NS(s)", "Namespaces", "FFCC00", true);  
        MindmapNode malware = new DefaultMindmapNode("Malware", "Malicious", "FFCC00", true);  
        MindmapNode malwa = new DefaultMindmapNode("Virus", "Virus", "6e9ebf", true);  
        MindmapNode malwar = new DefaultMindmapNode("Toto", "Toto", "FFCC00", true);  
        MindmapNode malwarr = new DefaultMindmapNode("Titi", "Titi", "6e9ebf", true);
         
        
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
  
        MindmapNode tmp = new DefaultMindmapNode("test", "test", "6e9ebf", true);
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
         /// node.setFill("6ebf8f");
   
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
 
    
}
