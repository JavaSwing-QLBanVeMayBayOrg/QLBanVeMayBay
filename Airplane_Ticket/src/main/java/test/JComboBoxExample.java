package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxExample {

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Tạo danh sách các mô tả cho JComboBox
        String[] descriptions = {"Tất cả", "Dưới 5 triệu", "Từ 5 đến 10 triệu", "Từ 10 đến 15 triệu", "Từ 15 triệu trở lên"};

        // Tạo danh sách các giá trị tương ứng cho JComboBox
        String[] values = {"", "lt5", "5-10", "10-15", "gt15"};

        // Tạo JComboBox và thêm các mô tả vào đó
        JComboBox<String> comboBox = new JComboBox<>(descriptions);

        // Đặt JComboBox tại vị trí xác định trên JFrame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(comboBox);

        // Thêm sự kiện ActionListener vào JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy index của mục được chọn từ JComboBox
                int selectedIndex = comboBox.getSelectedIndex();

                // Lấy giá trị tương ứng từ mảng giá trị
                String selectedValue = values[selectedIndex];

                // In giá trị được chọn ra console
                System.out.println("Selected value: " + selectedValue);
            }
        });

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}

