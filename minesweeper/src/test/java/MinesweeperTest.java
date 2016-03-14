import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperTest {
	@Test
	public void check_output_result() {
		
		String[][] inputGround = {
				{"*", ".", ".", "."},
				{".", ".", ".", "."},
				{".", "*", ".", "."},
				{".", ".", ".", "."}
		};
		
		Minesweeper ms = new Minesweeper(inputGround, 0, 0, 3, 3);
		
		
		assertEquals(0, ms.getAdjacentValue(0, 0));
		assertEquals(1, ms.getAdjacentValue(0, 1));
		assertEquals(0, ms.getAdjacentValue(0, 2));
		assertEquals(0, ms.getAdjacentValue(0, 3));
		
		assertEquals(2, ms.getAdjacentValue(1, 0));
		assertEquals(2, ms.getAdjacentValue(1, 1));
		assertEquals(1, ms.getAdjacentValue(1, 2));
		assertEquals(0, ms.getAdjacentValue(1, 3));
		
		assertEquals(1, ms.getAdjacentValue(2, 0));
		assertEquals(0, ms.getAdjacentValue(2, 1));
		assertEquals(1, ms.getAdjacentValue(2, 2));
		assertEquals(0, ms.getAdjacentValue(2, 3));
		
		assertEquals(1, ms.getAdjacentValue(3, 0));
		assertEquals(1, ms.getAdjacentValue(3, 1));
		assertEquals(1, ms.getAdjacentValue(3, 2));
		assertEquals(0, ms.getAdjacentValue(3, 3));
		
	}
	
}
