
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
    
    
    private List<String> Integrator;
    private List<String> TypeIntegrator;
    
    
    
}
