package solver;

import java.util.ArrayList;

import instancesReader.Loader;

public class NeighbourhoodSolver {
	Job[][] data;
	
	public NeighbourhoodSolver(Job[][] d){this.data = d;}

	
	public int solve(String InitSol, char DescentType,char NeighbourhoodType,int InstanceNumber){
		HeuristicSolver s = new HeuristicSolver(data);
		ArrayList<Job> CurSol = s.HeurSolve(InitSol, InstanceNumber);
		System.out.println(CurSol.size());
		Tools t = new Tools();
		int CurScore = t.score(CurSol);
		System.out.println(CurScore);
		boolean found = true;
		int nbr = 0;
		while (found){
			found = false;
		ArrayList<ArrayList<Job>> voisins = NeighbourhoodCreator.Nghbrhd(NeighbourhoodType, CurSol);
		ArrayList<Job> newSol =  t.BFimprovementS(CurScore, voisins, DescentType);
		System.out.println("test1");
		System.out.println(newSol == null);
		int newScore = t.score(newSol);
		System.out.println(newScore);

		if (newScore < CurScore){
			System.out.println(newScore);
			found = true;
			CurScore = newScore;
			CurSol = newSol;
		}
		
	}
		System.out.println("finished");
		return CurScore;
	}
	
	public static void main(String [] args){
		NeighbourhoodSolver s = new NeighbourhoodSolver(Loader.readF(100,10));
		s.solve("Rand", 'B', 'S', 5);

	}
	
}
