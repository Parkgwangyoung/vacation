import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bakjoon_9372 {
	public static int[][] parent;
	public static int getparent(int i ,int x)
	{
		if(parent[i][x] == x)
			return x;
		else
			return getparent(i,parent[i][x]);
	}
	public static boolean findparent(int i, int x,int y)
	{
		int a = getparent(i,x);
		int b = getparent(i,y);
		if(a == b)
			return true;
		else
			return false;
	}
	public static void union(int i,int x,int y)
	{
		int a = getparent(i,x);
		int b = getparent(i,y);
		if(a < b)
			parent[i][b] =a;
		else
			parent[i][a] =b;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sz;
		ArrayList<kruscal> list[];
		int testcase = Integer.parseInt(br.readLine());
		list = new ArrayList[testcase];
		parent = new int[testcase][];
		for(int i = 0 ; i <testcase;i++)
		{
			sz = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sz.nextToken());
			parent[i] = new int[a+1];
			int b = Integer.parseInt(sz.nextToken());
			list[i] = new ArrayList<>();
			for(int j = 0 ; j<b;j++)
			{
				sz = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(sz.nextToken());
				int y = Integer.parseInt(sz.nextToken());
				list[i].add(new kruscal(x, y));
			}
		}
		int sum = 0 ;
		for(int i = 0 ; i<parent.length;i++)
		{
			for(int j  =1;j<parent[i].length;j++)
			{
				parent[i][j] = j;
			}
		}
		for(int i = 0 ; i< list.length;i++)
		{
			for(int j = 0 ; j<list[i].size();j++)
			{
				kruscal get = list[i].get(j);
				if(!findparent(i, get.x, get.y))
				{
					sum+=1;
					union(i, get.x, get.y);
				}
			}
			bw.write(String.valueOf(sum)+"\n");
			
			sum = 0;
		}
		bw.flush();
		bw.close();
		
	}
}
class kruscal {
	int x,y;
	public kruscal(int x , int y)
	{
		this.x = x;
		this.y = y;
		
	}
	
}
