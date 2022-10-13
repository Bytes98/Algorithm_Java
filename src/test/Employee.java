package test;//import ListNode;

public class Employee {

    String name;
    String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    Employee(){}

    Employee(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    public void change_name(String name, String addr){
        this.name = name;
        this.addr = addr;
    }

    public static void main(String[] args){
//        System.out.println("Bonjour!");
        Employee[] employees = new Employee[5];
        for(int i=0; i<employees.length; i++)
        {
            employees[i]=new Employee();
        }
        employees[0].setAddr("testAddr");
        System.out.println(employees[0].getAddr());


//        ListNode listNode = new ListNode(1);
//        System.out.println(listNode.val);
    }
}


