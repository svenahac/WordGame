package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import static Screens.EndScreen.*;
import static Screens.GameScreen.displayPoints;
import static Screens.GameScreen.gameScreen;


public class EndListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        endScreen.setVisible(true);
        gameScreen.dispose();

        String data = "1";
        
        // Sets the highscore if it was beaten
        try {
            File myObj = new File("src/Content/highscore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException ev) {
            System.out.println("An error occurred.");
            ev.printStackTrace();
        }

        int highscore =  Integer.parseInt(data);
        int current = Integer.parseInt(displayPoints.getText());
        if (highscore < current){
            highscore = current;
        }

        String newData = String.valueOf(highscore);

        
        try {
            FileWriter myWriter = new FileWriter("src/Content/highscore.txt");
            myWriter.write(newData);
            myWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
