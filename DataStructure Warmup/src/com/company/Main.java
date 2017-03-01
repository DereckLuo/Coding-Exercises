package com.company;

import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //list();
        //Map();
        //Stack();
        //queue();
        //set();
        //character();
        //string();


        Bike b = new Bike(1,2,3);
        System.out.println(b.getsize());
        System.out.println(b.getheight());
        System.out.println(b.gettype());

        Bike rb = new RoadBike(1,2,3,4,5);
        System.out.println(rb.getsize());
        System.out.println(rb.gettype());
        System.out.println(rb.getheight());

        Bike rb2 = new RoadBike(4,5,6,1,2);
        System.out.println(rb2.getsize());
        System.out.println(rb2.gettype());
        System.out.println(rb2.getheight());
    }

    public static void string(){
        String s = "asdf,safdfa,,,sdfaaaaadsf,,sadf,,fdf,sdfd,fds,fd,sf,af,ad,fdf,asdf";
        String[] words = s.split(",");

        for(String sw: words){
            if(sw.length() != 0){
                System.out.println(sw);
            }
        }
        System.out.println("~~~");
        for(String sw: words){
            if(sw.length() != 0){
                StringBuffer sbf = new StringBuffer(sw);
                String n = sbf.reverse().toString();
                System.out.println(n);
            }
        }
    }

    public static void character(){
        Character c = 'a';
        System.out.println(c);
        System.out.println(c.toString());
        Character t = (char)65;
        System.out.println(t);
    }

    public static void set(){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
    }

    public static void stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.peek();
        stack.size();
        stack.search(1);
        stack.pop();
        stack.clear();
    }

    public static void queue(){
        Queue<Integer> q = new LinkedList<>();
        q.peek();
        q.add(1);
        q.poll();
        q.size();
        q.isEmpty();

    }

    public static void Map(){
        Map<Character, Integer> table = new HashMap<>();
        table.clear();              // clear hash map
        table.put('a', 2); table.put('d', 4); table.put('s', 3); table.put('f',3);
        table.containsKey('a'); // check if table contains key
        table.containsValue(1); // check if table contains value
        table.isEmpty();            //check if table is empty
        table.get('a');
        table.remove('a');      //remove element from table
        table.values();
        Set<Map.Entry<Character, Integer>> set = table.entrySet();           //returns a entry set of the table
        System.out.println(set);
        System.out.println(table.size());
    }

    public static void list(){
        //Array list
        List<Integer> list = new ArrayList<>();
        list.add(0,1); // add element into list
        list.size();                // size of the list
        list.get(0);                // get element by idex
        list.isEmpty();             // check fi a list is empty
        list.indexOf(1);            // find the index of a list object
        list.clear();               // clear the list
        list.contains(1);           // check if list contain the element
        // list.remove(1);        // remove element from list by index
        // list.removeAll();           // remove all elements according to a collection from list
        list.add(0,9); list.add(1,2); list.add(2,4);
        System.out.println(list);
        list.sort(Comparator.comparing(Integer::intValue));
        System.out.println(list);

        //Linked list
        List<Character> link = new LinkedList<>();
        link.add(0,'a');
        link.size();
        link.get(0);
        link.isEmpty();
        link.indexOf(1);
        link.clear();
        link.contains('n');
        link.add(0,'s'); link.add(1,'t'); link.add(2,'d');
        System.out.println(link);
        link.sort(Comparator.comparing(Character::charValue));
        System.out.println(link);

        //Initialization
        Character[] nlist = new Character[]{'a','n','s','f','a'};
        System.out.println(nlist);
        System.out.println(nlist[0]);
        for(Character c : nlist){
            System.out.println(c);
        }

    }
}
