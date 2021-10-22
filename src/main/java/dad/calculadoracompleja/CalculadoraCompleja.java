package dad.calculadoracompleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application{
	//Declaracion de variables
	private TextField numReal1TextField,numImaginario1TextField,numReal2TextField,numImaginario2TextField,
	numRealResultadoTextField,numImaginarioResultadoTextField;
	private Label suma1,suma2,suma3,i1,i2,i3,espacioLabel;
	private Separator separador=new Separator();
	private Button boton;
	
	Complejo complejo1,complejo2,complejoResultado;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		complejo1=new Complejo();
		complejo2=new Complejo();
		complejoResultado=new Complejo();
		
		//inicializacion de variables
		numReal1TextField=new TextField();
		numReal1TextField.setPrefWidth(50);
		numImaginario1TextField=new TextField();
		numImaginario1TextField.setPrefWidth(50);
		numReal2TextField=new TextField();
		numReal2TextField.setPrefWidth(50);
		numImaginario2TextField=new TextField();
		numImaginario2TextField.setPrefWidth(50);
		numRealResultadoTextField=new TextField();
		numRealResultadoTextField.setPrefWidth(50);
		numRealResultadoTextField.setEditable(false);
		numImaginarioResultadoTextField=new TextField();
		numImaginarioResultadoTextField.setPrefWidth(50);
		numImaginarioResultadoTextField.setEditable(false);
		suma1=new Label("+");
		suma2=new Label("+");
		suma3=new Label("+");
		i1=new Label("i");
		i2=new Label("i");
		i3=new Label("i");
		espacioLabel=new Label("     ");
		separador=new Separator();
		separador.setPrefWidth(120);
		ObservableList<String> operaciones = FXCollections.observableArrayList();
		operaciones.addAll("+","-","*","/");
		ComboBox<String> combo = new ComboBox<>(operaciones);
		boton=new Button("Ejecutar");
		
		
		//primer numero complejo
		HBox numComplejo1= new HBox(numReal1TextField,suma1,numImaginario1TextField,i1);
		numComplejo1.setAlignment(Pos.CENTER);
		numComplejo1.setSpacing(5);
		
		//segundo numero complejo
		HBox numComplejo2=new HBox(numReal2TextField,suma2,numImaginario2TextField,i2);
		numComplejo2.setAlignment(Pos.CENTER);
		numComplejo2.setSpacing(5);
		
		//numero complejo resultado
		HBox numComplejo3=new HBox(numRealResultadoTextField,suma3,numImaginarioResultadoTextField,i3);
		numComplejo3.setAlignment(Pos.CENTER);
		numComplejo3.setSpacing(5);
		
		//zona de la izquierda , combo y espacio
		HBox espacio=new HBox(espacioLabel,combo);
		espacio.setSpacing(40);
		espacio.setAlignment(Pos.CENTER);
		
		//zona de operacion
		VBox vboxCentro=new VBox(numComplejo1,numComplejo2, separador,numComplejo3);
		vboxCentro.setAlignment(Pos.CENTER);
		vboxCentro.setSpacing(5);
		
	
		
		//zona del combo entera
		VBox vboxIzquierda =new VBox(espacio);
		vboxIzquierda.setAlignment(Pos.CENTER);
		vboxIzquierda.setSpacing(40);
		
		//imagen entera de la escena
		HBox root=new HBox(vboxIzquierda,vboxCentro,boton);
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		
		//vista
		Scene scene = new Scene(root, 320, 240);
		
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
		Bindings.bindBidirectional(numReal1TextField.textProperty(), complejo1.numRealProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(numImaginario1TextField.textProperty(), complejo1.numImaginarioProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(numReal2TextField.textProperty(), complejo2.numRealProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(numImaginario2TextField.textProperty(), complejo2.numImaginarioProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(numRealResultadoTextField.textProperty(), complejoResultado.numRealProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(numImaginarioResultadoTextField.textProperty(), complejoResultado.numImaginarioProperty(), new NumberStringConverter());
		combo.getSelectionModel().selectFirst();
		String operacionElegida= combo.getSelectionModel().getSelectedItem().toString();
		

		boton.setOnAction(e -> Operaciones(operacionElegida));
		
	}

	private void Operaciones(String operacionElegida) {
		
		switch (operacionElegida) {
		case "+":
			complejoResultado.setComplejo(complejo1.sumaComplejo(complejo2));
			break;
		case "-":
			complejoResultado.setComplejo(complejo1.restaComplejo(complejo2));
			break;
		case "*":
			complejoResultado.setComplejo(complejo1.multiplicacionComplejo(complejo2));
			
			break;
		case "/":
			complejoResultado.setComplejo(complejo1.divisionComplejo(complejo2));
			
			break;
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	

	

}
