package solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeuristicSolver {
	Job[][] data;
	
	public HeuristicSolver(Job[][] d){this.data = d;}
	
	
	public ArrayList<Job> MSortedSol(int InstanceNumber){
	Tools t = new Tools();
	int currenttime = 0;
	ArrayList<Job> res = new ArrayList<Job>();
	ArrayList<Job> solution = new ArrayList<>(Arrays.asList(data[InstanceNumber])); 
	while( !(solution.isEmpty())){
    for (Job j: solution){
    	j.mdd = t.mdd(currenttime, j.Dt, j.Pt);
    }
	Collections.sort(solution);
	res.add(solution.get(0));
	currenttime += solution.get(0).Pt;
	solution.remove(0);
	
	}
	return res;
	}
	
	public ArrayList<Job> SortedSol(int InstanceNumber){
	ArrayList<Job> solution = new ArrayList<>(Arrays.asList(data[InstanceNumber])); 
	System.out.println(solution.toString());
	Collections.sort(solution);
	System.out.println(solution.toString());
	return solution;
}
	
	
	public ArrayList<Job> Rsol(int InstanceNumber){
		ArrayList<Integer> solution = new ArrayList<Integer>();
		for (int i=0;i <(data[InstanceNumber].length);++i){
		solution.add(i);
		}
		Collections.shuffle(solution);
		ArrayList<Job> solutionJob = new ArrayList<>(Arrays.asList(data[InstanceNumber])); 
		for (Integer j: solution){
			solutionJob.add(data[InstanceNumber][j]);
		}
		return solutionJob;
		
	}
	
	public ArrayList<Job> HeurSolve(String type, int InstanceNumber){
		 switch (type) {
         case "Rand": return this.Rsol(InstanceNumber);        			
                 
         case "EDD": return this.SortedSol(InstanceNumber);        			

         case "MDD": return this.MSortedSol(InstanceNumber);        			

		 }
		return null;
	}
	
	
}
