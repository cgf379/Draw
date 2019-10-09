import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DrawListener implements ActionListener, MouseListener,
        MouseMotionListener {
    private Color color=Color.BLACK;//颜色属性,初始值为黑色
    private Graphics g;//画笔属性
    private String str;//保存按钮上的字符串，区分不同的按钮
    private int x1,y1,x2,y2;//(x1,y1),(x2,y2)分别为鼠标的按下和释放时的坐标
    private JButton nowColor;//当前颜色按钮
 
    //保存图形对象的集合
    private List<NetJavaShape> shapesArray = new ArrayList<NetJavaShape>();
    //图形
    private NetJavaShape shape;
    //在draw类中获取集合
    public List<NetJavaShape> getShapesArray() {
        return shapesArray;
    }
    //获取Draw类的画笔对象
    public void setG(Graphics g) {
        this.g = g;
    }
    //获取当前颜色按钮
    public void setNowColor(JButton nowColor) {
        this.nowColor = nowColor;
    }


    @Override
    //鼠标拖动的方法
    public void mouseDragged(MouseEvent e) {
        //画曲线的方法
        if ("画曲线".equals(str)) {
            int x, y;
            x = e.getX();
            y = e.getY();
            //实例化对象，曲线也是直线画的所以不同新建一个曲线类了
            shape=new ImpLine(g,x,y,x1,y1,color);
            //调用画图方法
            shape.draw();
            //将图形存入集合中
            shapesArray.add(shape);
//            g.drawLine(x, y, x1, y1);
            x1 = x;
            y1 = y;
        }
       
    }

    @Override
    //鼠标移动方法
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    //鼠标单击方法
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    //鼠标按下方法
    public void mousePressed(MouseEvent e) {
        
        g.setColor(color);//改变画笔的颜色
        
        x1=e.getX();//获取按下时鼠标的x坐标
        y1=e.getY();//获取按下时鼠标的y坐标
    }

    @Override
    //鼠标释放方法
    public void mouseReleased(MouseEvent e) {
        x2=e.getX();//获取释放时鼠标的x坐标
        y2=e.getY();//获取释放时鼠标的y坐标
        //画直线的方法
        if ("画直线".equals(str)) {
            //实例化对象，
            shape=new ImpLine(g,x1,y1,x2,y2,color);
            //调用画图方法
            shape.draw();
            //将图形存入集合中
            shapesArray.add(shape);
//            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    //鼠标进入方法
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    //鼠标退出方法
    public void mouseExited(MouseEvent e) {

    }

    @Override
    //处理按钮上的鼠标点击动作
    public void actionPerformed(ActionEvent e) {
    	
    	 if("新建".equals(str)) {
         	System.err.println("dfasdf");
         }
        
        if ("".equals(e.getActionCommand())) {
            JButton jb = (JButton) e.getSource();
            color = jb.getBackground();
            nowColor.setBackground(color);//处理当前颜色
        } else {
            str = e.getActionCommand();
        }
        
       
    }

}
