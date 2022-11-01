/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Dev;
import DTO.Employee;
import DTO.Leader;
import DTO.Management;
import DTO.Menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author phangiabao
 */
public class EmployeeManager {
  public static Scanner sc = new Scanner(System.in);
      public static void _main(String[] args) throws IOException, FileNotFoundException, ParseException {
        String[] options = {
            "Input from CSV file",
            "Caculate",
            "Print",
            "Exit"};
        int choice = 0;
        		do{
                  System.out.println("Enter number: ");
                  choice = Menu.getChoice(options);
			switch (choice) {
			case 1:
				ArrayList<Employee> employeeList = inputFromCSV(new File("D://dataAssignmentPro192_FA22.csv"));
				for (Employee employee : employeeList) {
					System.out.println(employee);
				}

				break;
			case 2:
				employeeList = inputFromCSV(new File("D://dataAssignmentPro192_FA22.csv"));
				calculate(employeeList);
				
				break;
			case 3:
				employeeList = inputFromCSV(new File("D://dataAssignmentPro192_FA22.csv"));
                                calculate(employeeList);
				compareInComeAndAccountThenPrint(employeeList);
				break;
			case 4:
				System.out.println("Exit");
				System.exit(2);
          }
	                }while (true);
          }
    public static ArrayList<Employee> inputFromCSV(File file) throws FileNotFoundException, IOException, ParseException {
        BufferedReader br = null;
        String csvLine;
        int error = 0;;
        br = new BufferedReader(new FileReader(file));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        Date currentDate = new Date();

        while ((csvLine = br.readLine()) != null) {
            if (csvLine != null) {
                String[] splitData = csvLine.split(",");

                Employee employee = null;

                if (splitData[0].isEmpty() && splitData[2].isEmpty()) {
                    System.err.println("Bạn cần nhập giá trị cho Role và Account!");
                    error += 1;
                } else if (splitData[1].length() != 6 && !"MNV".equals(splitData[1].substring(0, 2))) {
                    System.err.println("Employee ID phải có 6 ký tự và bắt đầu bởi MNV");
                    error += 1;
                } else if (formatter.parse(splitData[3]).compareTo(currentDate) > 0) {
                    System.err.println("Ngày bắt đầu đi làm phải nhỏ hơn ngày hiện tại!");
                    error += 1;
                }
                switch (splitData[0]) {
                    case "1":
                        employee = new Management(splitData[1], 1, splitData[2], formatter.parse(splitData[3]),
                                Double.valueOf(splitData[4]), Integer.valueOf(splitData[5]), Integer.valueOf(splitData[6]));
                        break;

                    case "2":
                        employee = new Leader(splitData[1], 2, splitData[2], formatter.parse(splitData[3]),
                                Double.valueOf(splitData[4]), Integer.valueOf(splitData[5]), Integer.valueOf(splitData[6]));
                        break;

                    case "3":
                        employee = new Dev(splitData[1], 3, splitData[2], formatter.parse(splitData[3]),
                                Double.valueOf(splitData[4]), Integer.valueOf(splitData[5]));
                        break;
                }

                employeeList.add(employee);
            }
        }

        br.close();
        return employeeList;
    }

    private static ArrayList<Employee> calculate(ArrayList<Employee> input) {
        
        //StringBuffer sb = new StringBuffer();
        //StringBuilder out = new StringBuilder();
        //ArrayList<Employee> input = new ArrayList<>();

        for (Employee employee : input) {
            if (employee instanceof Management) {
                Management tempMana = (Management) employee;
                tempMana.setRewardSalary(tempMana.calReward());
                tempMana.setAllowance(tempMana.calAllowance());
                tempMana.setMonthlyIncome(tempMana.calMonthlyIncome());

            } else if (employee instanceof Leader) {
                Leader tempLeader = (Leader) employee;
                tempLeader.setRewardSalary(tempLeader.calReward());
                tempLeader.setAllowance(tempLeader.calAllowance());
                tempLeader.setMonthlyIncome(tempLeader.calMonthlyIncome());

            } else {
                Dev tempDev = (Dev) employee;
                tempDev.setRewardSalary(tempDev.calReward());
                tempDev.setMonthlyIncome(tempDev.calMonthlyIncome());

            }
            //out.add(employee);
        }
        for(Employee out:input) {
            System.out.println(out);
            
        }
        
        
        
        return input;
    }

    private static void compareInComeAndAccountThenPrint(ArrayList<Employee> input) {

        ArrayList<Employee> sortList = input;
        Collections.sort(sortList, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Double x1 = ((Employee) o1).getMonthlyIncome();
                Double x2 = ((Employee) o2).getMonthlyIncome();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                String a1 = ((Employee) o1).getAccount();
                String a2 = ((Employee) o2).getAccount();
                return a2.compareTo(a1);
            }

        });

        for (Employee employee : sortList) {
            System.out.println(employee.toString());
        }

    }



}
