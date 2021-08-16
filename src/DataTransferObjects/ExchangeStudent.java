package DataTransferObjects;


public class ExchangeStudent extends Student {

    private int discount = 30;
    

    public ExchangeStudent(Integer userID, String fullname, Integer age, String address, int initialFee, Course course) {
        super(userID, fullname, age, address, initialFee, course);
    }
    


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
