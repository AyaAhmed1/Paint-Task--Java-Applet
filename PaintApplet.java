import java.applet.Applet;
import java.util.* ;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics; 
import java.applet.*;
 import java.awt.event.*;  
 import java.awt.Graphics;  
 import java.awt.Color;

public class PaintApplet extends Applet  {
    //for line
ArrayList <Integer> x1=new ArrayList();
ArrayList <Integer> y1=new ArrayList();
ArrayList <Integer> x2=new ArrayList();
ArrayList <Integer> y2=new ArrayList();
//for oval
ArrayList <Integer> x_oval=new ArrayList();
ArrayList <Integer> y_oval=new ArrayList();
ArrayList <Integer> x_oval1=new ArrayList();
ArrayList <Integer> y_oval1=new ArrayList();
//for rectangle
ArrayList <Integer> x_rect=new ArrayList();
ArrayList <Integer> y_rect=new ArrayList();
ArrayList <Integer> x_rect1=new ArrayList();
ArrayList <Integer> y_rect1=new ArrayList();

//for freeline
ArrayList<Point> points ;
ArrayList<ArrayList<Point>> freelines = new ArrayList<ArrayList<Point>>();

//for color
ArrayList <Integer> color_line=new ArrayList();
ArrayList <Integer> color_rect=new ArrayList();
ArrayList <Integer> color_oval=new ArrayList();
ArrayList <Integer> color_freeline=new ArrayList();
ArrayList <Integer> color_fillrect=new ArrayList();
ArrayList <Integer> color_filloval=new ArrayList();


//fillrect
ArrayList <Integer> x_frect=new ArrayList();
ArrayList <Integer> y_frect=new ArrayList();
ArrayList <Integer> x_frect1=new ArrayList();
ArrayList <Integer> y_frect1=new ArrayList();

//filloval
ArrayList <Integer> x_foval=new ArrayList();
ArrayList <Integer> y_foval=new ArrayList();
ArrayList <Integer> x_foval1=new ArrayList();
ArrayList <Integer> y_foval1=new ArrayList();

int xtemp;
int ytemp;
int ytemp1;
int xtemp1;

boolean flag_line=false;
//Rectangle Flags
boolean flag_rect=false;
boolean x_r_inc=false;
boolean x_r_dec=false;
boolean y_r_dec=false;
boolean y_r_dec2=false;
//Fill Rectangle Flags
boolean flag_fillrect=false;
boolean x_fr_inc=false;
boolean x_fr_dec=false;
boolean y_fr_dec=false;
boolean y_fr_dec2=false;



//Oval Flags
boolean flag_oval=false;
boolean x_o_inc=false;
boolean x_o_dec=false;
boolean y_o_dec=false;
boolean y_o_dec2=false;

//fill Oval Flags
boolean flag_foval=false;
boolean x_fo_inc=false;
boolean x_fo_dec=false;
boolean y_fo_dec=false;
boolean y_fo_dec2=false;
//FreeLine Flag
boolean flag_free_line=false;
//Colors Flags
int flag_color=4; //default black

