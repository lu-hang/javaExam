package com.jjob.hobby;

public class DriverExam { 

	public static void executeExercise(IExercise exercise) {
		
		Exercise  oneEx = new Exercise();
		try{
		oneEx.start();
		throw new Exception("Waiting to be implemented.");
		//oneEx.execute();
		}
		catch(Exception e)
		{
			oneEx.markNegativePoints();
		}
		finally
		{
			oneEx.end();
		}
		//throw new UnsupportedOperationException("Waiting to be implemented.");
	}

	public static void main(String[] args) {
		DriverExam.executeExercise(new Exercise());
	}
}

class Exercise implements IExercise {
	public void start() { System.out.println("Start"); }
	public void execute() { System.out.println("Execute"); }
	public void markNegativePoints() { System.out.println("MarkNegativePoints"); }
	public void end() { System.out.println("End"); }
}

interface IExercise {
	void start() throws Exception;
	void execute();
	void markNegativePoints();
	void end();
}