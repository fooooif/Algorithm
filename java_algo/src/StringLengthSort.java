import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigInteger.*;

public class StringLengthSort {
    public static void main(String[] args) {
        List<AA> list = new ArrayList<>();
        list = list.stream().sorted(new Comparator<AA>() {
            @Override
            public int compare(AA o1, AA o2) {
                return o1.a.charAt(0) > o2.a.charAt(0) ? 1 : -1;
            }
        }).collect(Collectors.toList());
        for (AA aa : list) {
            System.out.println(aa.a);
        }
    }

    static class AA {
        String a = "";
        AA(String a){
            this.a = a;
        }
    }
}
