// Assignment #: 6
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: Helpful class
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.TilePane;
import javafx.geometry.Orientation;

public class ArmyPane extends BorderPane {
	// COMPLETED: contains a list of heroes
	ArrayList<Hero> heroList;

	// COMPLETED: Variables containing army Damage, Strength, and Charisma
	int totalDamage;
	int totalStrength;
	int totalCharisma;


	// TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Army information
   Label armyinfo;
	// ONE VBox to contain CheckBoxes
   VBox cheeckBoxes;
	// ONE "Load Heroes/Clear Selection" Button
	// --- 5. a) --- (about 3 lines)
   Button loadbtn;
   
	// --- 5. a) ---

	public ArmyPane(ArrayList<Hero> heroList) {
		this.heroList = heroList;

		// TODO 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// --- 5. a) --- (about 3 lines)
      armyinfo = new Label("Army info: ");
      cheeckBoxes = new VBox();
      loadbtn = new Button("Load Hereos/Clear Selection");

		// --- 5. a) ---

		// TODO: 5. b) Bind "Load Heroes/Clear Selection" Button to its handler
		// --- 5. b) --- (1 line)
      loadbtn.setOnAction(new LoadHeroesButtonHandler());
      
		// --- 5. b) ---

		// TODO: 5. c) Organize components to their positions on BorderPane
		// Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// --- 5. c) --- (1 line)
      this.setTop(armyinfo);
      this.setCenter(cheeckBoxes);
      this.setBottom(loadbtn);

		// --- 5. c) ---

	}

	private class LoadHeroesButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			// TODO: 6. Clear the VBox (1 line)
			// --- 6. a) --- (1 line)
         
         cheeckBoxes.getChildren().clear();
			// --- 6. a) ---
         


			// TODO: 6. b), c), d)
			// --- 6. b), c), d) --- (about 5-8 lines)
         
         
         for(int i = 0; i < heroList.size(); i++)
         {
            String mike = heroList.get(i).toString();
            CheckBox check = new CheckBox(mike);
            check.setOnAction(new CheckBoxHandler(heroList.get(i)));
            cheeckBoxes.getChildren().add(check);
            
         }
			// --- 6. b), c), d) ---

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Hero hero;

		// When creating a new CheckBoxHandler, pass in a Hero object so it can be accessed later
		public CheckBoxHandler(Hero _hero) {
			this.hero = _hero;
		}

		@Override
		public void handle(ActionEvent event) {
			// TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// --- 7. a) --- (1 line)
         CheckBox checks = (CheckBox) event.getSource();
			// --- 7. a) ---

			// TODO: 7. b) If the CheckBox was selected, add the current hero scores to totalStrength,
			// 	totalCharisma, and totalDamge. Otherwise, subtract the current hero scores
			// --- 7. b) --- (about 8-12 lines)
         if(checks.isSelected()){
            totalCharisma += hero.getCharisma();
            totalDamage += hero.getDamage();
            totalStrength += hero.getStrength();
         }
         else
         {
            totalCharisma -= hero.getCharisma();
            totalDamage -= hero.getDamage();
            totalStrength -= hero.getStrength();
         }

			// --- 7. b) ---

			// TODO: 7. c) Set the Label to
			// "Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma
			// --- 7. c) --- (1 line)

         armyinfo.setText("Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma);
			// --- 7. c) ---

		}
	}

}