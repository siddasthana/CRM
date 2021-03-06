package temp;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MainClass {
    public static void main(final String args[]) {
        final String labels[] = { "A", "B", "C", "D", "E", "AA" };
        final DefaultComboBoxModel model = new DefaultComboBoxModel(labels);
        JFrame frame = new JFrame("Shared Data");
        JComboBox comboBox1 = new JComboBox(model);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList jlist = new JList(model);
        JScrollPane scrollPane = new JScrollPane(jlist);
        
        comboBox1.setMaximumRowCount(5);
        comboBox1.setEditable(true);
        JButton button = new JButton("Add");
        frame.add(comboBox1, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                model.addElement("a");
            }
        };
    button.addActionListener(actionListener);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}