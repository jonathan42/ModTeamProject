/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.enterprise.inject.Instance;
/**
 *
 * @author jonathan
 */
public class ModelDefault {
    
    
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
	
	

	public ModelDefault () {
		sons = fathers = new String[0];
		name = type = new String();
		code = new String[9];

		TempList = InstanceList = new Instance[0];
		TempName = InstanceName = new String[0];
		
	}
	public ModelDefault(boolean Atomic) {
		name = type = new String();
		code = new String[9];
		
		if (!Atomic) {
			code[0] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelInitSim();";
			code[1] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->NextSampleHit();";
			code[2] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelOutputs(time, DT, entradas);";
			code[3] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelUpdate(time, DT, entradas);";
			code[4] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelDerivatives(time,variables,derivadas);";
			code[5] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelTerminate();";
			code[6] = "for (int i=0;i<getNumComponents();i++)\n(components->at(i))->ModelStart();";
		}
		
		TempList = InstanceList = new Instance[0];
		TempName = InstanceName = new String[0];
		
		atomic = Atomic;
	}
	
	// Variables Methods
	public int NewIn(String s) {
		ListIn.add(s);
		Collections.sort(ListIn);
		int n = ListIn.indexOf(s);
		ArrayIn = ListIn.toArray();
		
		return n;
	}
	public int NewOut(String s) {
		ListOut.add(s);
		Collections.sort(ListOut);
		int n = ListOut.indexOf(s);
		ArrayOut = ListOut.toArray();
		
		return n;
	}
	public int NewPar(String s) {
		ListPar.add(s);
		Collections.sort(ListPar);
		int n = ListPar.indexOf(s);
		ArrayPar = ListPar.toArray();
		
		ParAll();
		
		return n;
	}
	public int NewSt(String s) {
		ListSt.add(s);
		Collections.sort(ListSt);
		int n = ListSt.indexOf(s);
		ArraySt = ListSt.toArray();
		
		StAll();
		
		return n;
	}
	
	public void DelIn(int n) {
		ListIn.remove(n);
		ArrayIn = ListIn.toArray();
	}
	public void DelOut(int n) {
		ListOut.remove(n);
		ArrayOut = ListOut.toArray();
	}
	public void DelSt(int n) {
		ArraySt = ListSt.toArray();
		
		ListSt.remove(n);
		ArraySt = ListSt.toArray();
		
		StAll();
	}
	public void DelPar(int n) {
		ListPar.remove(n);
		ArrayPar = ListPar.toArray();
		
		ParAll();
	}
	
	public int NewStVal(String val, int n){
		String var = ArraySt[n].toString();
		
		DelSt(n);
		
		ListStVal.add(var + "=" + val);
		Collections.sort(ListStVal);
		int m = ListStVal.indexOf(var + "=" + val);
		ArrayStVal = ListStVal.toArray();
		
		StAll();

		return m;
	}
	public int NewParVal(String val, int n) {
		String var = ArrayPar[n].toString();
		
		DelPar(n);
		
		ListParVal.add(var + "=" + val);
		Collections.sort(ListParVal);
		int m = ListParVal.indexOf(var + "=" + val);
		ArrayParVal = ListParVal.toArray();
		
		ParAll();
		
		return m;
	}
	public int DelStVal (int n) {
		String val = ArrayStVal[n].toString().substring(0, ArrayStVal[n].toString().indexOf("="));
		
		int m = NewSt(val);
		
		ListStVal.remove(n);
		ArrayStVal = ListStVal.toArray();
		
		StAll();
		
		return m;
	}
	public int DelParVal (int n) {
		String val = ArrayParVal[n].toString().substring(0, ArrayParVal[n].toString().indexOf("="));
		
		int m = NewPar(val);
		
		ListParVal.remove(n);
		ArrayParVal = ListParVal.toArray();
		
		ParAll();
		
		return m;
	}

	public void StAll() {
		ListStAll = new ArrayList();
		ListStAll.addAll(ListSt);
		ListStAll.addAll(ListStVal);
		
		Collections.sort(ListStAll);
		ArrayStAll = ListStAll.toArray();
	}
	public void ParAll() {
		ListParAll = new ArrayList();
		ListParAll.addAll(ListPar);
		ListParAll.addAll(ListParVal);
		
		Collections.sort(ListParAll);
		ArrayParAll = ListParAll.toArray();
	}
	
