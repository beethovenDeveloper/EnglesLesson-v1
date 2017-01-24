import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;

import javax.swing.*;
public class MPanel extends JPanel{
	List<Component> comList=new LinkedList<Component>();
	Word word=new Word();
	JLabel label;
	int allWord=0;
	int trueWord=0;
	int falseWord=0;
	JLabel lableFalse,lableTrue,lableAll;
    public MPanel()
    {

    	WorkFile.createList();
    	Act act=new Act();
    	setLayout(null);
    	createTextField(20,50,"rus word","rusWord",false);
    	createTextField(20,150,"eng word","engWord",true);
        createTextField(20,250,"proverka","checkWord",false);
        createButton(20,350,"next word",act);
        createButton(290,350,"check word",act);
        createButton(560,350,"view true word",act);
        createListComponent();
        
        lableAll=new JLabel("all word -   "+allWord);
        lableAll.setSize(100,30);
        lableAll.setLocation(850,350);
        add(lableAll);
        lableTrue=new JLabel("true word -  "+trueWord);
        lableTrue.setSize(100,30);
        lableTrue.setLocation(850,380);
        add(lableTrue);
        lableFalse=new JLabel("false word - "+falseWord);
        lableFalse.setSize(100,30);
        lableFalse.setLocation(850,410);
        add(lableFalse);
         
    }
    
    
    
    
    public void createTextField(int x,int y,String name,String nameTextField,boolean edit)
    {
    	int sizeTextLabel=24;
    	int sizeTextField=30;
    	Properties property = new Properties();
    	try
    	{
    	      	FileInputStream im=new FileInputStream("c:/main.properties");
    	      	property.load(im);
    	      	sizeTextField=Integer.parseInt(property.getProperty("text.size"));
    	}catch(Exception e)
    	{
    		System.out.println("eror read file property");
    	}
    	
    	Font font1=new Font("TimesRoman", Font.BOLD,   24);
    	Font font2=new Font("TimesRoman", Font.BOLD,   sizeTextField);
    	JLabel label=new JLabel(name);
    	label.setFont(font1);
    	label.setSize(1150,30);
    	label.setLocation(x,y);
    	JTextField textField=new JTextField();
        textField.setFocusable(edit);
    	textField.setEditable(edit);
    	textField.setFont(font2);
    	textField.setLocation(x,y+40);
    	textField.setSize(1150,50);
    	
    	textField.setName(nameTextField);
    	add(label);
    	add(textField);
    }
    public void createButton(int x,int y,String name,ActionListener actionListener)
    {
    	JButton button=new JButton(name);
    	button.setSize(250,100);
    	button.setLocation(x,y);
    	button.addActionListener(actionListener);
    	add(button);
    }
    
    class Act implements ActionListener
    {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
                String s=e.paramString();
                StringTokenizer to=new StringTokenizer(s,",");
                to.nextToken();
                String sMain=to.nextToken().substring(4);
                JTextField f1=(JTextField)comList.get(0);
                JTextField f2=(JTextField)comList.get(1);
                JTextField f3=(JTextField)comList.get(2);
                if(sMain.equals("next word"))
                {
        			word=WorkFile.getWords();
        			f1.setText(word.getRusWord());
        			f2.setText("");
        			f2.setBackground(Color.white);
        			f3.setText("");
        			f3.setBackground(Color.white);
        			allWord++;
        			lableAll.setText("all word -   "+allWord);
                } else if(sMain.equals("check word"))
                {
                     if(f2.getText().equals(word.getEngWord())){
                    	 f2.setBackground(Color.green);
                    	  trueWord++;
                    	 lableTrue.setText("true word -  "+trueWord);
                     }
                     else
                     {
                    	 f2.setBackground(Color.red);
                    	 falseWord++;
                    	 lableFalse.setText("false word - "+falseWord);
                     }
                } else if(sMain.equals("view true word"))
                {
                	f3.setText(word.getEngWord());
                }
    	}
    }
    
    public void createListComponent()
    {
    	 Component[] component=getComponents();
         for(Component c:component)
         {
             	if(((""+c.getClass()).substring(18)).equals("JTextField"))
             	{
             		comList.add(c);
             	}
         }
    }
}
