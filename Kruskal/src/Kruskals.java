import java.util.Scanner;
class Compute
{
	private static int nodes;
    int[ ][ ] graph;
    int[ ] parent;
    public void ReadFromConsole()
    {
        Scanner to_read = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        nodes= to_read.nextInt();
        graph= new int [nodes+2][nodes+2] ;
        parent = new int[nodes+2];
        int max= Integer.MAX_VALUE;
        System.out.println("Enter cost matrix");
        for(int i=1;i<=nodes;i++)
        {
            parent[i]=0;
            for(int j=1;j<=nodes;j++)
            {
                graph[i][j] = to_read.nextInt();
                if (graph[i][j]==0) graph[i][j] = max;
            }
        }
    to_read.close();
    }
    public void Kruskal()
    {
        int i,j,a=0,b=0,u=0,v=0,min,mincost=0,ne=1;
        System.out.println("The edges of Minimum Cost Spanning Tree are");
        while(ne<nodes)
        {
            for(i=1,min=Integer.MAX_VALUE;i<=nodes;i++)
                for(j=1;j<= nodes;j++)
                    if(graph[i][j] <min)
                    {
                        min=graph[i][j];
                        a=u=i;
                        b=v=j;
                    }
            u=find(u); v=find(v); 
            if(uni(u,v)==1)
            {
                System.out.println(ne++ + " edge(" + a + "," + b + ") = " + min);
                mincost +=min;
            }
            graph[a][b]=graph[b][a]=Integer.MAX_VALUE;
        }
        System.out.println("Minimum cost = " + mincost);
    }
    public int find(int i)
    {
        while(parent[i]!=0)
            i=parent[i];
        return i;
    }
    public int uni(int i,int j)
    {
        if (i != j)
        {
            parent[j] = i;
            return 1;
        }
        return 0;
    }
}
class Kruskals
{
    public static void main(String [] args)
    {
        Compute c = new Compute();
        c.ReadFromConsole();
        c.Kruskal();
    }
}