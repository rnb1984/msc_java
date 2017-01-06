package adts;

public class Date {
	public static final int[] LAST = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };
	// Each Date object is a past, present, or future date.
	// This date is represented by a day-in-epoch
	// number d (where 0 represents 1 January 2000):
	public int y, m, d;

	public Date(int y, int m, int d) throws invalidDateException {
		if (m < 1 || d > LAST[m])
			throw new invalidDateException(d + "," + m + "," + y); // improper date
		this.y = y;
		this.m = m;
		this.d = d;
	}

	public void advance(int n) {
		int y = this.y, m = this.m, d = this.d + n;
		
		while (d > LAST[m]) {
			d -= LAST[m];
			if (m < 12)
				m++;
			else {
				m = 1;
				y++;
			}
		}

		this.y = y;
		this.m = m;
		this.d = d;
	}
	
	public String toString(){
		return("(" + d + "," + m + "," + y + ")");
	}

	public static void main(String[] args) throws invalidDateException {
		Date d1 = new Date(2009,4,28);
		d1.advance(40);
		System.out.println("The new date is " + d1);

	}

}
