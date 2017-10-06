package solver;

import java.util.ArrayList;
import java.util.Collections;

public class NeighbourhoodCreator {
	public NeighbourhoodCreator(){}
	
	
	public static ArrayList<ArrayList<Job>> Insertion(ArrayList<Job> sol){
		ArrayList<ArrayList<Job>> neighbour = new ArrayList<ArrayList<Job>>();
		
		for (int i = 0; i < sol.size();i++){
			for (int j = 0; j < sol.size();j++){
				if (i != j) {
				ArrayList<Job> toadd = (ArrayList<Job>) sol.clone();
				Job n = sol.get(i);
				toadd.remove(i);
				toadd.add(j,n);
				if (!neighbour.contains(toadd))
				neighbour.add(toadd);
			}
		}
		}
		
		return neighbour;}
	
	public static ArrayList<ArrayList<Job>> Swap(ArrayList<Job> sol){
		ArrayList<ArrayList<Job>> neighbour = new ArrayList<ArrayList<Job>>();
		for (int i = 0; i < sol.size();i++){
			for (int j = i; j <sol.size();j++){
				if (i!= j){
					ArrayList<Job> toadd = (ArrayList<Job>) sol.clone();
					Collections.swap(toadd, i, j);
					neighbour.add(toadd);
					
				}
			}
		}
		
		
		return neighbour;
	}
	
	public static ArrayList<ArrayList<Job>> Echange(ArrayList<Job> sol){
		ArrayList<ArrayList<Job>> neighbour = new ArrayList<ArrayList<Job>>();
		for (int i = 0; i < sol.size()-1;i++){
					ArrayList<Job> toadd = (ArrayList<Job>) sol.clone();
					Collections.swap(toadd, i, i+1);
					neighbour.add(toadd);
			}
		
		
		return neighbour;
	}
		
	public static ArrayList<ArrayList<Job>> Nghbrhd(char type, ArrayList<Job> sol){
	     switch (type) {
         case 'I': return NeighbourhoodCreator.Insertion(sol);
         case 'S':return NeighbourhoodCreator.Swap(sol);
         case 'E':return NeighbourhoodCreator.Echange(sol);
         default: return null;
	     }
         
		
	}
	
	public static void main(String [] args){

		}
		
	}
	


