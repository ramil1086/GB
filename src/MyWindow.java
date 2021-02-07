import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


    public class MyWindow extends JFrame {
        public MyWindow() {
//        setTitle("Тестовое окно");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(300, 300, 400, 400);
//        JButton[] jbuttons = new JButton[5];
//        for (int i = 0; i < 5; i++) {
//            jbuttons[i] = new JButton("#" + i);
//        }
//        setLayout(new BorderLayout());
//        add(jbuttons[0], BorderLayout.EAST);
//        add(jbuttons[1], BorderLayout.WEST);
//        add(jbuttons[2], BorderLayout.SOUTH);
//        add(jbuttons[3], BorderLayout.NORTH);
//        add(jbuttons[4], BorderLayout.CENTER);
//        setVisible(true);
//

//        JButton button = new JButton("Button 1 (PAGE_START)");
//        add(button, BorderLayout.PAGE_START);
//        button = new JButton("Button 2 (CENTER)");
//        button.setPreferredSize(new Dimension(200, 100));
//        add(button, BorderLayout.CENTER);
//        button = new JButton("Button 3 (LINE_START)");
//        add(button, BorderLayout.LINE_START);
//        button = new JButton("Long-Named Button 4 (PAGE_END)");
//        add(button, BorderLayout.PAGE_END);
//        button = new JButton("5 (LINE_END)");
//        add(button, BorderLayout.LINE_END);
//        setVisible(true);
//        setBounds(500,500,500,300);
//        setTitle("BoxLayoutDemo");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JButton[] jbs = new JButton[10];
////        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            jbs[i].setAlignmentX(CENTER_ALIGNMENT);
//            add(jbs[i]);
//        }
//        setVisible(true);

//        setBounds(500, 500, 400, 300);
//        setTitle("FlowLayoutDemo");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JButton[] jbs = new JButton[10];
//        setLayout(new FlowLayout());
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            add(jbs[i]);
//        }
//        setVisible(true);

//        setBounds(500,500,400,300);
//        setTitle("GridLayoutDemo");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JButton[] jbs = new JButton[10];
//        setLayout(new GridLayout(4, 3));
//        for (int i = 0; i < jbs.length; i++) {
//            jbs[i] = new JButton("#" + i);
//            add(jbs[i]);
//        }
//        setVisible(true);

//        setBounds(500,500,400,300);
//        setTitle("GridLayoutDemo");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JButton button = new JButton("Button");
//        add(button);
//        button.addActionListener(e -> System.out.println("Button pressed..."));
//        setVisible(true);

//        setBounds(500, 500, 400, 300);
//        setTitle("Demo");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JTextField field = new JTextField();
//        add(field);
//        field.addActionListener(e -> System.out.println("Your message: " + field.getText()));
//        setVisible(true);

            setBounds(500, 500, 400, 300);
            setTitle("Demo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JPanel pan = new JPanel();
            Color redColor = new Color (255, 127, 127);
            pan.setBackground(redColor);
            add(pan);
            pan.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.out.println("MousePos: " + e.getX() + " " + e.getY());
                }
            });
            setVisible(true);

    }
}
