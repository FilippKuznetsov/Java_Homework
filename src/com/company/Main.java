package com.company;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	/*
	"apple", "banana", "lemon", "orange" - даны такие слова
преобразовать стрим из строк в мапу,
 причём ключом сделать первую букву соответствующего слова
    {a=apple, b=banana, l=lemon, o=orange}

	 */
        String str1="apple";
        String str2="banana";
        String str3="lemon";
        String str4="orange";



        System.out.println("+++++++strings to map+++++++++");

         System.out.println(getMapFromString(List.of(str1,str2,str3,str4)));


         /*
        System.out.println(Stream.of(str1,str2,str3,str4).
                collect(Collectors.toMap(s->s.charAt(0),s->s)));
                   */

        System.out.println();
        System.out.println("+++++++any strings to one++++++");



       /*
       Linux", "Windows", "Mac" - даны такие слова
        Объединение нескольких строк в одну
        */

        String s1="Windows";
        String s2="Mac";
        String s3="Linux";
        /*
        System.out.println(Stream.of(s1,s2,s3)
                .collect(Collectors.joining(" "," "," ")));

         */

        System.out.println();

        System.out.println(getOneStringFromAny(List.of(s1,s2,s3)));
        System.out.println();

    }
    public static Map<Character,String> getMapFromString(List<String>stringList){
        Map<Character,String>map=stringList.stream()
                .collect(Collectors.toMap(s->s.charAt(0),s->s));
        return map;
    }

    public static String getOneStringFromAny(List<String>stringList){
        String str=stringList.stream().collect(Collectors.joining(" ","",""));
        return str;
    }
}
