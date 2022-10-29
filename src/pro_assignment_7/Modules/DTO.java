package pro_assignment_7.Modules;

import java.text.*;
import java.util.*;

public class DTO {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    
    private int role;
    private String empId;
    private String account;
    private Date workStartingDate;
    private float productivityScore;
    private int num6;
    private int num7;
    
    public String set(String[] values){
        role = Integer.parseInt(values[0]);
        if (role < 1 || role > 3)
            return "Vai tro khong dung format (phai la 1, 2 hoac 3)";
        
        empId = values[1];
        if (empId.length() != 6 || !empId.startsWith("MNV"))
            return "Ma nhan vien khong dung format (phai bat dau MNV va co 6 ky tu)";
        
        account = values[2];
        if (account.isEmpty())
            return "Tai khoan khong duoc de trong";
        
        try {
            workStartingDate = dateFormat.parse(values[3]);
            if (workStartingDate.compareTo(new Date()) >= 0)                                            //new Date(): current date
                return "Ngay vao cong ty phai nho hon hien tai";
        }
        catch (ParseException e) {
            return "Ngay bat dau lam viec khong dung format (dd/mm/yyyy))";
        }
        
        productivityScore = Float.parseFloat(values[4]);
        if (0.8 - productivityScore > 0.0000001 ||  productivityScore - 1.2 > 0.0000001)
            return "Hieu suat lam viec khong hop le (0.8 - 1.2)";
        
        num6 = Integer.parseInt(values[5]);
        if (num6 < 0)
            return "So luong khong hop le";
        
        if (role == 1 || role == 2) {
            num7 = Integer.parseInt(values[6]);
            if (num7 < 0)
                return "So luong khong hop le";
        }
        
        return "";
    }

    
    
    
    
    
    
    
    
    
    
    
    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public int getRole() {
        return role;
    }

    public String getEmpId() {
        return empId;
    }

    public String getAccount() {
        return account;
    }

    public Date getWorkStartingDate() {
        return workStartingDate;
    }

    public float getProductivityScore() {
        return productivityScore;
    }

    public int getNum6() {
        return num6;
    }

    public int getNum7() {
        return num7;
    }
}
