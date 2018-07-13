import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class PercolationStats {
  private double threshold []; 
  private double mean;
  private double stddev,confidenceLo,confidenceHi;
  public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
     Percolation Pers;
     if(n<=0||trials<=0) throw new java.lang.IllegalArgumentException("n or trial should be no less than 1.");
     threshold=new double [trials]; 
     for (int i=0;i<trials;i++)
     {
     Pers=new Percolation(n);
     //StdOut.println("num_initial"+Pers.numberOfOpenSites());
     int sum=0;
     do
     {
     int a;
     int b;
     do
     {
     a=StdRandom.uniform(n)+1;
     b=StdRandom.uniform(n)+1;
     //StdOut.println("Std"+ a+" "+b);
     //StdOut.println("Open "+!Pers.isOpen(a, b));
     }while(Pers.isOpen(a, b));
     Pers.open(a,b); 
     //StdOut.println("Open"+ a+" "+b);
     sum++;
     //Pers.open(a,b); 
     //StdOut.println("sum"+sum+";  num_process"+(n*n-Pers.numberOfOpenSites()));
     }while(!Pers.percolates());
     //StdOut.println("sum "+sum); 
     threshold [i] =(double) sum/n/n;
     //StdOut.println("num_final"+Pers.numberOfOpenSites());
     //StdOut.println("n*n "+(sum+Pers.numberOfOpenSites())+" "+" %"+threshold [i]);

     }
          mean=StdStats.mean(threshold);
     stddev=StdStats.stddev(threshold);
     confidenceLo=mean-1.96*stddev/Math.sqrt(threshold.length);
     confidenceHi=mean+1.96*stddev/Math.sqrt(threshold.length);
   }
   public double mean()                          // sample mean of percolation threshold
   {
     
   return mean;
   }
   public double stddev()                        // sample standard deviation of percolation threshold
    {
     
   return stddev;
   } 
     
   
   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {
         return confidenceLo;
   }
   public double confidenceHi()                  // high endpoint of 95% confidence interval
   {
         return confidenceHi;
   }

   public static void main(String[] args)        // test client (described below)
   {
      int n = StdIn.readInt();
      int trials = StdIn.readInt();
     PercolationStats a = new PercolationStats(n,trials);
     StdOut.println("mean                    = "+a.mean());
     StdOut.println("stddev                  = "+a.stddev());
     //StdOut.printf("95% confidence interval = [ %f ,",a.confidenceLo());
     StdOut.println("95% confidence interval = ["+a.confidenceLo()+", "+ a.confidenceHi()+"]");
          
   //StdOut.println(StdRandom.uniform(19));3

 
   }  

}
