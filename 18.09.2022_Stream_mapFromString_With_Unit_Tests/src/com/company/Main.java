package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    /*
       Дана строка (для простоты можно считать,
         слова разделены одним пробелом и строка не содержит знаков препинание и т.д.).
          Используя стрим, получить map<String, Integer> где ключ – слово,
           значение – сколько раз это слово встречается в строке.

     */

    public static void main(String[] args) {
	String str1="hello hello hello world this world is Java world ";
    /*
        System.out.println(getStringListFromString(str1));
        System.out.println(getMapFromList(getStringListFromString(str1)));

    */
        System.out.println(streamObjectCounting(stringToStream(str1)));
    }

    public  static Stream<String> stringToStream(String str){
        return Arrays.stream(str.split(" "));
    }
    public static  Map<String,Integer>streamObjectCounting(Stream<String>stringStream){
        return stringStream.collect(Collectors.toMap(s->s,s->1,(s1,s2)->++s1));
    }



    /*
    public static List<String> getStringListFromString(String str){
        boolean flag=true;
        String word="";
        List<String>stringList=new ArrayList<>();
        for (int i = 0; i <str.length() ; i++) {
            word+=str.charAt(i);
            if (str.charAt(i)==' ') flag=false;


        }
        stringList.add(word);
        return stringList;
    }
    public static Map<String,Integer> getMapFromList(List<String>stringList){
        return stringList.stream()
                .collect(Collectors.toMap(str->str,str->{
                    int count=0;
                    for (int i = 0; i < stringList.size() ; i++) {
                        for (int j = 0; j < stringList.size(); j++) {
                            if (stringList.get(i)==stringList.get(j)) {
                                stringList.stream().count();
                            }
                        }
                    }
               return count;
                }));
    }

     */

}
