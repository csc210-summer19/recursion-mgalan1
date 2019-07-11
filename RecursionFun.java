
// Marisa Galan, CSC 210, Summer 2019
/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Marisa Galan
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String result = "";
		if (n < 1000) {
			result += n;
		} else {
			if (n / 1000 < 1000) {
				if (n % 1000 == 0) {
					result += (n / 1000) + "," + "000";
				} else if (n % 1000 > 0 && n % 1000 < 10) {
					result += (n / 1000) + "," + "00" + (n % 1000);
				} else if (n % 1000 >= 10 && n % 1000 < 100) {
					result += (n / 1000) + "," + "0" + (n % 1000);
				} else {
					result += (n / 1000) + "," + (n % 1000);
				}
			} else {
				if (n % 1000 == 0) {
					result += intWithCommas(n / 1000) + "," + "000";
				} else if (n % 1000 > 0 && n % 1000 < 10) {
					result += intWithCommas(n / 1000) + "," + "00" + (n % 1000);
				} else if (n % 1000 >= 10 && n % 1000 < 100) {
					result += intWithCommas(n / 1000) + "," + "0" + (n % 1000);
				} else {
					result += intWithCommas(n / 1000) + "," + (n % 1000);
				}
			}

		}
		return result;

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArrayHelp(x, 0, x.length);
	}

	private void reverseArrayHelp(int[] x, int index, int len) {
		int temp = 0;
		if (len == 0 || len == 1) {
			return;
		}
		if (index <= len - 1) {
			temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
		}

		reverseArrayHelp(x, index + 1, len - 1);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int maxx = arrayRangeMax(a, a.length);
		int minn = arrayRangeMin(a, a.length);

		return maxx - minn;

	}

	private int arrayRangeMax(int[] a, int len) {
		if (len == 1)
			return a[0];

		return Math.max(a[len - 1], arrayRangeMax(a, len - 1));

	}

	private int arrayRangeMin(int[] a, int len) {
		if (len == 1)
			return a[0];

		return Math.min(a[len - 1], arrayRangeMin(a, len - 1));

	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return isSortedHelp(nums, nums.length);
	}

	private boolean isSortedHelp(int[] nums, int len) {
		if (len == 0 || len == 1) {
			return true;
		}
		if (nums[len - 2] > nums[len - 1]) {
			return false;
		}
		return isSortedHelp(nums, len - 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return foundHelp(search, strs, strs.length);
	}

	private boolean foundHelp(String search, String[] strs, int len) {
		if (len == 0) {
			return false;
		}
		if (strs[len - 1].equals(search)) {
			return true;
		}
		return foundHelp(search, strs, len - 1);

	}
}
