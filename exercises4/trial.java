import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;
import java.lang.Double;
public class trial{

    public static void main(String[] args){
        double a = +0.0;
        double b = -0.0;
        StdOut.print("0.0==-0.0:" +(a==b));
        Object ao = (Object) a;
        Object bo = (Object) b;
        StdOut.print("(0.0).equals(-0.0):" + ao.equals(b));

        double c = Double.NaN;
        double d = Double.NaN;


        StdOut.print("NaN==NaN:" +(c==d));
        Object co = (Object) c;
        Object do1 = (Object) d;
        StdOut.print("(NaN).equals(NaN):" + co.equals(do1));
}
}

