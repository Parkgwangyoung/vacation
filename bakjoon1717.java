import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bakjoon1717 {
	public static void union(int[] array, int x , int y)
	{
		int a = getparent(array,x);
		int b = getparent(array,y);
		if(a < b)
			array[b] =a;
		else
			array[a]=b;
	}
	public static int getparent(int[] array, int x)
	{
		if(array[x] == x)
			return x;
		else
			return getparent(array,array[x]);
	}
	public static String findparent(int[] array, int x ,int y )
	{
		int a = getparent(array,x);
		int b = getparent(array,y);
		if(a == b)
			return "YES";
		else
			return "NO";
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sz;
		sz = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(sz.nextToken());
		int b = Integer.parseInt(sz.nextToken());
		int[] array = new int[a+1];
		for(int i = 0 ; i < array.length;i++)
		{
			array[i] = i;
		}
		for(int i = 0 ;i < b;i++)
		{
			sz = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(sz.nextToken());
			int y = Integer.parseInt(sz.nextToken());
			int z = Integer.parseInt(sz.nextToken());
			if(x == 0)
			{
				union(array, y, z);
			}
			else
			{
				bw.write(findparent(array, y, z)+"\n");
			}
		}
		bw.flush();
		bw.close();

	}

}
