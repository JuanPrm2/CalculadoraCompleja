package dad.calculadoracompleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty numReal = new SimpleDoubleProperty(0);
	private DoubleProperty numImaginario = new SimpleDoubleProperty(0);
	
	public  DoubleProperty numRealProperty() {
		return this.numReal;
	}
	
	public  double getNumReal() {
		return this.numRealProperty().get();
	}
	
	public  void setNumReal(final double numReal) {
		this.numRealProperty().set(numReal);
	}
	
	public  DoubleProperty numImaginarioProperty() {
		return this.numImaginario;
	}
	
	public  double getNumImaginario() {
		return this.numImaginarioProperty().get();
	}
	
	public  void setNumImaginario(final double numImaginario) {
		this.numImaginarioProperty().set(numImaginario);
	}
	
	@Override
	public String toString() {
		return getNumReal() + "+" +  getNumImaginario() + "i";
	}

	public void setComplejo(Complejo c) {
		this.numRealProperty().bind(c.numRealProperty());;
		this.numImaginarioProperty().bind(c.numImaginarioProperty());
	}
	
	public Complejo sumaComplejo(Complejo c) {
		Complejo suma = new Complejo();
		suma.numRealProperty().bind(numReal.add(c.numRealProperty()));
		suma.numImaginarioProperty().bind(numImaginario.add(c.numImaginarioProperty()));
		return suma;
	}
	public Complejo restaComplejo(Complejo c) {
		Complejo resta = new Complejo();
		resta.numRealProperty().bind(numReal.subtract(c.numRealProperty()));
		resta.numImaginarioProperty().bind(numImaginario.subtract(c.numImaginarioProperty()));
		return resta;
	}
	
	public Complejo multiplicacionComplejo(Complejo c) {
		Complejo multiplicacion=new Complejo();
		multiplicacion.numRealProperty().bind(numRealProperty().multiply(c.numRealProperty())
				.subtract(numImaginarioProperty().multiply(c.numImaginarioProperty())));
		multiplicacion.numImaginarioProperty().bind(numRealProperty().multiply(c.numImaginarioProperty()
				.add(numImaginarioProperty().multiply(c.numRealProperty()))));
		return multiplicacion;
	}
	public Complejo divisionComplejo(Complejo c) {
		Complejo division=new Complejo();
		division.numRealProperty().bind((numRealProperty().multiply(c.numRealProperty()).add(numImaginarioProperty().multiply(c.numImaginarioProperty()))
				.divide(c.numRealProperty().multiply(c.numRealProperty()).add(c.numImaginarioProperty().multiply(c.numImaginarioProperty())))));
		division.numImaginarioProperty().bind((numImaginarioProperty().multiply(c.numRealProperty()).subtract(numRealProperty().multiply(c.numImaginarioProperty()))
				.divide(c.numRealProperty().multiply(c.numRealProperty()).add(c.numImaginarioProperty().multiply(c.numImaginarioProperty())))));
		return division;
		
	}
	
	
}
