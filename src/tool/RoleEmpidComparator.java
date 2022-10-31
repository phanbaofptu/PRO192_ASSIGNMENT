package tool;

import java.util.Comparator;
import DTO.Employee;
import DTO.Employee;

public class RoleEmpidComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = Comparator.comparing((Employee e) -> e.getRole())
        .thenComparing(e -> e.getEmpId())
        .compare(o1, o2);
     return result;  
    }
}
