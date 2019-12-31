import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class bakjoon2667 {
	static int[][] array;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int counter;
	static int T;
	static int size;
	public static void dfs(int x ,int y )
	{
		array[x][y] = 0;
		counter++;
		for(int i = 0 ;  i<4;i++)
		{
			int tempi = x + dy[i];
			int tempj = y + dx[i];
			if(0<=tempi && tempi<size && 0<=tempj && tempj < size )
			{
				if(array[tempi][tempj] == 1)
				{
					dfs(tempi,tempj);
				}
			}
		}
		
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		size = Integer.parseInt(br.readLine());
		array = new int[size][size];
		LinkedList<Integer> ans = new LinkedList<>();
		T = 0 ;
		for(int i = 0 ; i < size;i++)
		{
			String str = br.readLine();
			for(int j = 0 ; j < str.length();j++)
			{
				array[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i = 0 ; i <array.length;i++)
		{
			for(int j = 0 ; j<array[i].length;j++)
			{
				if(array[i][j] == 1)
				{
					counter = 0 ;
					T++;
					dfs(i,j);
					ans.add(counter);
				}
			}
			
			
		}
		bw.write(T+"\n");
		ans.sort(null);
		for(int i : ans)
		{
			bw.write(i+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	
}
