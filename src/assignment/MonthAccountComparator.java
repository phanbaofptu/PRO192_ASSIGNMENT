
package DTO;

import java.util.Comparator;
import manageremployee.Employee;

public class CodeNameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = Comparator.comparing((Employee e) -> e.getMonthlyIncome())
        .thenComparing(s -> s.getAccount(), (String s1, String s2) -> s2.compareTo(s1))
        .compare(o1, o2);
     return result;
    }
}
