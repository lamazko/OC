package solver;

import java.util.Comparator;

public class Job implements Comparable {
 int Dt;
 int weight;
 int Pt;
 int mdd;
 public Job (int[] job){
	 this.Dt = job[2];
	 this.weight = job[1];
	 this.Pt = job[0];
 }
 
 public String toString(){
	
	return "dt: "+this.Dt;
 }

@Override
public int compareTo(Object job2) {
	
	   if (  this.mdd > ((Job) job2).mdd)   
		return 1;
	   if (  this.mdd < ((Job) job2).mdd  )   
		return -1;
	return 0;
	/*
	   if (  this.Dt > ((Job) job2).Dt  )   
		return 1;
	   if (  this.Dt < ((Job) job2).Dt  )   
		return -1;
	return 0;
	*/	
}
}
