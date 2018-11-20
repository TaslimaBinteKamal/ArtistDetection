package dataCompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class MinMaxData {
	String edgeFolderPath= "D:\\ShaansDrawer\\Semester6\\AI\\Image datset 2\\HashemKhan";
	String pixelFolderPath ="D:\\ShaansDrawer\\Semester6\\AI\\Image datset 2\\HashemKhan\\HK_allPixelData";
	File file;
	BufferedReader br;
	String line = "";
    String cvsSplitBy = ",";
    PixelStore minvalue;
    PixelStore maxvalue;
    
    public void creatingMinMaxDataset() throws IOException {
    	file = new File(pixelFolderPath);
		FileWriter csvFile = new FileWriter(new File(edgeFolderPath+"\\pixelHashemKhanData.csv"));
		CSVWriter writer = new CSVWriter(csvFile);
		String[] header= {"ImageName","MaxRed","MinRed","MaxGreen","MinGreen","MaxBlue","MinBlue","MaxHue","MinHue","MaxSat","MinSat","MaxBright","MinBright"};
		writer.writeNext(header);
		
		for(File f1:file.listFiles()) {
			
			minvalue = new PixelStore();
			maxvalue = new PixelStore();
			
			minvalue.red=1000;
			minvalue.green=1000;
			minvalue.blue=1000;
			minvalue.hue=1000;
			minvalue.sat=1000;
			minvalue.bright=1000;
			
			maxvalue.red=-1000;
			maxvalue.blue=-1000;
			maxvalue.green=-1000;
			maxvalue.hue=-1000;
			maxvalue.sat=-1000;
			maxvalue.bright=-1000;
			
			String sourceFile = f1.getName();
			br = new BufferedReader(new FileReader(pixelFolderPath+"\\"+sourceFile));
			int count =0;
			while((line = br.readLine()) != null) {
				if(count!=0) {
					String[] pixelData=line.split(cvsSplitBy);
					
					double dred=Double.parseDouble(pixelData[2].substring(1, pixelData[2].length() - 1));
					double dgreen=Double.parseDouble(pixelData[3].substring(1, pixelData[3].length() - 1));
				    double dblue=Double.parseDouble(pixelData[4].substring(1, pixelData[4].length() - 1));
				    double dhue=Double.parseDouble(pixelData[5].substring(1, pixelData[5].length() - 1));
				    double dsat=Double.parseDouble(pixelData[6].substring(1, pixelData[6].length() - 1));
				    double dbr=Double.parseDouble(pixelData[7].substring(1, pixelData[7].length() - 1));
				    
				   if(dred < minvalue.red) minvalue.red=dred;
				   if(dred > maxvalue.red) maxvalue.red=dred;
				   
				   if(dblue < minvalue.blue) minvalue.blue=dblue;
				   if(dblue > maxvalue.blue) maxvalue.blue=dblue;
				   
				   if(dgreen < minvalue.green) minvalue.green=dgreen;
				   if(dgreen > maxvalue.green) maxvalue.green=dgreen;
				   
				   if(dhue < minvalue.hue) minvalue.hue=dhue;
				   if(dhue > maxvalue.hue) maxvalue.hue=dhue;
				   
				   if(dsat < minvalue.sat) minvalue.sat=dsat;
				   if(dsat > maxvalue.sat) maxvalue.sat=dsat;
				   
				   if(dbr < minvalue.bright) minvalue.bright=dbr;
				   if(dbr > maxvalue.bright) maxvalue.bright=dbr;
				 
				}
				else {
					count++;
				}
			}
			
			
			String stminRed = Double.toString(minvalue.red);
			String stminGreen = Double.toString(minvalue.green);
			String stminBlue = Double.toString(minvalue.blue);
			String stminHue = Double.toString(minvalue.hue);
			String stminSat = Double.toString(minvalue.sat);
			String stminBright = Double.toString(minvalue.bright);
			
			String stmaxRed = Double.toString(maxvalue.red);
			String stmaxGreen = Double.toString(maxvalue.green);
			String stmaxBlue = Double.toString(maxvalue.blue);
			String stmaxHue = Double.toString(maxvalue.hue);
			String stmaxSat = Double.toString(maxvalue.sat);
			String stmaxBright = Double.toString(maxvalue.bright);
			String[] VALUES = {sourceFile,stmaxRed,stminRed,stmaxGreen,stminGreen,stmaxBlue,stminBlue,stmaxHue,stminHue,stmaxSat,stminSat,stmaxBright,stminBright};
			writer.writeNext(VALUES);
			
		}
		writer.close();
    }
}
