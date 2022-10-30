package DTO;

import java.util.Comparator;
import managerstudent.Student;

public class RoleEmpldComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = Comparator.comparing((Employee e) -> e.getRole())
        .thenComparing(e -> e.getEmpid())
        .compare(o1, o2);
     return result;  
    }
}
