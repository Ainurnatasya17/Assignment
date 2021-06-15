import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PayCalculatorUI {

	// private member components
	private JFrame payCalculatorUIFrame;
	private JTextField tf_empId;
	private JTextField tf_hoursWorked;
	private JTextPane textPane_display;
	private Employee employee;
	private ButtonGroup empTypeRadioButtonGroup, radioButtonUnionGroup;
	private JRadioButton rb_empA, rb_empB, rb_empC;
	private JRadioButton rb_unionMemberYes, rb_unionMemberNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		PayCalculatorUI window = new PayCalculatorUI();
		window.payCalculatorUIFrame.setVisible(true);
		} catch (Exception e) {
		e.printStackTrace();
		}
	 }
  });
}

	/**
	 * Create the application.
	 */
	public PayCalculatorUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		payCalculatorUIFrame = new JFrame();
		payCalculatorUIFrame.getContentPane().setBackground(new Color(255, 204, 204));
		payCalculatorUIFrame.setTitle("Weekly Pay Calculator");
		payCalculatorUIFrame.setBounds(100, 100, 422, 475);
		payCalculatorUIFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		payCalculatorUIFrame.getContentPane().setLayout(null);
		payCalculatorUIFrame.setResizable(false);
		
		JLabel lbl_empId = new JLabel("Employee ID:");
		lbl_empId.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lbl_empId.setBounds(35, 42, 87, 14);
		payCalculatorUIFrame.getContentPane().add(lbl_empId);

		JLabel lbl_hoursWorked = new JLabel("Hours Worked:");
		lbl_hoursWorked.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lbl_hoursWorked.setBounds(35, 82, 98, 14);
		payCalculatorUIFrame.getContentPane().add(lbl_hoursWorked);
		
		JLabel lbl_empType = new JLabel("Employee Type:");
		lbl_empType.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lbl_empType.setBounds(35, 128, 109, 20);
		payCalculatorUIFrame.getContentPane().add(lbl_empType);
		
		tf_empId = new JTextField();
		tf_empId.setBounds(143, 40, 134, 20);
		payCalculatorUIFrame.getContentPane().add(tf_empId);
		tf_empId.setColumns(10);
		
		tf_hoursWorked = new JTextField();
		tf_hoursWorked.setBounds(143, 80, 134, 20);
		payCalculatorUIFrame.getContentPane().add(tf_hoursWorked);
		tf_hoursWorked.setColumns(10);
		
		rb_empA = new JRadioButton("A");
		rb_empA.setBounds(143, 128, 44, 23);
		payCalculatorUIFrame.getContentPane().add(rb_empA);
		
		rb_empB = new JRadioButton("B");
		rb_empB.setBounds(143, 154, 44, 23);
		payCalculatorUIFrame.getContentPane().add(rb_empB);
		
		rb_empC = new JRadioButton("C");
		rb_empC.setBounds(143, 180, 44, 23);
		payCalculatorUIFrame.getContentPane().add(rb_empC);
		
		empTypeRadioButtonGroup = new ButtonGroup();
		empTypeRadioButtonGroup.add(rb_empA);
		empTypeRadioButtonGroup.add(rb_empB);
		empTypeRadioButtonGroup.add(rb_empC);
		
		JLabel lbl_workerUnionMember = new JLabel("Worker's Union Membership");
		lbl_workerUnionMember.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lbl_workerUnionMember.setBounds(212, 130, 181, 17);
		payCalculatorUIFrame.getContentPane().add(lbl_workerUnionMember);
		
		rb_unionMemberYes = new JRadioButton("Yes");
		rb_unionMemberYes.setBounds(258, 154, 87, 23);
		payCalculatorUIFrame.getContentPane().add(rb_unionMemberYes);
		
		rb_unionMemberNo = new JRadioButton("No");
		rb_unionMemberNo.setBounds(258, 180, 87, 23);
		payCalculatorUIFrame.getContentPane().add(rb_unionMemberNo);
		
		radioButtonUnionGroup = new ButtonGroup();
		radioButtonUnionGroup.add(rb_unionMemberYes);
		radioButtonUnionGroup.add(rb_unionMemberNo);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 204, 153));
		buttonPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonPanel.setBounds(35, 240, 328, 48);
		payCalculatorUIFrame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton btn_displayPay = new JButton("Display Pay");
		btn_displayPay.setBackground(new Color(204, 51, 51));
		btn_displayPay.setForeground(Color.BLACK);
		btn_displayPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clicked) {
				if(allInputProvided())
					displayBTNActionPerformed();
				}
		});
		
		btn_displayPay.setBounds(61, 14, 101, 23);
		buttonPanel.add(btn_displayPay);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.setBackground(new Color(204, 51, 51));
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clicked) {
				tf_empId.setText("");
				tf_hoursWorked.setText("");
				textPane_display.setText("");
				empTypeRadioButtonGroup.clearSelection();
				radioButtonUnionGroup.clearSelection();
			}
		});
		
		btn_clear.setBounds(190, 14, 101, 23);
		buttonPanel.add(btn_clear);
		
		textPane_display = new JTextPane();
		textPane_display.setBackground(new Color(255, 204, 153));
		textPane_display.setBounds(35, 314, 328, 111);
		payCalculatorUIFrame.getContentPane().add(textPane_display);
		}
		
	/**
	* Method to display the pay
    */
	private void displayBTNActionPerformed() {
		String empID, hrs, type = "C";
		boolean unionMem = false;
		double hours;
		double grossPay, netPay;
		String displayStr = "";
		
		empID = this.tf_empId.getText();
		hrs = this.tf_hoursWorked.getText();
		
		try {
			hours = Double.parseDouble(hrs);
		}
		
		catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Number of Hours worked must be numeric!", "Invalid Hours",
						JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(this.rb_empA.isSelected())
			type = "A";
		else if(this.rb_empB.isSelected())
			type = "B";
		else
			type = "C";
		
		if(this.rb_unionMemberYes.isSelected())
			unionMem = true;
		else
			unionMem = false;
		
		employee = new Employee(empID, hours, type, unionMem);
		grossPay = employee.computeGrossPayI();
		netPay = employee.computeNetPay(grossPay);
		displayStr += "Employee ID:    " + employee.getEmployeeID() + "\n";
		displayStr += "Hours Worked: " + employee.getHours() + "\n";
		displayStr += String.format("Gross Pay:         RM %.2f\n", grossPay);
		displayStr += String.format("Net Pay:              RM %.2f\n", netPay);
		textPane_display.setText(displayStr);
	}
		
	/**
	* Helper method to check whether all the input were provided or not
	* @return
	*/
	private boolean allInputProvided() {
		boolean inputprovided = false;
		
		if(this.tf_empId.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Please enter the Employee ID.", "Empty Employee ID",
					JOptionPane.INFORMATION_MESSAGE);
		
		else if(this.tf_hoursWorked.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter the number of hours worked.", "Empty Hours",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(empTypeRadioButtonGroup.getSelection() == null)
		{
			JOptionPane.showMessageDialog(null, "Please select type of employee.", "No employee type",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(radioButtonUnionGroup.getSelection() == null)
		{
			JOptionPane.showMessageDialog(null, "Please select whether employee is Union member or not!",
					"Select Union member", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else
			inputprovided = true;
		return inputprovided;
		
	}
		

}
