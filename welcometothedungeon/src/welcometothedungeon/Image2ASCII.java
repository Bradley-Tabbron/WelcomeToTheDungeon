package welcometothedungeon;

import java.awt.*;
import java.awt.image.*; 
import javax.imageio.*; 
import java.io.*; 
public class Image2ASCII {
	 BufferedImage bImage = null;     
	 int imageWidth = 0;     
	 int imageHeight = 0; 
	 int [] [] greyVals;
	 String ramp="@%#*+=-:. ";
	 String ramp1=" .:-=+*#%@";
	 void print() {
		
	 for (int y=0; y<imageWidth; y+=2)
		{
			for (int x=0; x<imageHeight; x++)
 		{
				int shade =10*greyVals[x][y]/256;
				char thischar =ramp.charAt(shade);
				System.out.print(thischar);
				
						}
			System.out.println();
		}
	 
	 }
	 
	 void LoadImage( String fileName )     {        
	    	try       
	    	{         
	    		bImage = ImageIO.read( new File(fileName) ); 
	    		imageWidth = bImage.getWidth();  
	    		imageHeight = bImage.getHeight();
	    		greyVals= new int[imageHeight][imageWidth];
	    		
	    		for (int x=0; x<imageHeight; x++)
	    		{
	    			for (int y=0; y<imageWidth; y++)
		    		{
	    				Color pixel = new Color( bImage.getRGB( y, x ) ); 
	    				int red = pixel.getRed(); 
	    				int green = pixel.getGreen(); 
	    				int blue = pixel.getBlue();
	    				int grey = ( red + 2*green + blue ) /4; 
	    				greyVals[y][x] =grey;	
	    						}
	    		}
	    	}        
	    	catch (Exception e )         {  
	    		System.out.println("could not open image file "+fileName);         
	    		}   
	    	} 

}