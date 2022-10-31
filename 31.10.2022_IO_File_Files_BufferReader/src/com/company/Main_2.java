package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main_2 {
    public static String FILE_PATH =".";
    public static void main(String[] args) {

        System.out.println(searchFiles(new File(FILE_PATH)));
        getListFromFilesLinks(searchFiles(new File(FILE_PATH))).forEach(System.out::println);

    }
    private static List<File> searchFiles(File rootFile){
        List<File>fileList=new ArrayList<>();
        File[] files=rootFile.listFiles();
        for (int i = 0; i < files.length ; i++) {
            if (!files[i].isDirectory() && files[i].getName().endsWith(".link")){
                fileList.add(files[i]);

            }
        }
        return  fileList;
    }

    private static  List<String> getListFromFilesLinks(List<File>fileList){

        List<String>stringList=new ArrayList<>();
        fileList.forEach(file->{
            try
                    (BufferedReader reader=new BufferedReader(new FileReader(file))){
                reader.lines().collect(Collectors.toList()).forEach( str -> stringList.add(str));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return stringList;
    }


}
