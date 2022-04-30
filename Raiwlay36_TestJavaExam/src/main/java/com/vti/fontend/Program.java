package com.vti.fontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.entity.User;
import com.vti.utils.properties.ScannerUtils;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Program {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Function function = new Function();

        while (true) {
            System.out.println("========= Menu =========");
            System.out.println("1. Tìm kiếm các Employee có cùng  id project ");
            System.out.println("2. Tìm kiếm các Manager có cùng  id project ");
            System.out.println("3. In ra danh sách các Manager ");
            System.out.println("4. Đăng nhập ");
            System.out.println("0. Thoát chương trình");
            int choose = ScannerUtils.inputInt("Kí tự vừa nhập chưa đúng định dạng. Vui lòng nhập lại!");
            switch (choose) {
                case 1:
                    function.getEmployeeByProjectId();
                    break;
                case 2:
                    function.getManagerByProjectId();
                    break;
                case 3:
                    function.getManager();
                    break;
                case 4:
                    menulogin();
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc!!!");
                    return;
                default:
                    System.out.println("Nhập sai !");
                    break;
            }
        }
    }

    public static void menulogin() throws FileNotFoundException, IOException {
        Function function = new Function();
        System.out.println("Vui lòng nhập email va password");
        User user = function.login();
        System.out.println("Đăng nhập thành công!");
        System.out.println("Chào mừng " + user.getFullName() + "!");
    }
}