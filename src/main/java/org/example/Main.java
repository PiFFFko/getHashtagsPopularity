package org.example;

import java.net.Inet4Address;
import java.util.*;

public class Main {
    private static final String str = "Java #Scala #Maven #Go #Python #SQL Oracle #Java #Java Maven Python #Maven Go #Python SQL #Oracle Scala Scala Scala Oracle Oracle #IDEA #Maven #Go #Python #SQL Maven Python Maven Go #Python SQL #Oracle Maven Python Maven Go #Python SQL #Oracle #Java #Java";

    public static void main(String[] args) {
        List<String> hashTags = getHashtags(str);
        hashTags = getHashtags(str);
        Map popularMap = getPopular(hashTags);
        popularMap = getSortedMap(popularMap);
        printMap(popularMap);

    }

    private static void printMap(Map<String,Integer> popularMap) {
        for (Map.Entry<String,Integer> entry: popularMap.entrySet()) {
            System.out.println("Something: " + entry.getKey() + ". Popularity: " + entry.getValue());
        }
    }

    public static List<String> getHashtags(String str){
        List<String> wordsListArrays = Arrays.asList(str.split(" "));
        List<String> wordsStartsWithHash = new ArrayList<>();
        for (String word:wordsListArrays) {
            if (word.startsWith("#")){
                wordsStartsWithHash.add(word.substring(1));
            }
        }
        return wordsStartsWithHash;
    }

    public static Map<String,Integer> getSortedMap(Map map){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());
        Collections.reverse(list);
        Map<String,Integer> sortedmap = new LinkedHashMap<String,Integer>();
        for (Map.Entry<String,Integer> entry: list) {
            sortedmap.put(entry.getKey(), entry.getValue());
        }
        return  sortedmap;
    }

    public static Map getPopular(List<String> list){
        Map<String, Integer> popularMar = new HashMap();
        int cur = 0;
        for (String word: list) {
            int value = 1;
            if (popularMar.containsKey(word)){
                value = popularMar.get(word) + 1;
            }
            popularMar.put(word,value);

        }
    return popularMar;
    }

}