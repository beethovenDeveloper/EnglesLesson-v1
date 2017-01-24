import java.io.*;
import java.util.*;

public class WorkFile {
	
	 public static List<Word> word=new LinkedList<Word>();
     public static  Word getWords()
     {
    	 Word superWord=new Word();
    	 int i=word.size();
    	 Random ran=new Random();
    	 int index=ran.nextInt(i);
    	 superWord=word.get(index);
    	 return superWord;
     }
     
     public static void createList()
     {
    	 try
    	 {
    		 BufferedReader reader =new BufferedReader(new FileReader("c:/words.txt"));
    		 String s="";
    		 while((s=reader.readLine())!=null)
    		 {
    			 StringTokenizer tok=new StringTokenizer(s,"\t");
    			 Word word1=new Word();
    			 word1.setEngWord(tok.nextToken());
    			 word1.setRusWord(tok.nextToken());
    			 word1.setLesson(tok.nextToken());
    			 word.add(word1);
    		 }
    	 }catch(Exception e)
    	 {
    		 System.out.println("not file");
    	 }
     }
}
