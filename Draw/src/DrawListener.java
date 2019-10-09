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
    private Color color=Color.BLACK;//��ɫ����,��ʼֵΪ��ɫ
    private Graphics g;//��������
    private String str;//���水ť�ϵ��ַ��������ֲ�ͬ�İ�ť
    private int x1,y1,x2,y2;//(x1,y1),(x2,y2)�ֱ�Ϊ���İ��º��ͷ�ʱ������
    private JButton nowColor;//��ǰ��ɫ��ť
 
    //����ͼ�ζ���ļ���
    private List<NetJavaShape> shapesArray = new ArrayList<NetJavaShape>();
    //ͼ��
    private NetJavaShape shape;
    //��draw���л�ȡ����
    public List<NetJavaShape> getShapesArray() {
        return shapesArray;
    }
    //��ȡDraw��Ļ��ʶ���
    public void setG(Graphics g) {
        this.g = g;
    }
    //��ȡ��ǰ��ɫ��ť
    public void setNowColor(JButton nowColor) {
        this.nowColor = nowColor;
    }


    @Override
    //����϶��ķ���
    public void mouseDragged(MouseEvent e) {
        //�����ߵķ���
        if ("������".equals(str)) {
            int x, y;
            x = e.getX();
            y = e.getY();
            //ʵ������������Ҳ��ֱ�߻������Բ�ͬ�½�һ����������
            shape=new ImpLine(g,x,y,x1,y1,color);
            //���û�ͼ����
            shape.draw();
            //��ͼ�δ��뼯����
            shapesArray.add(shape);
//            g.drawLine(x, y, x1, y1);
            x1 = x;
            y1 = y;
        }
       
    }

    @Override
    //����ƶ�����
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    //��굥������
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    //��갴�·���
    public void mousePressed(MouseEvent e) {
        
        g.setColor(color);//�ı仭�ʵ���ɫ
        
        x1=e.getX();//��ȡ����ʱ����x����
        y1=e.getY();//��ȡ����ʱ����y����
    }

    @Override
    //����ͷŷ���
    public void mouseReleased(MouseEvent e) {
        x2=e.getX();//��ȡ�ͷ�ʱ����x����
        y2=e.getY();//��ȡ�ͷ�ʱ����y����
        //��ֱ�ߵķ���
        if ("��ֱ��".equals(str)) {
            //ʵ��������
            shape=new ImpLine(g,x1,y1,x2,y2,color);
            //���û�ͼ����
            shape.draw();
            //��ͼ�δ��뼯����
            shapesArray.add(shape);
//            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    //�����뷽��
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    //����˳�����
    public void mouseExited(MouseEvent e) {

    }

    @Override
    //������ť�ϵ����������
    public void actionPerformed(ActionEvent e) {
    	
    	 if("�½�".equals(str)) {
         	System.err.println("dfasdf");
         }
        
        if ("".equals(e.getActionCommand())) {
            JButton jb = (JButton) e.getSource();
            color = jb.getBackground();
            nowColor.setBackground(color);//������ǰ��ɫ
        } else {
            str = e.getActionCommand();
        }
        
       
    }

}