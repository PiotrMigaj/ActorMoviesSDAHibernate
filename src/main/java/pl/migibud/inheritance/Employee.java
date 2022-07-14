package pl.migibud.inheritance;

import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
public class Employee extends Person{

	String position;

	public Employee(String name, String position) {
		super.name = name;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"position='" + position + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Employee)) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		Employee employee = (Employee) o;
		return Objects.equals(position, employee.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), position);
	}
}
