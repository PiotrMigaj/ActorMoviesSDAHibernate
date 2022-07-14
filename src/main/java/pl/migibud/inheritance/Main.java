package pl.migibud.inheritance;

public class Main {
	public static void main(String[] args) {

		Employee employee = new Employee("Piotr","Statyk");
		Employee employee2 = new Employee("Piotr","Kreslarz");
		System.out.println(employee.equals(employee2));

	}
}
