import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhotoMagic {
	
	public static Picture transform(Picture pic, LFSR lfsr)
	{
		int firstRed, finalRed;
		int firstGreen, finalGreen;
		int firstBlue, finalBlue;
		
		for(int col = 0; col < pic.height(); col++)
		{
			for(int row = 0; row < pic.width(); row++)
			{
				firstRed = pic.get(col, row).getRed();
				firstGreen = pic.get(col, row).getGreen();
				firstBlue = pic.get(col, row).getBlue();
				/*finalRed = lfsr.generate(8) * firstRed;
				finalGreen = lfsr.generate(8) * firstGreen;
				finalBlue = lfsr.generate(8) * firstBlue;*/
				finalRed = lfsr.generate(8);
				finalGreen = lfsr.generate(8);
				finalBlue = lfsr.generate(8);
				Color c = new Color(finalRed, finalGreen, finalBlue);
				pic.set(col, row, c);
			}
		}
		return pic;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File ("pipe.png");
		Picture pic = new Picture(file);
		pic.show();
		LFSR newlsfr = new LFSR("01101000010100010000", 16);
		PhotoMagic pm = new PhotoMagic();
		Picture newPic = pm.transform(pic, newlsfr);
		newPic.show();
		
	}

}
