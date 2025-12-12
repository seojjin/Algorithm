import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= parseInt(br.readLine());
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            char[] input = br.readLine().toCharArray();
            for(int j=0;j<input.length;j++){
                if(!hmap.containsKey(input[j])) {
                    hmap.put(input[j], (int) Math.pow(10, input.length-j-1));
                }else{
                    hmap.put(input[j], hmap.get(input[j])+(int) Math.pow(10, input.length-j-1));
                }
            }
        }
        List<Character> keySet = new ArrayList<>(hmap.keySet());
        keySet.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return hmap.get(o2)-hmap.get(o1);
            }
        });
        

        int presentNum=9;
        int res = 0;
        for(char key : keySet){
            res += presentNum*hmap.get(key);
            presentNum--;
        }
        System.out.println(res);


    }
}
