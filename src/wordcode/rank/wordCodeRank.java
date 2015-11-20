package wordcode.rank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;


public class wordCodeRank {

	public static void main(String[] args) {
		
		TreeSet<WordTable> ts = new TreeSet<WordTable>();

		getWordTable(ts, "C:/Users/daping/Desktop/wordCode.txt");

		createWordTable(ts, "C:/Users/daping/Desktop/wordCodeRank.txt");						
	}
	
	public static void getWordTable(TreeSet<WordTable> ts, String fileName){		
		try{
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));		
			String line = "";
			
			while(null != (line=br.readLine())){
				String words[] = line.split(" "); 
				
				ts.add(new WordTable(words[1], words[0]));
			}							
		}catch(IOException e){
			e.printStackTrace();
		}			
	}
	
	public static void createWordTable(TreeSet<WordTable> ts, String fileName){			
		try{			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));			
			
			Iterator<WordTable> it = ts.descendingIterator();
			while(it.hasNext()){
				WordTable ct = it.next();
				
				bw.write(ct.getWord()+" "+ct.getNum());
				bw.newLine();
				bw.flush();
			}
			
			bw.close();			
		}catch(IOException e){
				e.printStackTrace();
		}			
	}
}