     public void init() {
       
        this.addMouseListener (new PressMouse());
        this.addMouseMotionListener(new PressMouse());
       
         Button Line = new Button("Line");
        Line.addActionListener(new LineListener ());
                add(Line);
         Button Oval = new Button("Oval");
        Oval.addActionListener(new OvalListener ());
		add(Oval);
          Button FillOval = new Button("FillOval");
        FillOval.addActionListener(new FillOvalListener ());
		add(FillOval);       
          Button Rectangle = new Button("Rectangle");
        Rectangle.addActionListener(new RectListener());
		add(Rectangle);
          Button FillRectangle = new Button("FillRectangle");
        FillRectangle.addActionListener(new FillRectListener());
		add(FillRectangle);       
       
           Button FreeLine = new Button("FreeLine");
       FreeLine.addActionListener(new FreeLineListener());
		add(FreeLine); 
           Button Blue = new Button("Blue");
       Blue.addActionListener(new BlueListener());
		add(Blue); 
           Button Red= new Button("Red");
       Red.addActionListener(new RedListener());
		add(Red); 
           Button Green= new Button("Green");
       Green.addActionListener(new GreenListener());
		add(Green);  
           Button Black= new Button("Black");
       Black.addActionListener(new BlackListener());
		add(Black);        
       
    }
    public void paint(Graphics g) {
  
               //Array of Lines
             for(int i =0;i<x1.size() ; i++){
                   switch(color_line.get(i))
             {   case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
           g.drawLine((x1.get(i)),y1.get(i),x2.get(i),y2.get(i));    
        }  
             
            //Array of Ovals
        for(int j=0;j<x_oval.size();j++){
               switch(color_oval.get(j))
             {   case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
          g.drawOval(x_oval.get(j),y_oval.get(j),x_oval1.get(j),y_oval1.get(j));
        }
        //Array of filloval
         for(int j=0;j<x_foval.size();j++){
               switch(color_filloval.get(j))
             {   case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
          g.fillOval(x_foval.get(j),y_foval.get(j),x_foval1.get(j),y_foval1.get(j));
        }
        
         //Array of Rects
                for(int r=0; r<x_rect1.size() ; r++){
                    switch(color_rect.get(r)){
                       case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
                         }
                  g.drawRect(x_rect.get(r),y_rect.get(r),x_rect1.get(r),y_rect1.get(r));
              }
                //array of fill rectangles
                     for(int fr=0; fr<x_frect1.size() ; fr++){
                    switch(color_fillrect.get(fr)){
                       case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
                         }
                  g.fillRect(x_frect.get(fr),y_frect.get(fr),x_frect1.get(fr),y_frect1.get(fr));
              } 
                
                
               //Array of feelines
               int zz=0;
                 for (ArrayList<Point> list : freelines) {
                     switch(color_freeline.get(zz)){
                       case 1 :
                      g.setColor(Color.BLUE);
                      break;
                        case 2:
                      g.setColor(Color.RED);
                      break;
                        case 3:
                      g.setColor(Color.GREEN);
                      break;
                       case 4 :
                      g.setColor(Color.BLACK);
                      break;
                         }
                     
                     
               for (int i = 0; i < list.size()-1; i++) {
                    g.drawLine(list.get(i).x, list.get(i).y, list.get(i+1).x, list.get(i+1).y);
                    
             } 
               zz++;
                 }
        
        //Temp drawing
          if(flag_line){
               switch(flag_color)
             {case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
        g.drawLine(xtemp,ytemp,xtemp1,ytemp1);
        }
        if(flag_oval){
              switch(flag_color)
             {case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
            
        if(x_o_inc){
        g.drawOval(xtemp, ytemp,xtemp1-xtemp,ytemp1-ytemp);
        }
        if(x_o_dec){
         g.drawOval(xtemp1, ytemp, xtemp-xtemp1, ytemp1-ytemp);
        }
        if(y_o_dec){
            g.drawOval(xtemp1, ytemp1,xtemp-xtemp1,ytemp-ytemp1);
        }
        if(y_o_dec2){
            g.drawOval(xtemp, ytemp1,xtemp1-xtemp,ytemp-ytemp1);
        }
        }
      //Rectangle Temp Line
      if(flag_rect){
               switch(flag_color)
               { case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
       if(x_r_inc){
          g.drawRect(xtemp, ytemp,xtemp1-xtemp,ytemp1-ytemp);  
        }
        if(x_r_dec){
         g.drawRect(xtemp1, ytemp, xtemp-xtemp1, ytemp1-ytemp);
        }
        if(y_r_dec){
            g.drawRect(xtemp1, ytemp1,xtemp-xtemp1,ytemp-ytemp1);
        }
        if(y_r_dec2){
            g.drawRect(xtemp, ytemp1,xtemp1-xtemp,ytemp-ytemp1);
        }
      }
      //color_filloval
      if(flag_foval){
              switch(flag_color)
             {case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
            
        if(x_fo_inc){
        g.fillOval(xtemp, ytemp,xtemp1-xtemp,ytemp1-ytemp);
        }
        if(x_fo_dec){
         g.fillOval(xtemp1, ytemp, xtemp-xtemp1, ytemp1-ytemp);
        }
        if(y_fo_dec){
            g.fillOval(xtemp1, ytemp1,xtemp-xtemp1,ytemp-ytemp1);
        }
        if(y_fo_dec2){
            g.fillOval(xtemp, ytemp1,xtemp1-xtemp,ytemp-ytemp1);
        }
        }
      
      //fill rec 
      if(flag_fillrect){
               switch(flag_color)
               { case 1 :
                      g.setColor(Color.BLUE);
                      break;
                 case 2:
                      g.setColor(Color.RED);
                      break;
                 case 3:
                      g.setColor(Color.GREEN);
                      break;
                 case 4 :
                      g.setColor(Color.BLACK);
                      break;
             }
       if(x_fr_inc){
          g.fillRect(xtemp, ytemp,xtemp1-xtemp,ytemp1-ytemp);  
        }
        if(x_fr_dec){
         g.fillRect(xtemp1, ytemp, xtemp-xtemp1, ytemp1-ytemp);
        }
        if(y_fr_dec){
            g.fillRect(xtemp1, ytemp1,xtemp-xtemp1,ytemp-ytemp1);
        }
        if(y_fr_dec2){
            g.fillRect(xtemp, ytemp1,xtemp1-xtemp,ytemp-ytemp1);
        }
      }
      
    }     
class PressMouse implements MouseListener,MouseMotionListener{
public void mousePressed(MouseEvent e){
xtemp=e.getX();
ytemp=e.getY();
if(flag_line){
color_line.add(flag_color);}
if(flag_rect){
color_rect.add(flag_color);
 } 
if(flag_oval)
{
  color_oval.add(flag_color);  
}
if(flag_free_line)
{     points = new ArrayList<Point>();
      freelines.add(points);
      points.add(new Point(e.getX(),e.getY()));
      color_freeline.add(flag_color);
}
if(flag_fillrect)
{
  color_fillrect.add(flag_color);  
}
if(flag_foval)
{
    color_filloval.add(flag_color);
}
}
public void mouseMoved(MouseEvent ME) {} 
 
public void mouseDragged(MouseEvent e2)
{   xtemp1=e2.getX();
    ytemp1=e2.getY();
    if(flag_line){
    repaint();
    }
   if(flag_rect) 
        {    
    if((e2.getX()>xtemp)&&(e2.getY()>ytemp))
    {  x_r_inc=true;
       repaint();
    }
    if((xtemp>e2.getX())&&(e2.getY()>ytemp))
          
    {        x_r_dec=true;
             repaint();
             }
    if((e2.getY()<ytemp)&&(e2.getX()<xtemp) ){
        y_r_dec=true;
        repaint();
            }
    if((e2.getY()<ytemp)&&(e2.getX()>xtemp) ){
        y_r_dec2=true;
         repaint();
            }
        }
   if(flag_fillrect) 
        {    
    if((e2.getX()>xtemp)&&(e2.getY()>ytemp))
    {  x_fr_inc=true;
       repaint();
    }
    if((xtemp>e2.getX())&&(e2.getY()>ytemp))
          
    {        x_fr_dec=true;
             repaint();
             }
    if((e2.getY()<ytemp)&&(e2.getX()<xtemp) ){
        y_fr_dec=true;
        repaint();
            }
    if((e2.getY()<ytemp)&&(e2.getX()>xtemp) ){
        y_fr_dec2=true;
         repaint();
            }
        }
  if(flag_oval) {    
    if((e2.getX()>xtemp)&&(e2.getY()>ytemp))
    {  x_o_inc=true;
       repaint();
    }
    if((xtemp>e2.getX())&&(e2.getY()>ytemp))
   {      x_o_dec=true;
          repaint();
             }
    if((e2.getY()<ytemp)&&(e2.getX()<xtemp) ){
        y_o_dec=true;
        repaint();
            }
    if((e2.getY()<ytemp)&&(e2.getX()>xtemp) ){
        y_o_dec2=true;
      
        repaint();
            }
        }
  //Filoval
  if(flag_foval) {    
    if((e2.getX()>xtemp)&&(e2.getY()>ytemp))
    {  x_fo_inc=true;
       repaint();
    }
    if((xtemp>e2.getX())&&(e2.getY()>ytemp))
   {      x_fo_dec=true;
          repaint();
             }
    if((e2.getY()<ytemp)&&(e2.getX()<xtemp) ){
        y_fo_dec=true;
        repaint();
            }
    if((e2.getY()<ytemp)&&(e2.getX()>xtemp) ){
        y_fo_dec2=true;
      
        repaint();
            }
        }
   
   if(flag_free_line)
    {
          points.add(new Point(e2.getX(),e2.getY()));
           //color_freeline.add(flag_color);
           repaint();
    }
    
    repaint();       
}
public void mouseReleased(MouseEvent e1) {
    if(flag_line)
    {
        x1.add(xtemp);
        x2.add(xtemp1);
        y1.add(ytemp);
        y2.add(ytemp1);
        repaint();
    }
    //oval
    if(flag_oval)
    {
        if (x_o_inc){  
      x_oval.add(xtemp);
      x_oval1.add(xtemp1-xtemp);
      y_oval.add(ytemp);
      y_oval1.add(ytemp1-ytemp);
         repaint();
    }if(x_o_dec)
        {  
        color_oval.add(flag_color); 
        x_oval.add(xtemp1);
        x_oval1.add(xtemp-xtemp1);
        y_oval.add(ytemp);
        y_oval1.add(ytemp1-ytemp);
        repaint(); 
        }
     if(y_o_dec)
        {
           color_oval.add(flag_color);   
          x_oval.add(xtemp1);
        x_oval1.add(xtemp-xtemp1);
        y_oval.add(ytemp1);
        y_oval1.add(ytemp-ytemp1);
        repaint();  
        }
     if(y_o_dec2)
     { color_oval.add(flag_color); 
        x_oval.add(xtemp);
        x_oval1.add(xtemp1-xtemp);
        y_oval.add(ytemp1);
        y_oval1.add(ytemp-ytemp1);
        repaint();
        }
      }
    //fill oval
    if(flag_foval)
    {
        if (x_fo_inc){  
      x_foval.add(xtemp);
      x_foval1.add(xtemp1-xtemp);
      y_foval.add(ytemp);
      y_foval1.add(ytemp1-ytemp);
         repaint();
    }if(x_fo_dec)
        {  
        color_filloval.add(flag_color); 
        x_foval.add(xtemp1);
        x_foval1.add(xtemp-xtemp1);
        y_foval.add(ytemp);
        y_foval1.add(ytemp1-ytemp);
        repaint(); 
        }
     if(y_fo_dec)
        {
           color_filloval.add(flag_color);   
          x_foval.add(xtemp1);
        x_foval1.add(xtemp-xtemp1);
        y_foval.add(ytemp1);
        y_foval1.add(ytemp-ytemp1);
        repaint();  
        }
     if(y_fo_dec2)
     { color_filloval.add(flag_color); 
        x_foval.add(xtemp);
        x_foval1.add(xtemp1-xtemp);
        y_foval.add(ytemp1);
        y_foval1.add(ytemp-ytemp1);
        repaint();
        }
      }
    
    if(flag_rect)
    { 
      if (x_r_inc){  
      x_rect.add(xtemp);
      x_rect1.add(xtemp1-xtemp);
      y_rect.add(ytemp);
      y_rect1.add(ytemp1-ytemp);
       repaint();
                }
        if(x_r_dec)
        {
         color_rect.add(flag_color);
        x_rect.add(xtemp1);
        x_rect1.add(xtemp-xtemp1);
        y_rect.add(ytemp);
        y_rect1.add(ytemp1-ytemp);
        repaint(); 
        }
        if(y_r_dec)
        { color_rect.add(flag_color);
          x_rect.add(xtemp1);
        x_rect1.add(xtemp-xtemp1);
        y_rect.add(ytemp1);
        y_rect1.add(ytemp-ytemp1);
        repaint();  
        }
        if(y_r_dec2)
        { color_rect.add(flag_color);
            x_rect.add(xtemp);
        x_rect1.add(xtemp1-xtemp);
        y_rect.add(ytemp1);
        y_rect1.add(ytemp-ytemp1);
        repaint();
        }
    }
    
     if(flag_fillrect)
    { 
      if (x_fr_inc){  
      x_frect.add(xtemp);
      x_frect1.add(xtemp1-xtemp);
      y_frect.add(ytemp);
      y_frect1.add(ytemp1-ytemp);
       repaint();
                }
        if(x_fr_dec)
        {
         color_fillrect.add(flag_color);
        x_frect.add(xtemp1);
        x_frect1.add(xtemp-xtemp1);
        y_frect.add(ytemp);
        y_frect1.add(ytemp1-ytemp);
        repaint(); 
        }
        if(y_fr_dec)
        { color_fillrect.add(flag_color);
          x_frect.add(xtemp1);
        x_frect1.add(xtemp-xtemp1);
        y_frect.add(ytemp1);
        y_frect1.add(ytemp-ytemp1);
        repaint();  
        }
        if(y_fr_dec2)
        { color_fillrect.add(flag_color);
            x_frect.add(xtemp);
        x_frect1.add(xtemp1-xtemp);
        y_frect.add(ytemp1);
        y_frect1.add(ytemp-ytemp1);
        repaint();
        }
    }
    if(flag_free_line)
    {         
                repaint();
    }
}
public void mouseEntered(MouseEvent e1) {}
public void mouseExited(MouseEvent e3) {}
public void mouseClicked(MouseEvent e4) {}



}
  
class LineListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    
    flag_line=true;
    flag_oval=false;
    flag_rect=false;
    flag_free_line=false;
    flag_fillrect=false;
    flag_foval=false;
    
     }
}
class OvalListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    flag_oval=true;
    flag_line=false;
    flag_rect=false;
    flag_free_line=false;
    flag_fillrect=false;
     flag_foval=false;
}
}
class   RectListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    
    flag_rect=true;
    flag_oval=false;
    flag_line=false;
    flag_free_line=false;
    flag_fillrect=false;
     flag_foval=false;
    
    
}
}

class FreeLineListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    
    flag_rect=false;
    flag_oval=false;
    flag_line=false;
    flag_free_line=true;
    flag_fillrect=false;
     flag_foval=false;
    }
} 

 class FillRectListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    
    flag_rect=false;
    flag_oval=false;
    flag_line=false;
    flag_free_line=false;
    flag_fillrect=true;
     flag_foval=false;
    }
}        

class FillOvalListener  implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    flag_rect=false;
    flag_oval=false;
    flag_line=false;
    flag_free_line=false;
    flag_fillrect=false;
    flag_foval=true;
  
}
}

class BlueListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    flag_color=1;
  
}
}        
        
class RedListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
flag_color=2;
}
}
class GreenListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
 flag_color=3;   
  
}
}
class BlackListener implements ActionListener{
public void actionPerformed (ActionEvent ev2) {
    
 flag_color=4;
}
}
}







