package com.jjob.hobby;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Hobbies {
    
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();
    
    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }
    
    public boolean findHobby(String[] hobbies, String hobby)
    {
    	console(Arrays.toString(hobbies));
    	ArrayList<String> hb= (ArrayList<String>) Stream.of(hobbies).filter(predicate->
    	
    		predicate.equals(hobby)
    	).collect(Collectors.toList());
    	
    	Long count= Stream.of(hobbies).filter(predicate->predicate.equals(hobby)).count();
    	
    	console(String.join(",",hb));
    	console("count="+ count);
    	return true;
    }
    
    public List<String> findHobbyists(String hobby) {
    	
    	ArrayList<String> names = new ArrayList();
    	this.hobbies.forEach((name, hbs) -> 
    	{
    		console(name);
    		if(this.findHobby(hbs, hobby))
    		{
    			console("finded");
    			names.add(name);
    		}
    		console(" " );
    		
    	});
    return names;
    	
    	//hobbies.entrySet().forEach(_element -> _element.);
    	//for(HashMap map: hobbies.entrySet())
    	
    	
    	//Stream.of(hobbies.entrySet()).forEach(action -> action.);
    	
//    	
//    	ArrayList<String> finded= ;
//    	HashSet<String> names = (HashSet<String>) this.hobbies.keySet();
//    	
//    	//hobbies.
//    	
//    	for(String name: names)
//    	{
//    		hobbies.get(name);
//    		//ArrayList<String> hobbies= new ArrayList(hobbies.);
//    		
//    	}
    	
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("John", "Piano", "Puzzles", "Yoga");
        hobbies.add("Adam", "Drama", "Fashion", "Pets");
        hobbies.add("Mary", "Magic", "Pets", "Reading");
        
        System.out.println(Arrays.toString(hobbies.findHobbyists("Yoga").toArray()));
    }
    
    public static void console(String str)
    {
    	System.out.println(str);
    }
}
