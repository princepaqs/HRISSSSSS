package hris;

public final class User {
    protected static String employeeID;
    protected static String employeeName;
    protected static String employeeRole;
    protected static String employeeTracked;
    
    public static void set(String parameter, String value) throws Exception {
        switch (parameter) {
            case "employeeID":
                employeeID = value;
                break;
            case "employeeName":
                employeeName = value;
                break;
            case "employeeRole":
                employeeRole = value;
                break;
            default:
                throw new Exception("Invalid user parameter.");
        }
    }
    
    public static String getEmployeeID() {
        return employeeID;
    }
    
    public static String getEmployeeName() {
        return employeeName;
    }
    
    public static String getEmployeeRole() {
        return employeeID;
    }
    
    public static void setEmployeeTracked(String employeeID) {
        employeeTracked = employeeID;
    }
    
    public static String getEmployeeTracked() {
        return employeeTracked;
    }
    
}