	// Components Methods
	public Instance NewInstance(ModelDefault M, String s) {
		int l = InstanceList.length;
		Instance[] IL = new Instance[l+1];
		String[] IN = new String[l+1];
		for (int k=0; k<l; k++) IL[k]=InstanceList[k];
		for (int k=0; k<l; k++) IN[k]=InstanceName[k];
                Instance Inst = new Instance(M, s) {};
		
		IL[l] = Inst;
		IN[l] = s;
		InstanceList = IL;
		InstanceName = IN;
		
		return Inst;
	}
	public void NewTempInstance(Instance Inst) {
		int l = TempList.length;
		Instance[] IL = new Instance[l+1];
		String[] IN = new String[l+1];
		for (int k=0; k<l; k++) IL[k]=TempList[k];
		for (int k=0; k<l; k++) IN[k]=TempName[k];
		IL[l] = Inst;
		//IN[l] = Inst.name;
		TempList = IL;
		TempName = IN;
	}
	
	public void DelInstance(Instance Inst) {
		int n = -1;
		int l = InstanceList.length;
		for (int i = 0; i<l; i++) if (InstanceList[i] == Inst) n=i;
		
		Instance[] S = new Instance[l-1];
		for (int i = 0; i<n; i++) S[i] = InstanceList[i];
		for (int i=n+1; i<l; i++) S[i-1] = InstanceList[i];
		InstanceList = S;
		
		String[] IN = new String [l-1];
		for (int i = 0; i<n; i++) IN[i] = InstanceName[i];
		for (int i=n+1; i<l; i++) IN[i-1] = InstanceName[i];
		InstanceName = IN;
	}
	public Instance DelTempInstance(int n) {
		Instance Inst = TempList[n];
		
		int l = TempList.length;
		Instance[] S = new Instance[l-1];
		for (int i = 0; i<n; i++) S[i] = TempList[i];
		for (int i=n+1; i<l; i++) S[i-1] = TempList[i];
		TempList = S;
		
		String[] IN = new String [l-1];
		for (int i = 0; i<n; i++) IN[i] = TempName[i];
		for (int i=n+1; i<l; i++) IN[i-1] = TempName[i];
		TempName = IN;
		
		return Inst; 
	}
	
	public void SetInstance(Instance[] IL) {
		InstanceList = IL;
	}

	// Used when reading to set the model's instances' list
	public void SetInstance(ModelDefault[] ML) {
		int l = fathers.length;
		int j = ML.length;
		
		for (int i=0; i<l; i++) {
			for (int k=0; k<j; k++) {
				if (fathers[i].equals(ML[k].name)) this.NewInstance(ML[k], sons[i]);
			}
		}
	}
	
// Auxiliary Methods
	// Checks that the variable's name doesn't exists
	public boolean CheckNewVar(String s) {
		boolean New = true;
		int l;
		l=ArrayIn.length;
		for (int i=0; New && i<l; i++ ) New = !s.equals(ArrayIn[i].toString());
		l=ArrayOut.length;
		for (int i=0; New && i<l; i++ ) New = !s.equals(ArrayOut[i].toString());
		l=ArrayStAll.length;
		for (int i=0; New && i<l; i++ ) {
			String var = ArrayStAll[i].toString();
			int n = var.indexOf('=');
			if (n!=-1) var = var.substring(0, n);
			New = !s.equals(var);
		}
		l=ArrayParAll.length;
		for (int i=0; New && i<l; i++ ) {
			String var = ArrayParAll[i].toString();
			int n = var.indexOf('=');
			if (n!=-1) var = var.substring(0, n);
			New = !s.equals(var);
		}
		return New;
	}
	
	// Checks that the string is a double
	public boolean CheckDouble(String s) {
		boolean isDouble = false;
		
		try {
			Double.parseDouble(s);
			isDouble = true;
		}
		catch (NumberFormatException e) {}

		return isDouble;
	}
	
	// Checks that the string is a valid variable name
	public boolean CheckIdent(String s) {
		boolean isIdent = true;
		char c = s.charAt(0);
		int l = s.length();
		
		if (CheckChar(c)) {
			for (int j=1; isIdent && j<l; j++) {
				c = s.charAt(j);
				isIdent = (CheckChar(c) || (c>=48 && c<=57)) ;
			}
		}
		else isIdent = false;
		
		return isIdent;
	}
	
	// Checks that the char is a letter or '_'
	public boolean CheckChar(char c) {
		boolean isChar = false;
		if ((c>=97 && c<= 122) || (c>=65 && c<=90) ||  c == 95 ) isChar = true;
		return isChar;
	}
	
	// Checks that the instance's name doesn't exists
	public boolean CheckNewIns(String s) {
		boolean New = true;
		int l;
		
		l=InstanceName.length;
		for (int i=0; New && i<l; i++ ) New = !s.equals(InstanceName[i]);
		
		return New;
	}
	
	


}
