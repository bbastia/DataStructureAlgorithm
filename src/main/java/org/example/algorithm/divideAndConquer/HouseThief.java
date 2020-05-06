package org.example.algorithm.divideAndConquer;

import java.util.HashMap;
import java.util.Hashtable;

public class HouseThief {
    public static void main(String[] args) {
        int[] arr = {6,7,1,30,8,2,4};

        HashMap<String,String> table = new HashMap<>();
        table.put(null,null);
        System.out.println(getMaxSkipAdj(arr,0,new HashMap<>()));
    }

    public static int getMaxSkipAdj(int[] moneyInHouse, int currentIndex, HashMap<Integer,Integer> memory){
        if(currentIndex >= moneyInHouse.length) return 0;

        if(memory.get(currentIndex) != null) return memory.get(currentIndex);

        int stealCurrentHouse = moneyInHouse[currentIndex]+getMaxSkipAdj(moneyInHouse,currentIndex+2,memory);
        int skipCurrentHouse = getMaxSkipAdj(moneyInHouse,currentIndex+1,memory);

        int maxCanGet = Math.max(stealCurrentHouse,skipCurrentHouse);

        memory.put(currentIndex,maxCanGet);
        return maxCanGet;

    }
}
