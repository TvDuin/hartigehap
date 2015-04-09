package businessPresentation;

//Main class that runs the program.

import dataStorage.DrankDAO;
import javax.swing.JFrame;

public class Main extends JFrame {
	public static void main(String args[]) {
		JFrame frame = new Main();
                frame.setSize(600,400);
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Hartige Hap");
                JPanel paneel = new JPanel();
                frame.setContentPane (paneel);
                frame.setVisible(true);
    
                
                DrankDAO drankDAO = new DrankDAO();
                drankDAO.getAllDrank();
	}
}
