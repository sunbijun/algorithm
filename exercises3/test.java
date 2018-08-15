import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
public class test{
    public static void main(String[] args) {
        In in = new In(args[0]);
        //In in = new In("./data/input8.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        FastCollinearPoints a = new FastCollinearPoints(points);

        Point[] p1 = {new Point(10000,0), new Point(0,10000)};
        Point[] p2 = {new Point(13000,0), new Point(5000,12000)};
        Point[] p3 = {new Point(30000,0), new Point(0,30000)};
        Point[] p4 = {new Point(10000,0), new Point(30000,0)};

        boolean pp = a.isCollinear((p1,p4);
        StdOut.print("14 :" + a.isCollinear(p1,p4));
        StdOut.print("24 :" + a.isCollinear(p2,p4));
        StdOut.print("34 :" + a.isCollinear(p3,p4));


    }
}
