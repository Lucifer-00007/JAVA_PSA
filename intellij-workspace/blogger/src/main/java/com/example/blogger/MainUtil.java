package com.example.blogger;


import java.util.ArrayList;
import java.util.Collections;

public class MainUtil {
    public static void main(String[] args) {
//        Predicate<Integer> condition = y->y>0;
//        boolean val = condition.test(100);
//        System.out.println(val);

//        List<Integer> data = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
//        List<Integer> newData = data.stream().filter(x -> x>20).collect(Collectors.toList());
//        System.out.println(newData); //[30, 40, 50, 60, 70, 80, 90, 100]
//

//        Employee emp1 = new Employee();
//        emp1.setName("mike");
//        emp1.setSalary(10000);
//        emp1.setCity("Banglore");
//
//        Employee emp2 = new Employee();
//        emp2.setName("Shane");
//        emp2.setSalary(1000);
//        emp2.setCity("Banglore");
//
//        Employee emp3 = new Employee();
//        emp3.setName("Ricky");
//        emp3.setSalary(20000);
//        emp3.setCity("Delhi");
//
//        Employee emp4 = new Employee();
//        emp4.setName("Harry");
//        emp4.setSalary(7000);
//        emp4.setCity("Noida");

//        List<Employee> data = Arrays.asList(emp1, emp2, emp3, emp4);
//        List<Employee> newData = data.stream().filter(e -> e.getSalary()>1000).collect(Collectors.toList());
//        //System.out.println(newData.size()); //3
//
//        for (Employee employee:newData){
//            System.out.println(employee.getName());
//            System.out.println(employee.getSalary());
//            System.out.println(employee.getCity());
//        }

//        List<Integer> data = Arrays.asList(10, 5, 2, 20);
//        List<Integer> newData = data.stream().map(n->n*n).collect(Collectors.toList());
//        System.out.println(newData); //[100, 25, 4, 400]


//        List<Integer> data = Arrays.asList(10, 5, 2, 20);
//        List<Integer> newData = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(newData); //[2, 5, 10, 20]


        //Remove Duplicate
//        List<Integer> data = Arrays.asList(10, 5, 2, 20, 5, 8, 2, 10);
//        List<Integer> newData = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(newData); //[2, 5, 10, 20]

//        Post post1 = new Post();
//        post1.setId(1);
//        post1.setTitle("aaa");
//        post1.setContent("aaaaaaaaaa");
//
//        Post post2 = new Post();
//        post2.setId(2);
//        post2.setTitle("bbb");
//        post2.setContent("bbbbbbbbb");
//
//        Post post3 = new Post();
//        post3.setId(3);
//        post3.setTitle("ccc");
//        post3.setContent("ccccccc");
//
//        Post post4 = new Post();
//        post4.setId(4);
//        post4.setTitle("ddd");
//        post4.setContent("dddddddd");

        //Method1
        //PostDto dto1 = mapToDto(post1);
        //PostDto dto2 = mapToDto(post2);
        //PostDto dto3 = mapToDto(post3);
        //System.out.println(dtos); //[com.example.blogger.PostDto@1de0aca6, com.example.blogger.PostDto@255316f2, com.example.blogger.PostDto@41906a77]

        //Method2(Lamdas Expression)_
        //List<Post> posts = Arrays.asList(post1, post2, post3, post4);
        //List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        //System.out.println(dtos); //[com.example.blogger.PostDto@1de0aca6, com.example.blogger.PostDto@255316f2, com.example.blogger.PostDto@41906a77, com.example.blogger.PostDto@4b9af9a9]

        //Method3(Method Reference)
        //List<Post> posts = Arrays.asList(post1, post2, post3, post4);
        //List<PostDto> dtos = posts.stream().map(MainUtil::mapToDto).collect(Collectors.toList());
        //System.out.println(dtos); //[com.example.blogger.PostDto@1de0aca6, com.example.blogger.PostDto@255316f2, com.example.blogger.PostDto@41906a77, com.example.blogger.PostDto@4b9af9a9]


        //Comparable
//        MovieComparable m1= new MovieComparable("aaa", 8, 1999);
//        MovieComparable m2= new MovieComparable("ccc", 6, 1988);
//        MovieComparable m3= new MovieComparable("eee", 5, 2008);
//        MovieComparable m4= new MovieComparable("bbb", 9, 2003);
//
//        ArrayList<MovieComparable> list= new ArrayList<MovieComparable>();
//        list.add(m1);
//        list.add(m2);
//        list.add(m3);
//        list.add(m4);
//
//        Collections.sort(list);
//
//        for(MovieComparable m:list ){
//            System.out.println(m.getName());
//            System.out.println(m.getYear());
//            System.out.println(m.getRating());
//        }


        //Comparator
        MovieComparable m1= new MovieComparable("aaa", 8, 1999);
        MovieComparable m2= new MovieComparable("ccc", 6, 1988);
        MovieComparable m3= new MovieComparable("eee", 5, 2008);
        MovieComparable m4= new MovieComparable("bbb", 9, 2003);

        ArrayList<MovieComparable> list= new ArrayList<MovieComparable>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        MovieComparator movieComparator = new MovieComparator();
        Collections.sort(list, movieComparator);

        for(MovieComparable m:list ){
            System.out.println(m.getName());
            System.out.println(m.getYear());
            System.out.println(m.getRating());
        }
    }

//    static PostDto mapToDto(Post post){
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setContent(post.getContent());
//
//        return dto;
//    }

}
