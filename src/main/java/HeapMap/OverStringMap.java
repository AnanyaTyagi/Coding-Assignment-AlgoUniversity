package HeapMap;

import java.util.HashMap;
import java.util.Scanner;

public class OverStringMap {
//TODO
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    String t = scanner.next();
    int ss = s.length();
    int ts = t.length();
    HashMap<Character, Integer> mp = new HashMap<>();

    int bal = ts;
    for (char c : t.toCharArray()) {
        mp.put(c, mp.getOrDefault(c, 0) + 1);
    }

    int b = -1, e = -1, j = 0, i;
    for (i = 0; i < ss; i++) {
        if (mp.containsKey(s.charAt(i))) {
            mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
            if (mp.get(s.charAt(i)) >= 0) {
                bal--;
            }
            if (bal == 0) {
                while (true) {
                    if (mp.containsKey(s.charAt(j))) {
                        if (mp.get(s.charAt(j)) < 0) {
                            mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
                            j++;
                        } else {
                            break;
                        }
                    } else {
                        j++;
                    }
                }
                if (b == -1) {
                    b = j;
                    e = i;
                } else {
                    if (e - b > i - j) {
                        b = j;
                        e = i;
                    }
                }
            }
        }
    }
    if (b == -1) {
        System.out.println(-1);
    } else {
        System.out.println(e - b + 1);
    }
}
}
