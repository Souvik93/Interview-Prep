// Asked In SETU

package com.sw.svk.com.souvik.world;

import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    static HashMap<Integer,List<Integer>> map = new HashMap<>();
    
    static TreeSet<Integer> set = new TreeSet<>();
    
    
    static int maxPlacesCount = 0;
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!"+map );
        
        int temples[] = new int[2];
        // temples[0] = 2;
        int currentValue = 3;
       for(int i=0;i<temples.length;i++) {
           temples[i] = currentValue++;
       }
       
       int edges[][] = new int[5][2];
       
       // 1 2
       // 1 6
       // 2 3
       // 2 4
       // 2 5
       edges[0][0] = 1;
       edges[0][1] = 2;
       edges[1][0] = 1;
       edges[1][1] = 6;
       edges[2][0] = 5;
       edges[2][1] = 6;
       edges[3][0] = 2;
       edges[3][1] = 4;
       edges[4][0] = 2;
       edges[4][1] = 5;
       
       
        int anwer = solution(temples,edges,6,3);
        System.out.println(anwer);
    }
    
    static int solution(int[] temples, int[][] edges,int n,int k){
        // Write your code here


        // HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int[] arr: edges) {

            if(map.containsKey(arr[0])) {
                // map.put(arr[0],map.get(arr[0]))
                map.get(arr[0]).add(arr[1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[1]);
                map.put(arr[0],list);
            }



        }

        // TreeSet<Integer> set = new TreeSet<>();

        for(int i:temples) {
            set.add(i);
        }
        
        dfs(1,0);
        
        return maxPlacesCount;
    
    }
    
    private static void dfs(int sp,int totalSize) {
        
        List<Integer> dests = map.get(sp);
        
        if(dests !=null) {
            
        
        for(int i: dests) {
            if(!set.contains(i)) {
                dfs(i,totalSize+1);
            }
        }
        
        }
        
        maxPlacesCount = Math.max(maxPlacesCount,totalSize);
        
    }
}
