package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name; //nome func
	private WorkerLevel level; // level de cargo
	private Double baseSalary; //salario base

	private Department department; //departamento
	private List<HourContract> contracts = new ArrayList<>(); //lista vazia de contratos

	public Worker() {	//contrutor vazio
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name; //vai ser informado pelo usuario
		this.level = level; //vai ser informado pelo usuario
		this.baseSalary = baseSalary;	//vai ser informado pelo usuario
		this.department = department; //vai ser informador pelo usuario
	}

	public String getName() { //trazer o nome
		return name;
	}

	public void setName(String name) { //mudar o nome
		this.name = name;
	}

	public WorkerLevel getLevel() { //trazer o cargo
		return level;
	}

	public void setLevel(WorkerLevel level) { // mudar o cargo
		this.level = level;
	}

	public Double getBaseSalary() { //trazer o salario
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) { //mudar o salario
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() { //trazer o departamento
		return department;
	}

	public void setDepartment(Department department) { //mudar o departamento
		this.department = department;
	}

	public List<HourContract> getContracts() { //trazer os contratos
		return contracts;
	}

	public void addContract(HourContract contract) {	//add contratos a lista
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) { // remover contratos da lista
		contracts.remove(contract);
	}
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
