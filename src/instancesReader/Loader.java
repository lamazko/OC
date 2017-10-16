package instancesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import solver.Job;

public class Loader {

	private static final String FILENAME = "wt100.txt";
	
	public static Job[][] readF(int InstanceSize, int InstanceNumber){
		int[][][] data = new int[InstanceNumber][InstanceSize][3];
		Job[][] jobs = new Job[InstanceNumber][InstanceSize];
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
		 for (int v = 0; v < InstanceNumber; v++){
			for (int i = 0; i < InstanceSize/20 ;i++){
				String s = br.readLine();

				String[] ssplited = s.split("\\s+");
				for (int j= 0; j < 20; j++){
					 data[v][i*20+j][0] = Integer.parseUnsignedInt(ssplited[j+1]);
				}
			}
			
			for (int i = 0; i < InstanceSize/20 ;i++){
				String s = br.readLine();
				String[] ssplited = s.split("\\s+");
				for (int j= 0; j < 20; j++){
					data[v][i*20+j][1] = Integer.parseUnsignedInt(ssplited[j+1]);
				}
			}
			for (int i = 0; i < InstanceSize/20 ;i++){
				String s = br.readLine();
				String[] ssplited = s.split("\\s+");
				for (int j= 0; j < 20; j++){
					data[v][i*20+j][2] = Integer.parseUnsignedInt(ssplited[j+1]);
				}
			}
		 for (int i = 0; i < InstanceNumber;i++){
			 for (int j = 0; j < InstanceSize;j++){
				 jobs[i][j] = new Job(data[i][j]);
			 }
		 }
		 }
			
		}
		catch(Exception e){		System.out.println("nd");}
		return jobs;
	}
	
			
}
