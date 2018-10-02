package pkgGame;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SudokuTest {

	/*
	 * @Test public void Sudoku_Test1() {
	 * 
	 * try { Sudoku s1 = new Sudoku(9); } catch (Exception e) {
	 * fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test(expected = Exception.class) public void Sudoku_Test2() throws Exception
	 * {
	 * 
	 * Sudoku s1 = new Sudoku(10);
	 * 
	 * }
	 * 
	 * @Test public void getRegion_Test1() {
	 * 
	 * int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2,
	 * 1 } }; int[] ExpectedRegion = { 3, 4, 1, 2 };
	 * 
	 * // // 1 2 3 4 // 3 4 1 2 // 2 1 4 3 // 4 3 2 1 // // region 0 = 1 2 3 4 //
	 * region 1 = 3 4 1 2
	 * 
	 * int[] region; try { Sudoku s1 = new Sudoku(puzzle);
	 * 
	 * region = s1.getRegion(1); System.out.println(Arrays.toString(region));
	 * assertTrue(Arrays.equals(ExpectedRegion, region));
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void getRegion_Test2() {
	 * 
	 * int[][] puzzle = { { 1, 2, 3, 4 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2,
	 * 1 } }; int[] ExpectedRegion = { 2, 1, 4, 3 };
	 * 
	 * // // 1 2 3 4 // 3 4 1 2 // 2 1 4 3 // 4 3 2 1 // // region at 0,2 = 2 1 4 3
	 * 
	 * int[] region; try { Sudoku s1 = new Sudoku(puzzle);
	 * 
	 * region = s1.getRegion(0,2); System.out.println(Arrays.toString(region));
	 * assertTrue(Arrays.equals(ExpectedRegion, region));
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void Sudoku_test1() { int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9,
	 * 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5,
	 * 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8,
	 * 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4,
	 * 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertTrue(s1.isSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void Sudoku_test2() { int[][] puzzle = { { 5, 5, 5, 6, 7, 8, 9,
	 * 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5,
	 * 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8,
	 * 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4,
	 * 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertFalse(s1.isSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void Sudoku_test3() { int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9,
	 * 1, 2 }, { 5, 7, 2, 1, 9, 5, 3, 4, 8 }, { 5, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5,
	 * 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8,
	 * 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4,
	 * 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertFalse(s1.isSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void Sudoku_test4() { int[][] puzzle = { { 55, 3, 4, 6, 7, 8, 9,
	 * 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5,
	 * 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8,
	 * 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4,
	 * 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertFalse(s1.isSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void PartialSudoku_Test1() { // This test will test a partial
	 * sudoku... a zero in [0,0]... everything else works // but the first element
	 * in the puzzle is zero
	 * 
	 * int[][] puzzle = { { 0, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8
	 * }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6,
	 * 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8,
	 * 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertTrue(s1.isPartialSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 * 
	 * @Test public void PartialSudoku_Test2() { // This test will test a partial
	 * sudoku... // Everything zero, but there's a duplciate value in the region
	 * (not row/column)
	 * 
	 * 
	 * int[][] puzzle = { { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0, 0
	 * }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0,
	 * 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0,
	 * 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertFalse(s1.isPartialSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); } }
	 * 
	 * @Test public void PartialSudoku_Test3() { // This is a working solution, make
	 * sure it fails isPartiaSudoku()
	 * 
	 * int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8
	 * }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 }, { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6,
	 * 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 }, { 9, 6, 1, 5, 3, 7, 2, 8,
	 * 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	 * 
	 * try { Sudoku s1 = new Sudoku(puzzle); assertFalse(s1.isPartialSudoku());
	 * 
	 * } catch (Exception e) { fail("Test failed to build a Sudoku"); }
	 * 
	 * }
	 */

	@Test
	public void TestRegionNbr() {
		Sudoku s1 = null;

		int[][] puzzle = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };

		int[] Region5 = { 4, 2, 3, 7, 9, 1, 8, 5, 6 };

		try {
			s1 = new Sudoku(puzzle);
		} catch (Exception e) {
			fail("Bad Sudoku");
		}

		assertTrue(Arrays.equals(Region5, s1.getRegion(5)));

	}

	@Test
	public void setRegion_Test1() {

		int[][] puzzle = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] expectedPuzzle = { { 0, 0, 1, 2 }, { 0, 0, 3, 4 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };


		try {
			// This method tests the set region

			Sudoku s1 = new Sudoku(puzzle);
			Sudoku s2 = new Sudoku(expectedPuzzle);
			s1.SetRegion(1);
			
			 
			assertTrue(Arrays.equals(s2.getRow(0), s1.getRow(0)));
			assertTrue(Arrays.equals(s2.getRow(1), s1.getRow(1)));
			assertTrue(Arrays.equals(s2.getRow(2), s1.getRow(2)));
			assertTrue(Arrays.equals(s2.getRow(3), s1.getRow(3)));
		} catch (Exception e) {
			// Auto-generated catch block
			fail("Test failed to build a Sudoku");
			// System.out.println("Test failed to build a Sudoku");
		}

	}
	@Test
	public void setRegion_Test2() {

		int[][] puzzle = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] expectedPuzzle = { { 0, 0, 1, 2 }, { 0, 0, 3, 4 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };


		try {
			// This method tests false for the wrong set region

			Sudoku s1 = new Sudoku(puzzle);
			Sudoku s2 = new Sudoku(expectedPuzzle);
			s1.SetRegion(0);
			
			 
			assertFalse(Arrays.equals(s2.getRow(0), s1.getRow(0)));
			assertFalse(Arrays.equals(s2.getRow(1), s1.getRow(1)));
			assertTrue(Arrays.equals(s2.getRow(2), s1.getRow(2)));
			assertTrue(Arrays.equals(s2.getRow(3), s1.getRow(3)));
		} catch (Exception e) {
			// Auto-generated catch block
			fail("Test failed to build a Sudoku");
			// System.out.println("Test failed to build a Sudoku");
		}

	}

	@Test
	public void getRegionNbr_Test1() {

		// int[][] puzzle = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0,
		// 0 } };
		int[][] expectedPuzzle = { { 0, 0, 1, 2 }, { 0, 0, 3, 4 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		//
		// 1 2 3 4
		// 3 4 1 2
		// 2 1 4 3
		// 4 3 2 1
		//
		// region at 0,2 = 2 1 4 3

		// int[] region;

		try {
			// Method SetRegion = Sudoku.SetRegion(1).getDeclaredMethod(void);
			// SetRegion.setAccessible(true);
			// SetRegion.invoke(1); //prints "Method3"

			// Sudoku s1 = new Sudoku(puzzle);
			Sudoku s1 = new Sudoku(expectedPuzzle);
			/*
			 * System.out.println(Arrays.toString(s1.getRow(0)));
			 * System.out.println(Arrays.toString(s1.getRow(1)));
			 * System.out.println(Arrays.toString(s1.getRow(2)));
			 * System.out.println(Arrays.toString(s1.getRow(3))); System.out.print("\n");
			 * System.out.println(Arrays.toString(s2.getRow(0)));
			 * System.out.println(Arrays.toString(s2.getRow(1)));
			 * System.out.println(Arrays.toString(s2.getRow(2)));
			 * System.out.println(Arrays.toString(s2.getRow(3)));
			 */
			assertTrue(s1.getRegionNbr(3, 0) == 1);
			// assertTrue(Arrays.equals(s2.getRow(1), s1.getRow(1)));
			// assertTrue(Arrays.equals(s2.getRow(2), s1.getRow(2)));
			// assertTrue(Arrays.equals(s2.getRow(3), s1.getRow(3)));
		} catch (Exception e) {
			// Auto-generated catch block
			fail("Test failed to build a Sudoku");
			// System.out.println("Test failed to build a Sudoku");
		}

	}

	@Test
	public void ShuffleArray_Test1() {
		// This tests that SuffleArray returns same values 1000 times



		try {

			Method privateStringMethod = Sudoku.class.getDeclaredMethod("ShuffleArray", int[].class);
			privateStringMethod.setAccessible(true);
			
			for (int tst=0; tst< 1000; tst++ ) {
				int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8 ,9};
				int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8 ,9};
				Sudoku.ShuffleArray(array1);
				// Uncomment to see random arrays
				//System.out.println(Arrays.toString(array1));
				Arrays.sort(array1);
				assertTrue(Arrays.equals(array1, array2));
			}
			
		} 
		catch (Exception e) {
			// Auto-generated catch block
			fail("Test failed to build a Sudoku");
			//System.out.println("Test failed to build a Sudoku");
		}

	}
	@Test
	public void FillDiagonalRegions_Test1() {
		// This test only prints out a puzzle, and only prints if you uncomment the print line
		//it doesn't test because the numbers are random
		 int[][] puzzle = { { 0, 0, 0, 0, 0, 0, 0,0 ,0 },{ 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 }, { 0, 0, 0, 0, 0, 0, 0,0 ,0 } };

		try {



			Sudoku s1 = new Sudoku(puzzle);
			s1.FillDiagonalRegions();
			//s1.PrintPuzzle(); //Uncomment to reveal print of puzzle


			assertTrue(true);

		} catch (Exception e) {
			// Auto-generated catch block
			fail("Test failed to build a Sudoku");
			// System.out.println("Test failed to build a Sudoku");
		}

	}
	
	
}
