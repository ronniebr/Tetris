/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;
import ohtyo.*;

/**
 *
 * @author ronniebr
 */
public class Piirturi extends JPanel implements KeyListener {

public void paintComponent(Graphics g) {

// fill with the color you want
int wide = getWidth();
int tall = getHeight();
g.setColor(Color.white);
g.fillRect(0, 0, wide, tall);


// go into Graphics2D for all the fine art, more options
// optional, here I just get variable Stroke sizes
Graphics2D g2 = (Graphics2D) g;
int w = wide / 12;
int h = tall / 25;
g2.setColor(Color.red);

g2.setStroke(new BasicStroke(1));
// the verticles
for (int i = 1; i < 12; i++) {
g2.drawLine(i * w, 0, i * w, tall);
}
// the horizontals
for (int i = 1; i < 25; i++) {
g2.drawLine(0, i * h, wide, i * h);
}

// that will have a little glitch with the integer math
// the grid will have the bottom row slightly larger
// to overcome that, you must use double

g2.setColor(Color.red);
double rowH = getHeight() / 25;
for (int i = 1; i < 25; i++) {
Line2D line = new Line2D.Double(0.0, (double) i * rowH,
(double) getWidth(), (double) i * rowH);
g2.draw(line);
}

}

  public void keyPressed(KeyEvent e) {
  }
  
  public void keyTyped(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }
}
