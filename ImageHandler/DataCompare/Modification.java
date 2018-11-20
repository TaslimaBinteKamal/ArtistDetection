package dataCompare;

import java.io.IOException;

public class Modification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		MinMaxData mm = new MinMaxData();
		try {
			mm.creatingMinMaxDataset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		/*EdgePercentage ed = new EdgePercentage();
		try {
			ed.calculateEdgePercentage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Dataset ds = new Dataset();
		try {
			
			ds.creatingDataset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
