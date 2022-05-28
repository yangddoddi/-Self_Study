import javax.swing.*;
import java.util.Arrays;

public class login {
    public static void main(String[] args) {
        String id = args[0];
        String password = args[1];

        String[][] userloginInformations = {
                {"ddoddi", "123456"}, {"baby", "123456"}, {"babo", "123456"}
        };

        boolean isLoggedIn = false;

        for (String[] user : userloginInformations) {
            if (user[0].equals(id) && user[1].equals(password)) {
                isLoggedIn = true;
                break;
            }
        }

        if (isLoggedIn) {
            JOptionPane.showMessageDialog(null, "로그인 성공");
        } else {
            JOptionPane.showMessageDialog(null, "로그인 실패");
        }
//
//        for (int i=0; i<userloginInformations.length; i++) {
//            String[] user = userloginInformations[i];
//            if (user[0].equals(id) && user[1].equals(password)) {
//                isLoggedIn = true;
//                break;
//            }
//        }
    }
}