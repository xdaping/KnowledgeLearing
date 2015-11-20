package wordcode.rank;

public class WordTable implements Comparable<WordTable>{	
	private String word;
	private String num;
	
	public WordTable(){		
	}
	
	public WordTable(String num, String word){
		this.num = num;
		this.word = word;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public int compareTo(WordTable ct) {
		int i = this.num.compareTo(ct.num);
        if(i == 0) { 
             return this.word.compareTo(ct.word);
        } else {
             return i; 
        }
	}
}
