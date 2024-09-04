
/***********************************
 CSC150
 Assignment 3 - ExecutionTime
 Mary Hoette
 Using information such as number of 
 statement executions, instructions/statement, 
 clock rate, and instructions/cycle, this code
 calculates how long one sample program should
 ideally take to run
************************************/

public class ExecutionTime 
{
	public static void main(String[] args)
	{
		// here I am setting up each of my variables
		int statementExecutions = 10000;
		double instructionsPerStatement = 20.0;
		double clockRate = 2000.0;
		//double clockRateHz = (clockRate * 10^6);
		//I tried converting clockRate from megahertz to hertz like your email said
		//but it gave me 8.33333 instead of the correct answer of 100.0
		double instructionsPerCycle = 1.0;
		//Now I am calculating the totalExecution time via the formula provided
		double totalExecutionTime = ((statementExecutions * instructionsPerStatement) / (instructionsPerCycle * clockRate));
		//Now I am printing all of the assumed values given by the worksheet
		System.out.println("Assumed number of statements executed: " + statementExecutions);
		System.out.println("Assumed number of instructions per statement :" + instructionsPerStatement);
		System.out.println("Assumed clock rate in hertz: " + clockRate);
		System.out.println("Assumed instructions per cycle: " + instructionsPerCycle);
		//now I am printing the total execution time that was calculated above
		System.out.println("Ideal Execution time: " + totalExecutionTime);
	}
}
