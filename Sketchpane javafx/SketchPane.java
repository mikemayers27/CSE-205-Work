// Assignment #: 7
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description:SketchPane class
import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.shape.*;
import javafx.scene.control.*;


public class SketchPane extends BorderPane {
	
	//Task 1: Declare all instance variables listed in UML diagram
   private ArrayList<Shape> shapeList;
   private ArrayList<Shape> tempList;
	private Button undoButton;
   private Button eraseButton;
   private Label fillColorLabel;
   private Label strokeWidthLabel;
   private ComboBox<String> fillColorCombo;
   private ComboBox<String> strokeWidthCombo;
   private ComboBox<String> strokeColorCombo;
   private RadioButton radioButtonLine;
   private RadioButton radioButtonRectangle;
   private RadioButton radioButtonCircle;
   private Pane sketchCanvas;
   private Color[] colors;
   private String[] strokeWidth;
   private String[] colorLabels;
   private Label strokeColorLabel;
   private Color currentStrokeColor;
   private Color currentFillColor;
   private int currentStrokeWidth;
   private Line line; 
   private Circle circle;
   private Rectangle rectangle;
   private double x1;
   private double y1;
   private Pane pane;
  
   
   
   
	//Task 2: Implement the constructor
	public SketchPane() {
   pane = new Pane();
      shapeList = new ArrayList<>();
      tempList = new ArrayList<>();
      undoButton = new Button("Undo");
      undoButton.setOnAction(new ButtonHandler());
      eraseButton = new Button("Erase");
      eraseButton.setOnAction(new ButtonHandler());
      fillColorLabel = new Label("Fill color");
      strokeWidthLabel = new Label("Stroke Width");
      
      radioButtonLine = new RadioButton("Line");
      radioButtonRectangle = new RadioButton("Rectangle");
      radioButtonCircle = new RadioButton("Circle");
      sketchCanvas = new Pane();
      
		// Colors, labels, and stroke widths that are available to the user
		colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, Color.DEEPSKYBLUE, Color.LIME} ;
      colorLabels = new String[] {"black", "grey", "yellow", "gold", "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
        fillColorLabel = new Label("Fill Color:");
        strokeColorLabel = new Label("Stroke Color:");
        strokeWidthLabel = new Label("Stroke Width:");
        strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"}; 
        currentStrokeColor = Color.BLACK;
        currentFillColor = Color.BLACK;
        
       
        line = new Line(10.0f, 10.0f, 200.0f, 140.0f);
        circle = new Circle();
        rectangle = new Rectangle();
        this.getChildren().add(pane);
        MouseHandler mouseHandler = new MouseHandler();
        pane.setOnMousePressed(mouseHandler);
        ToggleGroup group = new ToggleGroup();
        radioButtonLine.setToggleGroup(group);
        radioButtonRectangle.setToggleGroup(group);
        radioButtonCircle.setToggleGroup(group);
        
        fillColorCombo = new ComboBox();
        fillColorCombo.setValue(fillColorLabel.getText());
        fillColorCombo.getItems().addAll(colorLabels);
        strokeWidthCombo = new ComboBox();
        strokeWidthCombo.setValue(strokeWidthLabel.getText());
        strokeWidthCombo.getItems().addAll(strokeWidth);
        strokeColorCombo = new ComboBox();
        strokeColorCombo.setValue(strokeColorLabel.getText());
        strokeColorCombo.getItems().addAll(colorLabels);
        
        
        
        
        sketchCanvas.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        
        
        HBox pane1 = new HBox();
        
        pane1.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,null,null)));
        pane1.setSpacing(20);
        pane1.setMinSize(20,40);
        pane1.getChildren().addAll(fillColorLabel, fillColorCombo, strokeWidthLabel, strokeWidthCombo, strokeColorLabel, strokeColorCombo);
        pane1.setAlignment(Pos.CENTER);
        
        
        
        HBox pane2 = new HBox();
        
        pane2.setSpacing(20);
        pane2.setMinSize(20,40);
        pane2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,null,null)));
        pane2.getChildren().addAll(radioButtonLine, radioButtonRectangle, radioButtonCircle, undoButton, eraseButton);
        pane2.setAlignment(Pos.CENTER);
        
        this.setTop(pane1);
        this.setCenter(sketchCanvas);
        this.setBottom(pane2);
        
        
        sketchCanvas.setOnMousePressed(new MouseHandler());
        sketchCanvas.setOnMouseReleased(new MouseHandler());
        sketchCanvas.setOnMouseDragged(new MouseHandler());
        x1 = 0;
        y1 = 0;
        shapeList = new ArrayList<Shape>();
        /*fillColorLabel.setText("black");
        strokeColorLabel.setText("black");
        strokeWidthLabel.setText("1");*/
        fillColorCombo.setOnAction(new ColorHandler());
        strokeColorCombo.setOnAction(new ColorHandler());
        strokeWidthCombo.setOnAction(new WidthHandler());
        
    }

	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// TASK 3: Implement the mouse handler for Circle and Line
         if(radioButtonCircle.isSelected()) {
         
            if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            x1 = event.getX();
            y1 = event.getY();
            circle = new Circle();
            circle.setCenterX(x1);
            circle.setCenterY(y1);
            shapeList.add(circle);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            sketchCanvas.getChildren().add(circle);
            }
            else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
               double dx = Math.abs(event.getX() - x1);
               double dy = Math.abs(event.getY() - y1);
               double radius = Math.sqrt(dx*dx + dy*dy);
               circle.setRadius(radius);
            }
            else if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
            {
               circle.setFill(currentFillColor);
               circle.setStroke(currentStrokeColor);
               circle.setStrokeWidth(currentStrokeWidth);
               
            }
            
         } 
         
         if(radioButtonLine.isSelected()) {
            if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            x1 = event.getX();
            y1 = event.getY();
            line = new Line();
            line.setStartX(x1);
            line.setStartY(y1);
            line.setStroke(Color.BLACK);
            shapeList.add(line);
            sketchCanvas.getChildren().add(line);
            }
            else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
               line.setEndX(event.getX());
               line.setEndY(event.getY());
            }
            else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
               line.setFill(Color.BLACK);
               line.setStroke(currentStrokeColor);
               line.setStrokeWidth(currentStrokeWidth);
            }
         }
			// Rectange Example given!
			if (radioButtonRectangle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					rectangle = new Rectangle();
					rectangle.setX(x1);
					rectangle.setY(y1);
					shapeList.add(rectangle);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(rectangle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					rectangle.setWidth(Math.abs(event.getX() - x1));
					rectangle.setHeight(Math.abs(event.getY() - y1));

				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					rectangle.setFill(currentFillColor);
					rectangle.setStroke(currentStrokeColor);
					rectangle.setStrokeWidth(currentStrokeWidth);
				}
			}
		}
	}
		
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 4: Implement the button handler
         
        if(event.getSource() == undoButton){
         if(!shapeList.isEmpty())
        {
               
               
               shapeList.remove(shapeList.size() - 1);
               sketchCanvas.getChildren().remove(shapeList.size(), shapeList.size()+1);
         }
         else {
               for(int i = 0; i < tempList.size(); i++) {
                  shapeList.add(tempList.get(i));
               }
                  tempList.clear();
               for(Shape i: shapeList) {
                  sketchCanvas.getChildren().add(i);
               }
         }
        
         }
         else if(event.getSource() == eraseButton && !shapeList.isEmpty())
         {
            tempList.clear();
            for(int i = 0; i < shapeList.size(); i++) {
               tempList.add(shapeList.get(i));
               sketchCanvas.getChildren().remove(shapeList.get(i));
            }
            shapeList.clear();
         }
		}
	}

	private class ColorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 5: Implement the color handler
         currentFillColor = colors[fillColorCombo.getSelectionModel().getSelectedIndex()];
         currentStrokeColor = colors[strokeColorCombo.getSelectionModel().getSelectedIndex()];
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event){
			// TASK 6: Implement the stroke width handler
         currentStrokeWidth = Integer.parseInt(strokeWidthCombo.getValue());
		}
	}
	
		
	// Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2)  {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}