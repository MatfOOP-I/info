package rs.math.oop1.z180304.filterMapReduce.z02.samoglasnici;

import java.util.Arrays;
import java.util.List;

public class SaNajviseSamoglasnika {
    static int brojSamoglasnika(String s) {
        int ret = 0;
        for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) >= 0)
                ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        /*
        List<String> reci = new ArrayList<String>();
        String[] r = {"Miki", "Paja", "Silja", "Snezana", "Bnnnna"};
        for (String s : r)
            reci.add(s);
        */
        List<String> reci = Arrays.asList("Mikiiiiiiiii", "Paja", "Silja", "Snezana", "Bnnnna");
        final String najzvucniji = reci.stream()
                //.filter( s -> new Integer(s.length()).compareTo( 0 )>0 )
                //.map( s -> s.toUpperCase() )
                .reduce("", (x, y) -> (brojSamoglasnika(x) > brojSamoglasnika(y) ? x : y));
        System.out.println(najzvucniji);
    }

}
