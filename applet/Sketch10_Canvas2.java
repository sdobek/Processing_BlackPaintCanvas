import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Sketch10_Canvas2 extends PApplet {


int[][] canvas = new int[100][100];
int current;
PFont myFont;
String caption;
int fontColor;

/*draws with the mouse, using color selectors at the
bottom of the screen.  Colors overlap adn form new shades*/

public void setup(){
  size(400,550);
  background(0);
  rectMode(CORNER);
  for (int i = 0; i < 100; i++){
     for(int j = 0; j < 100; j++){ 
       canvas[i][j] = color(0);
     } 
  }
  current = color(76, 0, 0);
  noStroke();
  myFont = createFont("FFScala", 32);
  textFont(myFont);
  fontColor = color(255,0,0);
  caption = "Current Font: Red";
}

public void draw(){
  background(0);
  noStroke();
  for (int i = 0; i < 50; i++){
     for(int j = 0; j < 50; j++){ 
       fill(canvas[i][j]);
       pushMatrix();
       translate(i*8, j*8);
       rect(0, 0, 8, 8);
       popMatrix();
     } 
  }
  fill(255,0,0);
  pushMatrix();
  translate(0,400);
  rect(0, 0, 100, 100);
  popMatrix();
  
  fill(0,255,0);
  pushMatrix();
  translate(150,400);
  rect(0, 0, 100, 100);
  popMatrix();
  
  fill(0,0,255);
  pushMatrix();
  translate(300,400);
  rect(0, 0, 100, 100);
  popMatrix();
  
  fill(fontColor);
  pushMatrix();
  translate(0, 500);
  text(caption, 0, 0, 400, 90);
  popMatrix();
}

public void mouseDragged() 
{
  int x = mouseX/8;
  int y = mouseY/8;
  if (mouseX < width && mouseX >= 0
        && mouseY < height && mouseY >= 0){
        int newRed = (int)(red(current) 
                          + red(canvas[x][y]));
          int newGreen = (int)(green(current) 
                          + green(canvas[x][y]));
          int newBlue = (int)(blue(current) 
                          + blue(canvas[x][y]));
        canvas[x][y]= color(newRed,newGreen,newBlue);
   }
}

public void mousePressed(){
  int x = mouseX/8;
  int y = mouseY/8;
  if (mouseX < width && mouseX >= 0
        && mouseY < 400 && mouseY >= 0){
          int newRed = (int)(red(current) 
                          + red(canvas[x][y]));
          int newGreen = (int)(green(current) 
                          + green(canvas[x][y]));
          int newBlue = (int)(blue(current) 
                          + blue(canvas[x][y]));
        canvas[x][y]= color(newRed,newGreen,newBlue);
   }
   else if (mouseX >= 0 && mouseX <= 100 &&
             mouseY >= 400 && mouseY <= 600){
        current = color(76,0,0);   
        fontColor = color(255,0,0);
        caption = "Current Font: Red";        
    }
    else if (mouseX >= 150 && mouseX <= 250 &&
             mouseY >= 400 && mouseY <= 600){
        current = color(0,76,0);   
        fontColor = color(0,255,0);
        caption = "Current Font: Green";        
    }
    else if (mouseX >= 300 && mouseX <= 400 &&
             mouseY >= 400 && mouseY <= 600){
        current = color(0,0,76);        
        fontColor = color(0,0,255);
        caption = "Current Font: Blue";   
    }
}

public void keyPressed(){
  if (key == 'c' || key == 'C'){ //clears the drawing
        for (int i = 0; i < 100; i++){
           for(int j = 0; j < 100; j++){ 
             canvas[i][j] = color(0);
           } 
        }
  }
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "Sketch10_Canvas2" });
  }
}
