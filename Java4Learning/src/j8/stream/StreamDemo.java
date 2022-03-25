package j8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		
		ArrayList<Employee> empList = new ArrayList<>();
		//add objects to list
		{
			empList.add(new Employee(100001L,"Emp100001", "DEP1000", 50000d,true));
			empList.add(new Employee(100002L,"Emp100002", "DEP1000", 60000d,false));
			empList.add(new Employee(100003L,"Emp100003", "DEP1000", 70000d,true));
			empList.add(new Employee(100004L,"Emp100004", "DEP1000", 50000d,true));
			empList.add(new Employee(200001L,"Emp200001", "DEP2000", 80000d,true));
			empList.add(new Employee(200002L,"Emp200002", "DEP2000", 55000d,false));
			empList.add(new Employee(200003L,"Emp200003", "DEP2000", 100000d,true));
			empList.add(new Employee(300001L,"Emp300001", "DEP3000", 50000d,true));
			empList.add(new Employee(400001L,"Emp400001", "DEP4000", 40000d,true));
			empList.add(new Employee(500001L,"Emp500001", "DEP5000", 30000d,true));
		}
		
		//print all employees
			empList.stream().forEach(e-> System.out.println(e));
		
		//1.Write a program to print employee details working in each department
			Map<String, List<Employee>> deptWiseEmpMap = empList.stream().collect(Collectors.groupingBy(Employee :: getDeptId,Collectors.toList()));
			deptWiseEmpMap.entrySet().forEach(e-> {
				System.out.println(e.getKey() + " --> " + e.getValue());
			});
			
		//2.Write a program to print employees count working in each department
			Map<String,Long> deptWiseEmpCount = empList.stream().collect(Collectors.groupingBy(Employee :: getDeptId, Collectors.counting()));
			deptWiseEmpCount.entrySet().forEach(e-> {
				System.out.println(e.getKey() + " --> " + e.getValue());
			});			
			
		//3.Write a program to print active and inactive employees in the given collection
			Long empCount = empList.stream().count();
			System.out.println("Total Employees : " + empCount);
			
			Long activeEmpCount = empList.stream().filter(e -> e.isActive()).count();
			System.out.println("Total Active Employees : " + activeEmpCount);

			Long nonActiveEmpCount = empList.stream().filter(e -> !e.isActive()).count();
			System.out.println("Total Non-active Employees : " + nonActiveEmpCount);
			
		//4.Write a program to print Max/Min employee salary from the given collection
			Optional<Employee> maxSalEmp = empList.stream().max(Comparator.comparing(Employee :: getEmpSalary));
			System.out.println("Max Salary : "+ maxSalEmp.get().getEmpSalary() + ", Drawn by "+maxSalEmp.get().getEmpName());
			
			Optional<Employee> minSalEmp = empList.stream().min(Comparator.comparing(Employee :: getEmpSalary));
			System.out.println("Min Salary : "+ minSalEmp.get().getEmpSalary() + ", Drawn by "+minSalEmp.get().getEmpName());
			
		//5.Write a program to print the max salary of an employee from each department
			Map<String, Optional<Employee>> empTopSalByDep = 	empList.stream().collect(Collectors.groupingBy(Employee :: getDeptId,
					Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee :: getEmpSalary)))
					));
			empTopSalByDep.entrySet().forEach(e-> {
				System.out.println(e.getKey() + " --> " + e.getValue());
			});			
		
		//print sort by salary - asc
			System.out.println("sort by salary - asc");
			empList.stream().sorted((e1,e2) -> e1.getEmpSalary().compareTo(e2.getEmpSalary())).forEach(e->System.out.println(e));
		
		//print by 7
			System.out.println("Original");
			for (Employee e : empList)
				System.out.println(e);
	}
	

}

//An Object to work upon
class Employee
{
	Long empId;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptId=" + deptId + ", empSalary=" + empSalary
				+ ", isActive=" + (isActive? 1:0) + "]";
	}
	String empName;
	String deptId;
	Double empSalary;
	private boolean isActive;
	
	public Employee(Long empId, String empName, String deptId, Double empSalary,boolean isActive) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.empSalary = empSalary;
		this.isActive = isActive;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}