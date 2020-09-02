package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com o nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Worker Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Worker base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.println("How manu contracts to this worker? Enter the value: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract number " + i + " Data: ");
			System.out.println("Enter type data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Value Per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration Contract: ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); // instanciando o metodo
			worker.addContract(contract);
		}
		System.out.println();
		System.out.println("Enter month and year to calculate salary (mm/yyyy): ");
		String MonthAndYear = sc.next();
		int month = Integer.parseInt(MonthAndYear.substring(0, 2)); // convertendo int para string
		int year = Integer.parseInt(MonthAndYear.substring(3));
		System.out.println("Name worker: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income: " + MonthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}
}
