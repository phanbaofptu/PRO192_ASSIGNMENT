/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IO;
import DTO.Employee;
import GUI.EmployeeList;
import GUI.FormatFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 *
 * @author admin
 */
public class IO {
    public static void readFile() {
		FormatFile.DEFAULT_TABLE_MODEL.setRowCount(0);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(FormatFile.FILE));
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null) {
				EmployeeList.addEmployee(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile() {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FormatFile.FILE));
			BufferedWriter bw = new BufferedWriter(osw);
			for(Employee emp : EmployeeList.getArray()) {
				bw.write("" + emp);
				bw.newLine();
			}
			bw.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
