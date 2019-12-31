import java.util.ArrayList;
import java.util.Collections;

public class krutest {
	public static int[] parent;
	public static int getparent(int x )
	{
		if(parent[x] == x)
			return x;
		else
			return getparent(parent[x]);
	}
	public static boolean findparent( int x, int y)
	{
		int a = getparent(x);
		int b = getparent(y);
		if(a == b)
			return true;
		else
			return false;
	}
	public static void arr_union(int x , int y)
	{
		int a= getparent(x);
		int b = getparent(y );
		if(a < b)
			parent[b] =a;
		else
			parent[a] =b;
	}
	public static void main(String[] args) {
		int n = 7 ;
		int m = 11;
		parent = new int[n+1];
		for(int i = 1; i<parent.length;i++)
		{
			parent[i] = i;
		}
		
		ArrayList<krual> list = new ArrayList<>();
		list.add(new krual(1,7,12));
		list.add(new krual(1,4,28));
		list.add(new krual(1,2,67));
		list.add(new krual(1,5,17));
		list.add(new krual(2,4,24));
		list.add(new krual(2,5,62));
		list.add(new krual(3,5,20));
		list.add(new krual(3,6,37));
		list.add(new krual(4,7,13));
		list.add(new krual(5,6,45));
		list.add(new krual(5,7,73));
		Collections.sort(list);
		int sum = 0 ;
		for(int i = 0 ; i<list.size();i++)
		{
			krual node = list.get(i);
			if(!findparent(node.x, node.y))
			{
				sum+= node.dis;
				arr_union(node.x, node.y);
			}
			
		}
		System.out.println(sum);
	}
}
class krual implements Comparable<krual>
{
	int x,y,dis;
	public krual(int x,int y , int dis)
	{
		this.x =x;
		this.y =y;
		this.dis =dis;
	}
	@Override
	public int compareTo(krual o) {
		// TODO Auto-generated method stub
		if(this.dis>o.dis)
			return 1;
		else if (this.dis == o.dis)
			return 0;
		else
			return -1;
	}
}