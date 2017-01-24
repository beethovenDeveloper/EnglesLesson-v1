
import java.awt.*;
import javax.swing.*;
public class RunApplicatin {
    public static void main(String[] args)
    {
    	MFrame frame=new MFrame();
    	frame.show();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MFrame extends JFrame
{
	public MFrame()
	{
		setSize(1200,500);
		Container cont=getContentPane();
		MPanel panel=new MPanel();
		cont.add(panel);
		
	}
}
