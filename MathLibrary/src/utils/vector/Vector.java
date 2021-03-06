/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package utils.vector;

import utils.matrix.Matrix;

public class Vector {
	private double[]values;
	public Vector(double[]values) {
		this.values = values;	
	}
	public Vector(double x,double y,double z) {
		values= new double[3];
		values[0]=x;
		values[1]=y;
		values[2]=z;
	}
	public Vector(double x, double y) {
		values= new double[2];
		values[0]=x;
		values[1]=y;
	}
	public Vector(int size) {
		values = new double[size];
	}
	public void fillZero() {
		for(int i=0;i<values.length;i++) {
			values[i]=0;
		}
	}
	public void fillOne() {
		for(int i=0;i<values.length;i++) {
			values[i]=1;
		}
	}
	public void fillRandom() {
		for(int i=0;i<values.length;i++) {
			values[i]=Math.random();
		}
	}
	public Vector add(Vector v2) {
		Vector v = new Vector(getSize());
		for(int i=0;i<values.length;i++) {
			v.setValue(i, this.getValue(i)+v2.getValue(i));
		}
		return v;
	}
	public Vector substract(Vector v2) {
		Vector v = new Vector(getSize());
		for(int i=0;i<values.length;i++) {
			v.setValue(i, this.getValue(i)-v2.getValue(i));
		}
		return v;
	}
	/**
	 * Get new unit vector
	 *
	 * 
	 * 
	 * @return unit vector
	 */
	public Vector getUnitVector() {
		Vector v = new Vector(getSize());
		double distance=getDistance();
		for(int i=0;i<values.length;i++) {
			v.setValue(i,values[i]/distance );
		}
		return v;
	}
	/**
	 * Distance in every dimension respectively to the origin. The same as module
	 *
	 * 
	 * 
	 * @return distance measured in pixels
	 */
	public double getDistance() {
		double sum=0;
		for(int i=0;i<getSize();i++) {
			sum+=i*i;
		}
		return Math.sqrt(sum);
	}
	/**
	 * Angle between the vector of the X axis and this vector
	 *
	 * 
	 * 
	 * @return angle - the angle in radians. Also known as the slope of the vector
	 */
	public double angleXAsis() {
		if(is2D()) {
		return Math.atan(values[1]/values[0]);
		}else {
		try {
			throw new VectorException("Vector is not 2 dimensions", getReference(this));
		} catch (VectorException e) {
		}
		}
		return 0;
		
	}
	public double angleBetween(Vector v2) {
		double angle=0;
		if(is2D()) {
			angle=Math.acos(dotProduct(v2)/(getModule()*v2.getModule()));
		}else {
		try {
			throw new VectorException("Vector is not 2 dimensions", getReference(this));
		} catch (VectorException e) {
		}
		}
		return angle;
		
	}
	public double vectorialProduct(Vector v2) {
		double vectorialProduct=0;
		if(is2D()) {
			double angle=angleBetween(v2);
			vectorialProduct=Math.sin(angle)*getModule()*v2.getModule();
		}else {
		try {
			throw new VectorException("Vector is not 2 dimensions", getReference(this));
		} catch (VectorException e) {
		}
		}
		return vectorialProduct;
	}
	public Matrix convertToMatrix() {
		Matrix m = new Matrix(getSize(), 1);
		for(int i=0;i<getSize();i++) {
			m.setValue(i, 0, values[i]);
		}
		return m;
	}
	public double dotProduct(Vector v2) {
		return values[0]*v2.getValue(0)+values[1]*v2.getValue(1);
	}
	public String getReference(Object o) {
		return (Integer.toHexString(System.identityHashCode(o)));
	}
	public boolean is2D() {
		return (getSize()==2)?true:false;
	}
	public boolean is3D() {
		return (getSize()==3)?true:false;
	}
	public double getModule() {
		return getDistance();
	}
	public void printVector() {
		System.out.println("-----------------");
		System.out.println("Printing vector: #" + getReference(this) + "#");

		for (int i = 0; i < getSize(); i++) {

			System.out.print("|");

			System.out.print(getValue(i));
			System.out.println("|");
		}
		System.out.println("-----------------");
	}
	public int getSize() {
		return this.values.length;
	}
	public void setValue(int pos,double value) {
		values[pos]=value;
	}
	public double getValue(int pos) {
		return values[pos];
	}
}
