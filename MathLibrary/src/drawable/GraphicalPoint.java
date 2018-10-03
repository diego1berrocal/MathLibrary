/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package drawable;

import java.awt.Color;
import java.awt.Graphics;

import draw.CoordinateAxis;
import draw.Drawable;
import draw.MathViewerConstants;
import space.Point;

public class GraphicalPoint extends Point implements Drawable{

	private int SIZE=7;
	private CoordinateAxis axis;
	public GraphicalPoint(double x, double y,CoordinateAxis axis) {
		super(x, y);
		this.axis = axis;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
	
		g.fillOval((int)(CoordinateAxis.MARGIN+(getX()-SIZE/2)*axis.getDefaultXAxis()/(double)axis.getXAxis()), MathViewerConstants.HEIGHT_SCREEN- (int)((getY()-SIZE/2)*axis.getDefaultYAxis()/(double)axis.getYAxis())-CoordinateAxis.MARGIN, SIZE, SIZE);
		
	}
	
}