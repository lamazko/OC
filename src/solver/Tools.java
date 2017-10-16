package solver;

import java.util.ArrayList;

public class Tools {
	
	public Tools(){}
	
	public int tardiness(int C, int d){
		return Math.max(C-d,0);
	}
	
	public int mdd(int C, int d, int p){
		return Math.max(C+p,d);
	}
	
	public int score (Job[] data, ArrayList<Integer> solution){
		int currenttime = 0;
		int currentscore = 0;
		int processtime ;
		int weight;
		int duetime;
		for (Integer i: solution){
			processtime = data[i].Pt;
			weight = data[i].weight;
			duetime = data[i].Dt;
			currentscore += this.tardiness(currenttime+processtime,duetime) * weight;
			currenttime += processtime;
		}
		return currentscore;
	}
	
   public int score (ArrayList<Job> solution){
	   int currenttime = 0;
		int currentscore = 0;
		int processtime ;
		int weight;
		int duetime;
		for (Job i: solution){
			processtime = i.Pt;
			weight = i.weight;
			duetime = i.Dt;
			currentscore += this.tardiness(currenttime+processtime,duetime) * weight;
			currenttime += processtime;
		}
		return currentscore;
	}
   
   public ArrayList<Integer> firstimprovement (int current, Job[] data, ArrayList<ArrayList<Integer>> solutions){
	   for (ArrayList<Integer> l: solutions){
		   if (this.score(data, l) < current)
			   return l;
	   }
	return null;
	   
   }
   
   public ArrayList<Job> firstimprovementS (int current, ArrayList<ArrayList<Job>> solutions){
	   for (ArrayList<Job> l: solutions){
		   if (this.score(l) < current)
			   return l;
	   }
	return null;
	   
   }
   
   public ArrayList<Integer> bestimprovement(int current, Job[] data, ArrayList<ArrayList<Integer>> solutions){
	   int bestscore = current;
	   ArrayList<Integer> bestsol = null;
	   for (ArrayList<Integer> l: solutions){
		   int score = this.score(data,l);
		   if ( score < bestscore)
			   bestscore = score;
		   	   bestsol = l;
	   }
	return bestsol;
	   
   }
   
   
   public ArrayList<Job> bestimprovementS(int current, ArrayList<ArrayList<Job>> solutions){
	   int bestscore = current;
	   ArrayList<Job> bestsol = null;
	   for (ArrayList<Job> l: solutions){
		   int score = this.score(l);
		   if ( score < bestscore){
			   bestscore = score;
		   	   bestsol = l;
		   }
	   }
	return bestsol;
	   
   }
   
   public ArrayList<Job> BFimprovementS(int current, ArrayList<ArrayList<Job>> solutions, char type){
	   switch (type) {
       case 'B': return this.bestimprovementS(current, solutions);
       case 'F': return this.firstimprovementS(current, solutions);
	   }
       return null;
	   
               
	   
   }
   
   public static void printsol(ArrayList<Integer> sol){
	   for (Integer i: sol){
		   System.out.print(" "+i);
	   }
	   System.out.println();
	   
   }
	   
   }


