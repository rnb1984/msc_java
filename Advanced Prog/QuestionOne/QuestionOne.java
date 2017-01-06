import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class QuestionOne extends JFrame implements ActionListener{
	// Variables for Game
	private int generatedNumber;
	private JLabel response, countdown;
	private JTextField inText;
	private JButton submit;
	// Constructor Method
	public QuestionOne(){
		// Set up GUI
		super("Tiltle");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,2));
		// Generate Number
		generatedNumber = (int)(Math.random()*50);
		// Set up components
		response = new JLabel(" Please Enter Number ");
		countdown = new JLabel("30");
		inText = new JTextField("00");
		inText.addActionListener(this);
		submit = new JButton("submit");
		submit.addActionListener(this);
		// Add components to GUI
		this.add(response);
		this.add(countdown);
		this.add(inText);
		this.add(submit);
		// Make visable
		this.setVisible(true);
		// Start Thread
		new CountDownThread().execute();
	}
	// Compare guessed number to generated number Method
	public void compareNumbers(){
		try{
			int guessedNumber = Integer.parseInt(inText.getText());
			if(guessedNumber == generatedNumber){
				// Exit and print out line
				System.out.println("Winner! You did it in " + (30 - Integer.parseInt(countdown.getText())) + " Seconds");
				System.exit(0);
				}
			else if(guessedNumber < generatedNumber)
				response.setText("Too Low");
			else
				response.setText("Too High");
			
		}catch(NumberFormatException e){
			response.setText("You must enter a number");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// Submit button pressed
		if (e.getSource() == submit){
			compareNumbers();
		}		
	}
	// Thread Class for counting down from 30
	private class CountDownThread extends SwingWorker <Void,Integer>{
		// Thread Method 
		protected Void doInBackground() throws Exception {
			int timeNum = 30;
			// Loop until 0
			while(timeNum >=0){
				// Thread method pass 1 less than 30
				publish(timeNum--);
				Thread.sleep(1000);
			}
			// Exit when 0 and print message
			System.out.println("Out of Time! Game Over!");
			System.exit(0);			
			return null;
		}
		// Process Thread Method to print count number to GUI
		protected void process(List<Integer> counting){
			int lastValue = counting.get(counting.size()-1);
			countdown.setText(String.format("%d",lastValue));
		}
	}
	// Main Method
	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new QuestionOne();
			}
		});
	}
}
