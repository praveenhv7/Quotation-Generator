package com.praveen.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*  LIST */
		
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(101);
		list1.add(102);
		list1.add(103);
		list1.add(101);
		
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(105);
		list2.add(102);
		list2.add(107);
		list2.add(101);
		
		System.out.println("list1 basic");
		Iterator<Integer> iterate=list1.iterator();
		for(int i=0;i<list2.size();i++)
		{
			System.out.println("through loop"+list2.get(i));
		}
		
		
		for(;iterate.hasNext();)
		{
			System.out.println(iterate.next());
			
		}
		System.out.println("list1");
//		list1.removeAll(list2);    /* removes objects from list1 which are there in list 2 */
//		list1.retainAll(list2);
		
		list1.remove(0);
		list1.add(101);
		
		iterate=list1.iterator();
		for(;iterate.hasNext();)
		{
			System.out.println(iterate.next());
		}
		
		
		
		List<Integer> list3=new LinkedList<Integer>();
		list3.add(501);
		list3.add(502);
		list3.add(503);
		list3.add(504);
		list3.add(504);
		System.out.println("List3");
//		iterate=list3.listIterator(1);
		iterate=list3.iterator();
		for(;iterate.hasNext();)
		{
			System.out.println(iterate.next());
			
		}
		
		Set<Integer> sets=new HashSet<Integer>();
		sets.add(101);
		sets.add(102);
		sets.add(103);
		sets.add(104);
		sets.add(101);
		
		Iterator<Integer> iteratesSet=sets.iterator();
		while(iteratesSet.hasNext())
		{
			System.out.println("SETS=>"+iteratesSet.next());
		}
		System.out.println("\n");
		sets.remove(101);
		iteratesSet=sets.iterator();
		while(iteratesSet.hasNext())
		{
			System.out.println("SETS=>"+iteratesSet.next());
		}
		
		sets.add(101);
		System.out.println("\n");
		iteratesSet=sets.iterator();
		while(iteratesSet.hasNext())
		{
			System.out.println("SETS=>"+iteratesSet.next());
		}
		
		
		Set<Integer> sets1=new TreeSet<Integer>();   //HASH SET //Tree SET
		sets1.add(101);
		sets1.add(102);
		sets1.add(103);
		sets1.add(104);
		sets1.add(107);
		sets1.add(105);
		System.out.println("\n");
		iteratesSet=sets1.iterator();
		while(iteratesSet.hasNext())
		{
			System.out.println("SETS_TREE=>"+iteratesSet.next());
		}
		
		Map<Integer,String> map1=new HashMap<Integer, String>();
		
		map1.put(1,"Batman");
		map1.put(2,"super man");
		map1.put(3,"thor");
		
	}

}
