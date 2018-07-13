import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
public class Percolation {
  private boolean [][]a;
  private int top,bottom;
  private WeightedQuickUnionUF ufisfull,ufPerco;
  private int N;
  public Percolation(int n)
  {
    N=n;
  if(n<=0) throw new java.lang.IllegalArgumentException("n cannot less than 1.");
  a=new boolean[n][n];
  for(int i=0;i<n;i++)
  {
    for(int j=0;j<n;j++)
    {
     a[i][j]=false;
  }
  }
  ufisfull= new WeightedQuickUnionUF( N*N+1);
  ufPerco= new WeightedQuickUnionUF( N*N+2);
  top=N*N;
  bottom=N*N+1;

  //bottom=N*N+1;
  for (int i=0;i<N;i++)
  {
     ufisfull.union(i,top);
     ufPerco.union(i,top);
     ufPerco.union(N*N-i-1,bottom);
     //StdOut.println(N*N-i-1+" "+bottom);
  }

  }


  public    void open(int row, int col)
  {
  if (row>N||col>N||row<=0||col<=0) throw new java.lang.IllegalArgumentException("Open: Out of Exception");
  int i=row-1;
  int j=col-1;
  if (!a[i][j])
  {
  a[i][j]=true;
  if(row>1) {if(isOpen(row-1,col)) {ufisfull.union((i-1)*N+j,i*N+j);ufPerco.union((i-1)*N+j,i*N+j);}}
  if(col>1) {if(isOpen(row,col-1)) {ufisfull.union(i*N+j-1,i*N+j);ufPerco.union(i*N+j-1,i*N+j);}}
  if(row<N) {if(isOpen(row+1,col)) {ufisfull.union(i*N+j,(i+1)*N+j);ufPerco.union(i*N+j,(i+1)*N+j);}}
  if(col<N){if(isOpen(row,col+1)) {ufisfull.union(i*N+j,i*N+j+1);ufPerco.union(i*N+j,i*N+j+1);}}
  }
  }
  public boolean isOpen(int row, int col)
  {
  if (row>N||col>N||row<=0||col<=0) throw new java.lang.IllegalArgumentException("isOpen: Out of Exception");
  return a[row-1][col-1];
  }

  public boolean isFull(int row, int col)
  {
    if (row>N||col>N||row<=0||col<=0) throw new java.lang.IllegalArgumentException("isFull: Out of Exception");
    //System.out.println(row+" "+col+" "+uf.find((row-1)*N+col-1));
    return ufisfull.connected(top,(row-1)*N+col-1) && isOpen(row,col);

  }
  public     int numberOfOpenSites()
  {

  int num=0;
  for(int i=0;i<N;i++)
  {
    for(int j=0;j<N;j++)
    {
      if (a[i][j]) num+=1;
  }
  }
  //StdOut.println(num);
  return num;

  }

  public boolean percolates()
  {
      return ufPerco.connected(top,bottom)&&this.numberOfOpenSites()>0;
  }

  public static void main(String[] args)
  {
  Percolation a;
  a=new Percolation(10);
  System.out.println("open "+a.numberOfOpenSites());
  System.out.println(a.isFull(1,1));
  System.out.println(a.isFull(1,2));
  System.out.println(a.isFull(1,3));
  a.open(1,1);
  a.open(1,2);
  System.out.println(a.isFull(1,2));
  a.open(1,3);
  System.out.println(a.isFull(1,3));
  a.open(2,3);
  System.out.println(a.isFull(2,3));
  a.open(3,2);
  System.out.println(a.isFull(3,2));
  a.open(3,3);
  System.out.println("open "+a.numberOfOpenSites());
  System.out.println(a.isFull(2,3));
  System.out.println(a.isFull(3,3));
  System.out.println(a.percolates());

  }

}
