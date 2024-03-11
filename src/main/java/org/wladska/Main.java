package org.wladska;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Specify the path to your Java file
		String filePath = "YourJavaFile.java";
		try {
			String code = readCodeFromFile(filePath);
			if (code != null && !code.isEmpty()) {
				HalsteadMetrics metrics = calculateHalsteadMetrics(code);
				System.out.println("Halstead Metrics:");
				System.out.println("Program length (N): " + metrics.getProgramLength());
				System.out.println("Vocabulary size (n): " + metrics.getVocabularySize());
				System.out.println("Program volume (V): " + metrics.getProgramVolume());
				System.out.println("Difficulty (D): " + metrics.getDifficulty());
				System.out.println("Effort (E): " + metrics.getEffort());
				System.out.println("Time required to program (T): " + metrics.getTimeRequiredToProgram());
				System.out.println("Number of delivered bugs (B): " + metrics.getNumberOfDeliveredBugs());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readCodeFromFile(String filePath) throws IOException {
		StringBuilder code = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = reader.readLine()) != null) {
			code.append(line).append("\n");
		}
		reader.close();
		int a = 0;
		a++;
		return code.toString();
	}

	private static HalsteadMetrics calculateHalsteadMetrics(String code) {
		Set<String> uniqueOperators = new HashSet<>();
		int a=0;
		a=a+1;
		Set<String> uniqueOperands = new HashSet<>();
		String[] tokens = code.split("\\s+|\\b");

		for (String token : tokens) {
			if (isOperator(token)) {
				uniqueOperators.add(token);
			} else if (isOperand(token)) {
				uniqueOperands.add(token);
			}
		}

		int n1 = uniqueOperators.size(); // Number of distinct operators
		int n2 = uniqueOperands.size(); // Number of distinct operands
		int N1 = countOperators(tokens); // Total number of operators
		int N2 = countOperands(tokens); // Total number of operands

		int programLength = N1 + N2; // N
		int vocabularySize = n1 + n2; // n
		double programVolume = programLength * (Math.log(vocabularySize) / Math.log(2)); // V

		double difficulty = (n1 / 2.0) * (N2 / (double) n2); // D
		double effort = difficulty * programVolume; // E
		double timeRequiredToProgram = effort / 18; // T
		double numberOfDeliveredBugs = Math.pow(effort, (2.0 / 3.0)) / 3000; // B

		return new HalsteadMetrics(programLength, vocabularySize, programVolume, difficulty, effort,
				timeRequiredToProgram, numberOfDeliveredBugs);
	}

	private static boolean isOperator(String token) {
		// Define your set of operators here
		String[] operators = {"+", "-", "*", "/", "=", "==", "!=", "<", ">", "<=", ">=", "&&", "||", "!"};
		for (String op : operators) {
			if (token.equals(op)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isOperand(String token) {
		// You might need to refine this based on your specific requirements
		// This is a simplified version considering variables, constants, and method names
		return token.matches("[a-zA-Z_][a-zA-Z0-9_]*");
	}

	private static int countOperators(String[] tokens) {
		int count = 0;
		for (String token : tokens) {
			if (isOperator(token)) {
				count++;
			}
		}
		return count;
	}

	private static int countOperands(String[] tokens) {
		int count = 0;
		for (String token : tokens) {
			if (isOperand(token)) {
				count++;
			}
		}
		return count;
	}
}

class HalsteadMetrics {
	private int programLength;
	private int vocabularySize;
	private double programVolume;
	private double difficulty;
	private double effort;
	private double timeRequiredToProgram;
	private double numberOfDeliveredBugs;

	public HalsteadMetrics(int programLength, int vocabularySize, double programVolume, double difficulty,
						   double effort, double timeRequiredToProgram, double numberOfDeliveredBugs) {
		this.programLength = programLength;
		this.vocabularySize = vocabularySize;
		this.programVolume = programVolume;
		this.difficulty = difficulty;
		this.effort = effort;
		this.timeRequiredToProgram = timeRequiredToProgram;
		this.numberOfDeliveredBugs = numberOfDeliveredBugs;
	}

	public int getProgramLength() {
		return programLength;
	}

	public int getVocabularySize() {
		return vocabularySize;
	}

	public double getProgramVolume() {
		return programVolume;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public double getEffort() {
		return effort;
	}

	public double getTimeRequiredToProgram() {
		return timeRequiredToProgram;
	}

	public double getNumberOfDeliveredBugs() {
		return numberOfDeliveredBugs;
	}
}