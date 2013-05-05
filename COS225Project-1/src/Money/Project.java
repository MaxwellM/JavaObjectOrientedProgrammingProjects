package Money;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//This is a simple GUI that I made that will display a 
//window where you can enter an amount of money to 'add' 
//to Mike M's account, then it will display the minimal 
//amount in each type of coin. So enter an amount and 
//just hit enter!
public class Project extends Applet implements ActionListener {
	private static final long serialVersionUID = 8519669264278252152L;

	Money MikeM = new Money();
	Label label1, label2;
	TextField amountField;
	String nickels = " ";
	String dimes = " ";
	String quarters = " ";
	String halfdollars = " ";

	public void init() {
		setLayout(null);
		MikeM.define(0, 50);
		amountField = new TextField();
		amountField.setBounds(100, 70, 100, 20);
		amountField.addActionListener(this);
		add(amountField);
		label1 = new Label("Enter an amount to add in CENTS");
		label1.setBounds(50, 40, 230, 40);
		add(label1);
		label2 = new Label("Mike M's Account");
		label2.setBounds(97, 10, 115, 40);
		add(label2);
		setBackground(Color.white);
		setSize(300, 200);

	}

	public void actionPerformed(ActionEvent e) {
		int total2;
		total2 = Integer.parseInt(amountField.getText());
		if (total2 > 0) {
			MikeM.addmoney(0, total2);
		}
		nickels = " " + MikeM.totalnickels();
		dimes = " " + MikeM.totaldimes();
		quarters = " " + MikeM.totalquarters();
		halfdollars = " " + MikeM.totalhalfdollars();
		repaint();
	}

	public void stop() {
	}

	public void paint(Graphics g) {
		g.drawString("Total in Nickels: " + nickels, 50, 120);
		g.drawString("Total in Dimes: " + dimes, 50, 140);
		g.drawString("Total in Quarters: " + quarters, 50, 160);
		g.drawString("Total in Halfdollars: " + halfdollars, 50, 180);
	}
}
