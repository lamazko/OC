package solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import instancesReader.Loader;

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
	//System.out.println(solution.toString());
	Collections.sort(solution);
	//System.out.println(solution.toString());
	return solution;
}
	
	
	public ArrayList<Job> Rsol(int InstanceNumber){
		
		ArrayList<Job> solutionJob = new ArrayList<>(Arrays.asList(data[InstanceNumber])); 
		
		Collections.shuffle(solutionJob);
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
	
	public static void main(String [] args){
		HeuristicSolver s = new HeuristicSolver(Loader.readF(100,40));
		Tools t = new Tools();
		ArrayList<Job> sol = s.HeurSolve("Rand", 0);
		System.out.println(s.data[0].length);
		System.out.println(sol.size());
		System.out.println(t.score(sol));
	

	}
	
	
}
