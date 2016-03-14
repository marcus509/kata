public class Minesweeper {
	
	private static String STAR = "*";
	private static String DOT = ".";
	
	private String[][] inputGround = {
			{STAR, DOT, DOT, DOT},
			{DOT, DOT, DOT, DOT},
			{DOT, STAR, DOT, DOT},
			{DOT, DOT, DOT, DOT}
	};

	private int boundMinM = 0;
	private int boundMaxM = 4;
	private int boundMinN = 0;
	private int boundMaxN = 4;
	
	private int adjacentValue = 0;
	
	public Minesweeper(String[][] inputGround, int boundMinM, int boundMinN, int boundMaxN, int boundMaxM) {
		this.inputGround = inputGround;
		this.boundMinN = boundMinN;
		this.boundMinM = boundMinM;
		this.boundMaxN = boundMaxN;
		this.boundMaxM = boundMaxM;
	}
	
	
	private int getValueWhenNEqual0(int m, int n) {
		adjacentValue = 0;
		
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		
		return adjacentValue;
	}
	
	
	private int getValueWhenNGreaterThan0(int m, int n) {
		adjacentValue = 0;
		
		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		
		return adjacentValue;
	}
	
	private int getValueWhenNEqualBoundN(int m, int n) {
		adjacentValue = 0;

		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		
		return adjacentValue;
	}
	
	public int getAdjacentValue(int m, int n) {
		
		if (inputGround[m][n] != STAR) {
			if (m == boundMinM) {
				if(n == 0) {
					this.getValueWhenNEqual0(m, n);
				}
				if ((n > 0) && (n < boundMaxN)) {
					this.getValueWhenNGreaterThan0(m, n);
				}
				if (n == boundMaxN) {
					this.getValueWhenNEqualBoundN(m, n);
				}
			}
		}
		return adjacentValue;
	}
}
