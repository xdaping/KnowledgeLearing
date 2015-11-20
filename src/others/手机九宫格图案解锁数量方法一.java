package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class 手机九宫格图案解锁数量方法一 {
	public static void main(String[] args) {
		int res=counts();
		System.out.println(res);
	}
	
	

	//�ȵõ����Ե�������ϣ�Ȼ��ȥ����Щ�����ܵ����
	public static int counts(){
		HashMap<String,String> map = new HashMap<String,String>();
		ArrayList<String> permute = new ArrayList<String>();
		for(int i=4;i<=9;i++){
			permute.addAll(permutation(9,i));
		}
		System.out.println(permute.size());
		map.put("13", "2");
		map.put("46", "5");
		map.put("79", "8");
		map.put("17", "4");
		map.put("28", "5");
		map.put("39", "6");
		map.put("19", "5");
		map.put("37", "5");
		
		map.put("31", "2");
		map.put("64", "5");
		map.put("97", "8");
		map.put("71", "4");
		map.put("82", "5");
		map.put("93", "6");
		map.put("91", "5");
		map.put("73", "5");
		int count = permute.size();
		
		for(String cur :permute){
			for (Entry<String, String> entry : map.entrySet()){
				String key = entry.getKey();
				String value = entry.getValue();
				if(cur.contains(key) && (cur.indexOf(value) == -1 || cur.indexOf(value) > cur.indexOf(key)) ){
					count--;
					break;
				}
			}
			
		}
		
		return count;
	}
	
	
	public static ArrayList<String> permutation(int n,int k){
		ArrayList<String> res = new ArrayList<String>();
		for(int i =1;i<=n;i++){
			StringBuilder temp= new StringBuilder();
			temp.append(i);
			BFS(n,k,temp,1,i,res);
		}
		return res;
	}
	
	public static void BFS(int n, int k,StringBuilder cur,int depth, int x,ArrayList<String> res){
		if(depth == k){
			res.add(new String(cur));
			return;
		} 
		for(int i=1;i<=n;i++){
			if(cur.indexOf(String.valueOf(i)) >=0) continue;
			cur.append(i);
			BFS(n,k,cur,depth+1,i,res);
			cur.deleteCharAt(cur.length()-1);
		}
	}
}
