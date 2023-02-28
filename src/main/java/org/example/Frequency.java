package org.example;

import java.io.*;
import java.util.logging.*;
import java.util.*;

class Frequency
{
    static Logger l= Logger.getLogger(Frequency.class.getName());
    static void count(String str)
    {
        Map<String,Integer>hm=new HashMap<>();
        String []arr=str.split("[ .,]+");
        for (String s : arr) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
        }

        Queue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());
        while(!pq.isEmpty())
        {

            l.log(Level.INFO,()-> ""+pq.poll());
        }

    }
    public static void main(String...args) throws IOException {
        File file=new File("src/main/java/org/example/inputs.txt");
        BufferedReader br=new BufferedReader(new FileReader(file));
        String nextline;
        StringBuilder sb=new StringBuilder();
        while ((nextline=br.readLine())!=null){
            nextline=nextline.concat(",");
            sb.append(nextline);
        }
        l.log(Level.INFO,()->""+sb);
        Frequency.count(sb.toString());

    }
}