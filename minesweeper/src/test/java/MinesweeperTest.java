import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class MinesweeperTest {
	
	private Minesweeper ms = null;
	private int fieldNumber = 0;
	
	@Before
	public void initialise() {
		
		String[][] inputGround = {
			{"*", ".", ".", "."},
			{".", ".", ".", "."},
			{".", "*", ".", "."},
			{".", ".", ".", "."}
		};
		
		ms = new Minesweeper(inputGround, 1, 0, 0, 3, 3);
	}
	
	@Test
	public void check_output_result() {
		
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
	
	@Test
	public void check_output_name_of_field() {
		fieldNumber = ms.getFieldNumber();
		
		String fieldName = ms.createFieldName(fieldNumber);
		
		assertThat(fieldName, is("Field #1"));
	}
	
}
