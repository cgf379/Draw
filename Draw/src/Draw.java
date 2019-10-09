import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Draw extends JFrame{
	private static final int LEFT = 0;
	private DrawListener dl;
	private Graphics g;
	//保存图形对象的集合
	private List<NetJavaShape> shapesArray=new ArrayList<NetJavaShape>();
	//界面初始化
	public void showUI() {
		setTitle("画图");//窗体名称
        setSize(1200, 900);//窗体大小
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);//窗体居中
                //流式布局左对齐
       BorderLayout layout=new BorderLayout();
        setLayout(layout);//窗体使用流式布局管理器
        this.setResizable(false);//窗体大小不变
        
        //使用数组保存按钮名
        String buttonName[] = { "画直线", "画椭圆", "画曲线", "多边形", 
                  "橡皮擦", "拖动线","三角形", "画球形", "笔刷", "喷枪", 
                  "色子", "立体矩形", "立体圆", "立体三角","迭代分形",
                   "现代分形", "枫叶", "画树", "mandelbrot集", "L-System",
                  "迭代画线","迭代三角形", "谢尔宾斯基地毯", "画字符", "清空",
                  "吸管" ,"矩形","五角星","多线","字符"};
                //用于保存图形按钮，使用网格布局
        JPanel jp1=new JPanel(new GridLayout(15, 2,5,5));
        jp1.setPreferredSize(new Dimension(200, 600));
        
        //实例化DrawListener对象
        dl=new DrawListener();
        //循环为按钮面板添加按钮
        for (int i = 0; i < buttonName.length; i++) {
            JButton jbutton = new JButton(buttonName[i]);
            jbutton.addActionListener(dl);//为按钮添加监听
            jp1.add(jbutton);
        }
        
        JPanel jp2=new JPanel();//画布面板
        jp2.setPreferredSize(new Dimension(800, 600));
        jp2.setBackground(Color.WHITE);
        

        // 定义Color数组，用来存储按钮上要显示的颜色信息
        Color[] colorArray = { Color.BLUE, Color.GREEN, Color.RED, 
                        Color.BLACK,Color.ORANGE,Color.PINK,Color.CYAN,
                        Color.MAGENTA,Color.DARK_GRAY,Color.GRAY,
                        Color.LIGHT_GRAY,Color.YELLOW};
        //用于保存颜色按钮的面板
		JPanel jp3=new JPanel(new GridLayout(1,colorArray.length+1,3,3));
		//循环遍历colorArray数组，根据数组中的元素来实例化按钮对象
		for(int i=0;i<colorArray.length;i++) {
			JButton colorBtn=new JButton();
			colorBtn.setBackground(colorArray[i]);
			colorBtn.setPreferredSize(new Dimension(30,30));
			colorBtn.addActionListener(dl);
			jp3.add(colorBtn);
		}
		
		//菜单
		String menu[]= {"创建","打开","保存","修改"} ;
		JPanel jp4=new JPanel(new GridLayout(1,menu.length,3,3));//菜单栏面板
		 //实例化DrawListener对象
        dl=new DrawListener();
		for(int i=0;i<menu.length;i++) {
			JButton btn_menu=new JButton(menu[i]);
			btn_menu.addActionListener(dl);//为按钮添加监听
			jp4.add(btn_menu);
		}
		JPanel jp5=new JPanel(new FlowLayout(LEFT));
		jp5.add(jp4);
		JPanel jp6=new JPanel(new FlowLayout(LEFT));
		jp6.add(jp3);
		
			
			//将面板放到主窗体
			
			this.add(jp1,BorderLayout.WEST);
			this.add(jp2,BorderLayout.CENTER);
			this.add(jp6,BorderLayout.SOUTH);
			this.add(jp5,BorderLayout.NORTH);
			//添加按钮，作为当前颜色
			JButton newcolor=new JButton();
			newcolor.setPreferredSize(new Dimension(40,40));
			newcolor.setBackground(Color.BLACK);//默认黑色
			jp3.add(newcolor);
			this.setVisible(true);
			//获取画笔对象
			g=jp2.getGraphics();
			dl.setG(g);
			dl.setNowColor(newcolor);
			//获取保存的集合
			shapesArray=dl.getShapesArray();
			//为画图板添加鼠标监听，用于绘制图形
			jp2.addMouseListener(dl);
			jp2.addMouseMotionListener(dl);
		}
	//重写paint方法
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//foreach遍历集合
		for(NetJavaShape l : shapesArray) {
			l.draw();
		}
	}
}


