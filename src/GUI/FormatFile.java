/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author admin
 */
public class FormatFile {
    public static JTable TABLE;
	public static DefaultTableModel DEFAULT_TABLE_MODEL;
	public static ArrayList<String> ROLE = new ArrayList<String>();
	static {
		ROLE.add("");
		ROLE.add("MANAGEMENT");
		ROLE.add("LAEADER");
		ROLE.add("DEV");
	}
	public static boolean OPENED_FILE = false;
	public static File FILE;
	public static boolean EDITTED = false;
}
