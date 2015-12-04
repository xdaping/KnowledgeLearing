package javaPython;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
public class Test  
{  
    public static void main(String args[])  
    {  
          
        //test1();
        
        //test2();
        
        test3();
    }
    
    

	private static void test3() {
		PythonInterpreter interpreter = new PythonInterpreter();  
		interpreter.execfile("E:/JavaWorkspace/HMMPython/Time_HMM1/src/hmm_rank1.py");  
		
	}



	private static void test2() {
		PythonInterpreter interpreter = new PythonInterpreter();  
        interpreter.execfile("E:/JavaWorkspace/HMMPython/Time_HMM1/src/hmm_rank1.py");  
        PyFunction func = (PyFunction)interpreter.get("mainFun",PyFunction.class);  
  
        int a = 2010, b = 4 ;  
        PyObject pyobj = func.__call__();  
        System.out.println("anwser = " + pyobj.toString());  
  
        interpreter.close();		
		
	}

	private static void test1() {
		PythonInterpreter interpreter = new PythonInterpreter();  
        interpreter.execfile("src/javaPython/my_utils.py");  
        PyFunction func = (PyFunction)interpreter.get("adder",PyFunction.class);  
  
        int a = 2010, b = 4 ;  
        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));  
        System.out.println("anwser = " + pyobj.toString());  
  
        interpreter.close();		
	}
}  