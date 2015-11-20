package others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveRepetitive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		removeRepetitive("E:/JAVAProjects/ChineseNER/dict/rankTitle.txt", "E:/JAVAProjects/ChineseNER/dict/rankTitle1.txt");
		
	}
	
	public static void removeRepetitive(String file1, String file2){		
		HashSet<String> org=new HashSet<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(file1));	
			
			String line="";
			while(null!=(line=br.readLine())){					
				org.add(line);					
			}			
			br.close();	
				
			BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
			Iterator<String> it=org.iterator();			
			while(it.hasNext()){
				bw.write(it.next());
				bw.newLine();
				bw.flush();
			}						
			bw.close();
		}catch(IOException e){
				e.printStackTrace();
		}		
	}

}
