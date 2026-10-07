package Exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dice extends JFrame implements ActionListener {

    // 元件
    JLabel infoLabel = new JLabel("已擲 0 次，總和 0，平均 0.00");
    JLabel diceLabel = new JLabel("1");
    JButton btn = new JButton("擲骰子");

    // 統計資料
    int count = 0;
    int sum = 0;

    public Dice() {

        // 1. 視窗設定
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   // 開啟時置中

        // 使用 BorderLayout
        setLayout(new BorderLayout());

        // 4. 上方統計資訊
        infoLabel.setHorizontalAlignment(JLabel.CENTER);
        infoLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 18));
        add(infoLabel, BorderLayout.NORTH);

        // 2. 中央骰子點數
        diceLabel.setHorizontalAlignment(JLabel.CENTER);
        diceLabel.setVerticalAlignment(JLabel.CENTER);
        diceLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        diceLabel.setForeground(Color.BLACK);
        add(diceLabel, BorderLayout.CENTER);

        // 3. 下方按鈕
        btn.addActionListener(this);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btn);
        add(bottomPanel, BorderLayout.SOUTH);

        // 顯示視窗
        setVisible(true);
    }

    // 按下「擲骰子」時執行
    public void actionPerformed(ActionEvent e) {

        // 產生 1 ~ 6 的隨機數字
        int number = (int)(Math.random() * 6) + 1;

        // 更新統計資料
        count++;
        sum += number;

        // 計算平均
        double average = (double) sum / count;

        // 更新骰子點數
        diceLabel.setText(String.valueOf(number));

        // 4. 更新上方統計資訊
        infoLabel.setText(
            String.format("已擲 %d 次，總和 %d，平均 %.2f",
                          count, sum, average)
        );

        // 5. 根據骰子點數改變文字顏色
        if (number == 6) {
            diceLabel.setForeground(Color.GREEN);
        } else if (number == 1) {
            diceLabel.setForeground(Color.RED);
        } else {
            diceLabel.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Dice();
    }
}

