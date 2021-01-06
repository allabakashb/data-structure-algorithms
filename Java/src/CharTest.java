import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CharTest {

	static class Custom {
		int v;
		int k;
		
		Custom(int k, int v) {
			this.k = k;
			this.v = v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println((char)(0 ^ 'a' ^ 'b' ^ 'a'));
		
		PriorityQueue<Custom> pq = new PriorityQueue<Custom>(new Comparator<Custom>() {

			@Override
			public int compare(Custom o1, Custom o2) {
				
				return o1.v < o2.v ? -1 : 1;
			}
		});
		
		pq.add(new Custom(2, 1));
		pq.add(new Custom(3, 2));
		
		StringBuilder sb = new StringBuilder();
		
		//sb.append("hello");
		//sb.insert(0, "1st ");
		//System.out.println(sb.toString());
		System.out.println(pq.peek().v);
		pq.remove();
		System.out.println(pq.peek().v);
		
		List<Integer> list = new ArrayList<>();
		
		list.add(9);
		
		System.out.println(list);
		Integer n = 10;
		System.out.println(97-'z');
		List<String> li = new ArrayList<>();
		li.add("hel");
		String[] result = new String[li.size()];
		System.out.println(li.toArray());
		
		Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 > o2 ? -1 : 1;
			}
		});
		map.keySet();
		Set<Entry<Integer, Integer>> values = map.entrySet();
		for (Entry<Integer, Integer> s: values) {
			s.getValue();
		}
		
		int[] hel = new int[4];
		Arrays.sort(hel);
		System.out.println("A" + ('A' > 'Z'));
		System.out.println("Z" + 'Z');
		
	}

}
