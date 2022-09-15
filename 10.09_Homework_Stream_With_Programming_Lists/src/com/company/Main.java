package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        Programmer programmer1=new Programmer("Jack","München"
                ,List.of(new Tasks(1,"Bubble sorting","done",5),
                new Tasks(2,"Work with Stream","not done",3),
                new Tasks(3,"Work with LinkedHashSet","done",4),
                new Tasks(4,"Correctur","not done",2)));


        Programmer programmer2=new Programmer("John","Berlin"
                ,List.of(new Tasks(1,"Work with HashMap","not done",6),
                new Tasks(2,"Work with LinkedList ","done",5),
                new Tasks(3,"Work with Arrays","done",4),
                new Tasks(4,"Correctur","not done",2)));


        Programmer programmer3=new Programmer("Jessy","Hamburg"
                ,List.of(new Tasks(1,"Merge sorting","done",5),
                new Tasks(2,"Work with Stream","not done",3),
                new Tasks(3,"Correctur","done",4),
                new Tasks(4,"Work with Stream","not done",2)));

        Programmer programmer4=new Programmer("Mary","Berlin"
                ,List.of(new Tasks(1,"Bubble sorting","done",5),
                new Tasks(2,"Correktur","not done",7),
                new Tasks(3,"Work with ArraysList","done",4),
                new Tasks(4,"Correctur","not done",2)));

        Programmer programmer5=new Programmer("Johan","Bremen"
                ,List.of(new Tasks(1,"Work with Stream","done",5),
                new Tasks(2,"Correktur","not done",3),
                new Tasks(3,"Work with HshSet","done",4),
                new Tasks(4,"Correctur","not done",2)));



        List<Programmer> programmerList=new ArrayList<>();
        programmerList.add(programmer1);
        programmerList.add(programmer2);
        programmerList.add(programmer3);
        programmerList.add(programmer4);
        programmerList.add(programmer5);


        System.out.println(programmerList);
        System.out.println("++++++++++++++++++++tasksList++++++++++++++++++++++");

        System.out.println("List from Programmers, they are tasks haven: ");

        //System.out.println(getTasksList(programmerList));
        System.out.println("++++++++Task_1++++++++++");
        getTasksList(programmerList).forEach(p-> System.out.println(p));
        System.out.println();
        System.out.println("++++++++Task_2+++++++++++++++++++++");
        getLongestTasksList(programmerList).forEach(p-> System.out.println(p));
        System.out.println();
        System.out.println("+++++++++++++++++++++Task_3++++++++++++++");
        getStringListFromProgrammerAndTasks(programmerList).forEach(p-> System.out.println(p+System.lineSeparator()));

    }
    /*
	Дан список Programmer(String name, String city, List<Tasks>  tasks).
Каждый программист  имеет список задач Tasks (int Number, String description, String status, int daysInProcessing).
Сформировать лист из всех задач, которые относятся к программистам из Берлина,
	  не завершены (т.е. имеют статус, отличный от «done») и висят в обработке более 5 дней.
	 */
    public static List<Tasks>getTasksList(List<Programmer>programmerList){
        return programmerList.stream()
                .filter(progr->progr.getCity().equals("Berlin"))
                .flatMap(progr->progr.getTasks().stream())
                .filter(tasks->!tasks.getStatus().equals("done") && tasks.getDaysInProcessing()>5)
                .collect(Collectors.toList());
    }

//   public static List<Tasks> getTasksList(List<Programmer>programmerList){
//        return programmerList.stream()
//                .filter(progr->Objects.equals(progr.getCity(),"Berlin"))
//                .flatMap(progr->progr.getTasks().stream())
//                        .filter(t->Objects.equals(t.getStatus(),"not done") && t.getDaysInProcessing()>5 )
//                        .collect(Collectors.toList());
//
//
//
//
//   }
//    public static List<Tasks> getTasksList( List<Programmer> programmerList){
//        return programmerList.stream()
//                .filter(programmer -> Objects.equals(programmer.getCity(), "Berlin"))
//                .flatMap(programmer -> programmer.getTasks().stream())
//                .filter(task -> !Objects.equals(task.getStatus(), "Done") && task.getDaysInProcessing() >5)
//                .collect(Collectors.toList());
//
//    }


    /*
    Дан список Programmer(String name, String city,
     List<Task>  tasks). Каждый программист  имеет список задач
     Task (int Number, String description, String status, int daysInProcessing) .
     Сформировать лист из дести задач которые дольше всего находятся в работе.
     */




    public static List<Tasks> getLongestTasksList(List<Programmer>programmerList){
        return programmerList.stream()
                .flatMap(p->p.getTasks().stream())
                .sorted((Comparator.comparingInt((Tasks task) -> task.getDaysInProcessing()).reversed()))
                // .sorted(Comparator.comparingInt(Tasks::getDaysInProcessing).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

        /*
        Дан список Programmer(String name, String city, List<Task>  tasks).
        Каждый программист  имеет список задач
        Task (int Number, String description, String status, int daysInProcessing) .
        Сформировать лист строк вида «Программист:НомерЗадача:Дней В обработке».
         */

    public static List<String> getStringListFromProgrammerAndTasks(List<Programmer>programmerList){
        return programmerList.stream()
                .flatMap(p->p.getTasks().stream()
                        .map(st->p.toString()+(st.getNumber()+" "+st.getStatus()+"  "+st.getDaysInProcessing())))
                .collect(Collectors.toList());

    }
}
