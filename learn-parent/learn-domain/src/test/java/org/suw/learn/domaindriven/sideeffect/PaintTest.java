package org.suw.learn.domaindriven.sideeffect;

import static org.junit.Assert.*;

import org.junit.Test;
import org.suw.learn.domaindriven.sideeffect.PigmentColor;
import org.suw.learn.domaindriven.sideeffect.StockPaint;

public class PaintTest {
	
	@Test
	public void testMixingVolume() {
		PigmentColor yellow = new PigmentColor(0, 50, 0);
		PigmentColor blue = new PigmentColor(0, 0, 50);
		StockPaint paint1 = new StockPaint(1.0, yellow);
		StockPaint paint2 = new StockPaint(1.5, blue);
		MixedPaint mix = new MixedPaint();
		mix.mixIn(paint1);
		mix.mixIn(paint2);
		assertEquals(2.5, mix.getVolume(), 0.01);
		
		
	}
}
