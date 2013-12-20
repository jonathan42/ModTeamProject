
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Instance;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
public class NewModel {
    
    
    
        public String name;
    
    
	public boolean atomic;
	public String type;
	public String[] code;			// 0: InitSim, 1: SampleHit, 2: Outputs, 3: Update,
						// 4: Derivatives, 5: Terminate, 6: Start, 7: Other(cpp), 8: Other(h).
	public Instance[] InstanceList;	        // Instances created in the combined model
	public String[] InstanceName;
	public Instance[] TempList;		// Instances of this model created in another combined model 
	public String[] TempName;	
	public String[] fathers;		// used to set the instances when reading
	public String[] sons;
	
	List ListIn = new ArrayList();
	List ListOut = new ArrayList();
	List ListPar = new ArrayList(); 	// Unset parameters
	List ListSt = new ArrayList();		// Unset states
	List ListParVal = new ArrayList();	// Set parameters
	List ListStVal = new ArrayList();	// Set states
	List ListParAll = new ArrayList();	// ListPar + ListParVal
	List ListStAll = new ArrayList();	// ListSt + ListStVal
	
	Object[] ArrayIn = new Object[0];
	Object[] ArrayOut = new Object[0];
	Object[] ArrayPar = new Object[0];
	Object[] ArraySt = new Object[0];
	Object[] ArrayParVal = new Object[0];
	Object[] ArrayStVal = new Object[0];
	Object[] ArrayParAll = new Object[0];
	Object[] ArrayStAll = new Object[0];
    
       

    
    //list Parameters (name value)
    private List<Parameter> Parameters ;
    //list Variable (name value derive)
    private List<Variable> variables;
    
}
