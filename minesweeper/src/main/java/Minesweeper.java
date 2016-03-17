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
	
	public int getAdjacentValue(int m, int n) {
		
		if (m == boundMinM) {
			if(n == boundMinN) {
				this.getValueWhenBoundMinMAndBoundMinN(m, n);
			}
			if ((n > boundMinN) && (n < boundMaxN)) {
				this.getValueWhenBoundMinMAndNotBoundN(m, n);
			}
			if (n == boundMaxN) {
				this.getValueWhenBoundMinMAndBoundMaxN(m, n);
			}
		} else if ((boundMinM < m) && (m < boundMaxM)) {
			
			if(n == boundMinN) {
				this.getValueWhenNotBoundMAndBoundMinN(m,n);
			}
			if ((n > boundMinN) && (n < boundMaxN)) {
				this.getValueWhenNotBoundMAndNotBoundN(m,n);
			}
			if (n == boundMaxN) {
				this.getValueWhenNotBoundMAndBoundMaxN(m,n);
			}
		} else if (boundMaxM == m) {
			if(n == boundMinN) {
				this.getValueWhenBoundMaxMAndBoundMinN(m,n);
			}
			if ((n > boundMinN) && (n < boundMaxN)) {
				this.getValueWhenBoundMaxMAndNotBoundN(m,n);
			}
			if (n == boundMaxN) {
				this.getValueWhenBoundMaxMAndBoundMaxN(m,n);
			}
		}
		return adjacentValue;
	}
	
	private int getValueWhenBoundMaxMAndBoundMaxN(int m, int n) {
		adjacentValue = 0;
		if (inputGround[m-1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		return adjacentValue;
	}
	
	private int getValueWhenBoundMaxMAndNotBoundN(int m, int n) {
		adjacentValue = 0;
		if (inputGround[m-1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		return adjacentValue;
	}

	private int getValueWhenBoundMaxMAndBoundMinN(int m, int n) {
		adjacentValue = 0;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		return adjacentValue;
		
	}

	private int getValueWhenNotBoundMAndBoundMaxN(int m, int n) {

		adjacentValue = 0;
		if (inputGround[m-1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		
		return adjacentValue;
		
	}

	private int getValueWhenNotBoundMAndNotBoundN(int m, int n) {
		adjacentValue = 0;
		if (inputGround[m-1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n+1] == STAR)
			adjacentValue++;
		
		return adjacentValue;
		
	}

	private int getValueWhenBoundMinMAndBoundMinN(int m, int n) {
		adjacentValue = 0;
		
		if ((inputGround[m+1][n] == STAR)
			|| (inputGround[m+1][n+1] == STAR)
			|| (inputGround[m][n+1] == STAR)) {
			adjacentValue++;
		}
		return adjacentValue;
	}
	
	private int getValueWhenBoundMinMAndNotBoundN(int m, int n) {
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
	
	private int getValueWhenBoundMinMAndBoundMaxN(int m, int n) {
		adjacentValue = 0;

		if (inputGround[m][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n-1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		
		return adjacentValue;
	}
	private int getValueWhenNotBoundMAndBoundMinN(int m, int n) {
		adjacentValue = 0;
		if (inputGround[m-1][n] == STAR)
			adjacentValue++;
		if (inputGround[m-1][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m][n+1] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n] == STAR)
			adjacentValue++;
		if (inputGround[m+1][n+1] == STAR)
			adjacentValue++;
		return adjacentValue;
	}
}
