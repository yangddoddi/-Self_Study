package standardOfJava.While;

import javax.swing.*;

// 랜덤 수 맞추기
public class doWhile {
    public static void main(String[] args) {
        int correct = (int)Math.ceil(Math.random() * 100);
        int input;

        do {
            input = Integer.parseInt(JOptionPane.showInputDialog("1에서 100까지의 정수를 입력하세요."));

            if (input < correct && input < 100) {
                JOptionPane.showMessageDialog(null, "더 큰 수를 입력하세요.");
            } else if (input > correct && input > 0) {
                JOptionPane.showMessageDialog(null, "더 작은 수를 입력하세요.");
            } else if (input < 0 || input > 100) {
                JOptionPane.showMessageDialog(null, "잘못된 수를 입력했습니다.");
            }
        } while (input != correct);
        JOptionPane.showMessageDialog(null,"정답입니다. 축하합니다!");
    }
}
