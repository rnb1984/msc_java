package adts;

public class invalidDateException extends Exception {
		private String badDate;

		// constructor
		public invalidDateException(String bd) {
			super(bd); // constructor for superclass
		}
			


		public String getBadDate() {
			return badDate;
		}

		public void setBadDate(String bd) {
			badDate = bd;
		}

	}

