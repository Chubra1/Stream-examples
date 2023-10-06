import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class Streamstest1 {
//@Test
	//Count the number of names starting with A on the list
	
		public void regular ()
		{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alek");
		names.add("Darko");
		names.add("Marko");
		names.add("Ivan");
		names.add("Bojana");
		int count=0;
		for(int i=0;i<names.size();i++);
		{
		  String actual= names.get(count);
		  if(actual.startsWith("A"))
		  {
			  count++;
		  }
	    }
		
		System.out.println(count);

	}
    //@Test
    public void Streamfilter()
    {
    	ArrayList<String> names = new ArrayList<String>();
		names.add("Alek");
		names.add("Darko");
		names.add("Marko");
		names.add("Anica");
		names.add("Bojana");
		
		Long c= names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		Long d= Stream.of("Alek","Darko","Marko","Anica","Bojana").filter(s->
		{
		s.startsWith("A");
		return true;
		}).count();
		System.out.println(d);
		//print all the names more than 4 letter
        //names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    
    
    }

   //@Test
    public void StreamMap()
    {
    	ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Darko");
		names.add("women");
		
    	
    	//print the names which has last letter "a" with Uppercase
    	Stream.of("Alek","Darko","Marko","Anica","Bojana").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
    			.forEach(s->System.out.println(s));
    	//print the names which have first letter "a" with uppercase  and sorted
    
    	List<String> names1 =Arrays.asList("Alek","Darko","Marko","Anica","Bojana");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s)); 
        //merging to different lists
    	 Stream<String>newStream =Streams.concat(names.stream(), names1.stream());
    	// newStream.sorted().forEach(s->System.out.println(s));
    	
    	boolean flag= newStream.allMatch(s->s.equalsIgnoreCase("Alek"));
    	System.out.println(flag);
    	Assert.assertTrue(flag);
    	
    	
    	
    }

   @Test
    
    public void StreamCollect()

    {
    	List<String> ls= Stream.of("Alek","Darko","Marko","Anica","Bojana").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
    	.collect(Collectors.toList());
    	//System.out.println(ls.get(0));
    	
    	List<Integer> values =Arrays.asList(3,2,2,7,5,1,9,7);
    	//print unique numbers
    	//sort the array
    	
    	//values.stream().distinct().forEach(s->System.out.println(s));
    	List<Integer> li= values.stream().distinct().sorted().collect(Collectors.toList());
    	System.out.println(li.get(2));
    	
    	
    }
}

