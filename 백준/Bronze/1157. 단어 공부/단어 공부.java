import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        str = str.toUpperCase();
        String[] strlist = str.split("");
        Arrays.sort(strlist);

        String alphabet = strlist[0];
        String alphabet2 = "";
        int count = 1;
        HashMap<String, Integer> alphabet_count = new HashMap<>();


        for (int i = 1; i < strlist.length; i++) {
            alphabet2 = strlist[i];
            if (Objects.equals(alphabet, alphabet2)) {
                count = count + 1;
            } else {
                alphabet_count.put(alphabet, count);
                alphabet = alphabet2;
                count = 1;
            }
        }
        alphabet_count.put(alphabet, count);

        if(alphabet_count.size() == 1 ){System.out.println(strlist[0]); return;} //종류가 하나일 때 리턴

        Map.Entry<String, Integer> max = null;
        Map.Entry<String, Integer> same = null;

        Set<Map.Entry<String, Integer>> entrySet = alphabet_count.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {


            if ( max == null || entry.getValue() > max.getValue()) {
                max = entry;
            }
            else if( max == null || same ==null || entry.getValue().equals(max.getValue())) {
                same = entry;
            }

        }
        if (same != null){if(max.getValue().equals(same.getValue())){System.out.println("?");return;}}

            System.out.println(max.getKey());
    }
}
