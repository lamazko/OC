package solver;

import java.util.ArrayList;

public class NeighbourhoodSolver {
	Job[][] data;
	
	public NeighbourhoodSolver(Job[][] d){this.data = d;}

	
	public int solve(String InitSol, char DescentType,char NeighbourhoodType,int InstanceNumber){
		HeuristicSolver s = new HeuristicSolver(data);
		ArrayList<Job> CurSol = s.HeurSolve(InitSol, InstanceNumber);
		Tools t = new Tools();
		int CurScore = t.score(CurSol);
		boolean found = true;
		while (found){
			found = false;
		
		ArrayList<ArrayList<Job>> voisins = NeighbourhoodCreator.Nghbrhd(NeighbourhoodType, CurSol);
		t.BFimprovementS(CurScore, voisins, DescentType);
		
	}
		return CurScore;
	}
	
}
