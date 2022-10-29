package pro_assignment_7.Modules;
import pro_assignment_7.*;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class InputModule {
    public static void input(ArrayList<Employee> list, String csvPath) {
        ArrayList<String> lines = new ArrayList<String>();
        if (readFile(lines, csvPath))
            saveToList(list, lines);
        System.out.println("Doc du lieu hoan thanh.");
    }
    
    static boolean readFile(ArrayList<String> lines, String csvPath) {
        try {
            List<String> _lines = Files.readAllLines(Paths.get(csvPath));
            for (int i = 0; i < _lines.size(); i++)
                lines.add(_lines.get(i));
            return true;
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return false;
        }
    }
    
    static void saveToList(ArrayList<Employee> list, List<String> lines) {
        DTO dto = new DTO();
        
        for (String line: lines) {
            String[] values = line.split(",");
            try {
                String error = dto.set(values);                                                         //with validation
                if (!error.isEmpty())
                    System.out.println(error);
                else {
                    Employee emp;
                    switch (dto.getRole()) {
                        case 1:
                            emp = new Management(dto.getEmpId(), dto.getAccount(), dto.getRole(), dto.getWorkStartingDate(), dto.getProductivityScore(), dto.getNum6(), dto.getNum7());
                            break;
                        case 2:
                            emp = new Leader(dto.getEmpId(), dto.getAccount(), dto.getRole(), dto.getWorkStartingDate(), dto.getProductivityScore(), dto.getNum6(), dto.getNum7());
                            break;
                        case 3:
                            emp = new Dev(dto.getEmpId(), dto.getAccount(), dto.getRole(), dto.getWorkStartingDate(), dto.getProductivityScore(), dto.getNum6());
                            break;
                        default:
                            return;
                    }
                    list.add(emp);
                }
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
