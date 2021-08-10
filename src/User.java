public abstract class User {

	private int userID;
	private String fullname;
	private int age;
	private String address;

//    public User(int userID, String fullname, int age, String address) {
//        this.userID = userID;
//        this.fullname = fullname;
//        this.age = age;
//        this.address = address;
//    }

	public void checkMark() {
		// TODO - implement User.checkMark
		throw new UnsupportedOperationException();
	}

	public void viewClass() {
		// TODO - implement User.viewClass
		throw new UnsupportedOperationException();
	}

	public int getUserID() {
		return this.userID;
	}

	/**
	 * 
	 * @param userID
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullname() {
		return this.fullname;
	}

	/**
	 * 
	 * @param fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}