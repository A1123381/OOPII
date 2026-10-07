package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame {

    // ==============================
    // 1. 使用陣列模擬資料庫
    // ==============================

    // 儲存多個帳號
    private String[] usernames = {
        "admin",
        "user01",
        "student01",
        "teacher01"
    };

    // 儲存與帳號對應的密碼
    private String[] passwords = {
        "1234",
        "abcd",
        "5678",
        "9999"
    };


    // ==============================
    // 2. 宣告 GUI 元件
    // ==============================

    // 帳號輸入框
    private JTextField usernameField;

    // 密碼輸入框
    private JPasswordField passwordField;

    // 登入按鈕
    private JButton loginButton;


    // ==============================
    // 3. 建立登入視窗
    // ==============================

    public LoginWindow() {

        // 設定視窗標題
        setTitle("登入系統");

        // 設定視窗大小
        setSize(350, 200);

        // 按下右上角 X 時結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 將視窗放在螢幕中央
        setLocationRelativeTo(null);


        // ==============================
        // 4. 建立面板
        // ==============================

        JPanel panel = new JPanel();

        // 使用 GridLayout
        // 4 列、2 欄
        panel.setLayout(new GridLayout(4, 2, 10, 10));


        // ==============================
        // 5. 建立 GUI 元件
        // ==============================

        // 帳號標籤
        JLabel usernameLabel = new JLabel("帳號：");

        // 帳號輸入框
        usernameField = new JTextField();


        // 密碼標籤
        JLabel passwordLabel = new JLabel("密碼：");

        // 密碼輸入框
        passwordField = new JPasswordField();


        // 登入按鈕
        loginButton = new JButton("登入");


        // ==============================
        // 6. 將元件加入面板
        // ==============================

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        // 留白
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        panel.add(new JLabel(""));
        panel.add(loginButton);


        // 將面板加入視窗
        add(panel);


        // ==============================
        // 7. 登入按鈕事件
        // ==============================

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 取得使用者輸入的帳號
                String inputUsername = usernameField.getText();

                // 取得使用者輸入的密碼
                String inputPassword =
                    new String(passwordField.getPassword());


                // ==============================
                // 8. 檢查帳號密碼
                // ==============================

                // 預設為登入失敗
                boolean loginSuccess = false;


                // 使用 for 迴圈逐筆搜尋陣列
                for (int i = 0; i < usernames.length; i++) {

                    // 檢查帳號與密碼是否同時符合
                    if (usernames[i].equals(inputUsername)
                            && passwords[i].equals(inputPassword)) {

                        // 找到符合的帳號密碼
                        loginSuccess = true;

                        // 找到後就不用繼續搜尋
                        break;
                    }
                }


                // ==============================
                // 9. 顯示登入結果
                // ==============================

                if (loginSuccess) {

                    // 登入成功
                    JOptionPane.showMessageDialog(
                        LoginWindow.this,
                        "登入成功！\n歡迎 " + inputUsername,
                        "登入結果",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    // 登入失敗
                    JOptionPane.showMessageDialog(
                        LoginWindow.this,
                        "帳號或密碼錯誤！",
                        "登入失敗",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }


    // ==============================
    // 10. 主程式
    // ==============================

    public static void main(String[] args) {

        // 建立登入視窗
        LoginWindow window = new LoginWindow();

        // 顯示視窗
        window.setVisible(true);
    }
}
