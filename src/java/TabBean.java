/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;  
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

import org.primefaces.event.TabCloseEvent;  
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
  
/**
 *
 * @author jonathan
 */
  
@Named(value = "tabBean")
@SessionScoped
public class TabBean implements Serializable{  
  
    private List<String> tabs;  
    private String message3 ="";
    
    
    public TabBean() {  
        tabs = new ArrayList<String>();  
      
    }  
  
    public List<String> getTabs() {  
        return tabs;  
    }  
    
    
    public void addTab(SelectEvent event){
       //message3 += "add table detaille";
        MindmapNode node = (MindmapNode) event.getObject();
        //if(tabs.isEmpty()) {
        tabs.add(node.getLabel()); 
       // }
    }
    
    // gestion de close pop-up
    public void onTabClose(TabCloseEvent event) {  
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
        tabs.remove(event.getTab().getFacetCount());
    } 

    public String getMessage3() {
        return message3;
    }

    public void setTabs(List<String> tabs) {
        this.tabs = tabs;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }
    
    
}

