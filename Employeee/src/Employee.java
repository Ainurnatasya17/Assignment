
public class Employee {

	private String employeeID; 
    private double hours; 
    private String type;
    private boolean member; 
    
    public Employee(String employeeID, double hours, String type, boolean member){
        this.employeeID = employeeID;
        this.hours = hours;
        this.type = type;
        this.member = member;
    
    }

    
    public double computeGrossPayI(){

    double rate = 0.0;
    double grossPay = 0.0;
    double overTime = 0.0;
    double overTimePay = 0.0;
 
    
    if(type.equalsIgnoreCase("A"))
        rate = 150.0;
    else if(type.equalsIgnoreCase("B"))
        rate = 100.0;
    else if(type.equalsIgnoreCase("C"))
        rate = 50.0;


    if(hours > 40){
        grossPay = rate * 40.0;
        overTime = hours - 40.0;
        overTimePay = overTime * 100;
        grossPay = grossPay + overTimePay;

    }

    else
        grossPay = rate * hours;
        return grossPay;
    
    }

    
    public double computeNetPay(double grossPay){
    
    if(member)
        return (grossPay - 50);
    else
        return grossPay;
    
    }

    
    public String getEmployeeID() {
        return employeeID;
    
    }

    public double getHours() {
        return hours;
    
    }

    public String getType() {
    return type;
    
    }

    public boolean isMember() {
        return member;
    
    }

    public void setEmployeeID(String empID) {
        this.employeeID = empID;
    
    }

    public void setHours(double hours) {
        this.hours = hours;
    
    }

    public void setType(String type) {
        this.type = type;
    
    }

    public void setMember(boolean member) {
        this.member = member;
    
    }

}
