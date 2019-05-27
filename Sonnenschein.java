import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;


public class Sonnenschein extends Panel
	{
		public Matcher m;
		public Pattern p;
		int[] value = new int[10];
		Color farbe []=new Color[10];

		public Sonnenschein(String args[]) 
		{
			for(int i=0; i < value.length; i++)
			{
			farbe[i]= new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256),128);
			}

			try{

				int i=0;
				URL url = new URL(args[0]); 
    			URLConnection c= url.openConnection();
    			c.connect();
    			InputStream I =c.getInputStream();
				//File f =new File("Sonnenschein.txt");
				String Line;
				Pattern p = Pattern.compile("[0-9]+");
				//BufferedReader br = new BufferedReader(new FileReader(args[0]));
				BufferedReader br = new BufferedReader(new InputStreamReader(I));


				while((Line=br.readLine())!=null)
					{	
						Matcher m = p.matcher(Line);
	

							while(m.find()){

							//System.out.println(Line.substring(m.start(), m.end()));
							value[i]=Integer.parseInt(Line.substring(m.start(), m.end()));
							System.out.println(value[i]);
							i++;
						}
					}
				}catch(Exception e)
					{
						System.out.println(e+ "sorry...1 Datei nicht gefundem. lol. Du bimst 1 spasd ;-)");
					}
				}

				    public void paint(Graphics g)
    				{

        				//Liniendiagramm
        				/*double x=this.getWidth(),y=this.getHeight();
        				g.drawLine(5,5,5,190);
        				g.drawString("Stunden",6,8);
        				g.drawLine(5,190,190,190);
        				g.drawString("Tag",180,191);
        				int width1=5;
        				for(int i=0; i<value.length-1; i++)
        				{
       						g.drawLine(width1, 195-(value[i]*10),width1+25, 195-(value[i+1]*10));
       						width1+=25;*/
        					/*g.drawLine(5,190-(value[0]*10),30, 190-(value[1]*10));
        					g.drawLine(30,190-(value[1]*10),55, 190-(value[2]*10));
							g.drawLine(55,190-(value[2]*10),80, 190-(value[3]*10));
        					g.drawLine(80,190-(value[3]*10),105, 190-(value[4]*10));*/
        					//Typecast (int)(190-(value[i]*10))
        					//
     					//Balkendiagramm
     					double x=this.getWidth(),y=this.getHeight();
        				g.drawLine(5,190,190,190);
        				g.drawString("Tag",6,8);
        				g.drawLine(5,5,5,190);
        				g.drawString("Stunden",180,185);

        				//fillRect(int x, int y, int width, int height)
        				int yvalue=10;
        				for(int i=0; i<value.length-1; i++){
        					g.setColor(farbe[i]);
        					// sp x, sp y , abstände nach unten, länge der balken
        					g.fillRect(5,yvalue, value[i+1]*10,10);
        					yvalue+=20;}

        				//Saeulendiagramm
        				double x=this.getWidth(),y=this.getHeight();
        				g.drawLine(5,5,5,190);
        				g.drawString("Stunden",6,8);
        				g.drawLine(5,190,190,190);
        				g.drawString("Tag",180,185);
        				int width1=5;


        				for(int i=0, j=0; i<value.length; i++)
        				{
        					g.setColor(farbe[i]);
        					// sp x, sp y , breite mit abstand, höhe

        					g.fillRect(5+j, 190-((190*value[i]/100)*10), 190/value.length/2, (190*value[i]/100)*10);
        					j+=190/value.length;
        				}
        			}
        				
				public Dimension getPreferredSize()
				{
					return new Dimension (200,200);
				}

public static void main(String args[])
{
  Frame      F=new Frame("Sonnenschein Diagramm");
  Sonnenschein S=new Sonnenschein(args);
  F.add(S);
  F.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
  F.pack();
  F.setVisible(true);}
}
