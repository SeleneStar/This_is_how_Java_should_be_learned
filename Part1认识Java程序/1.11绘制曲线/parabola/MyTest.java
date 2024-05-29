//parabola
import java.awt.*;

public class MyTest{
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(500, 400);
        f.setBackground(Color.BLACK);

        Parabola p = new Parabola();
        f.add(p);

        f.setVisible(true);
    }
}

class Parabola extends Panel {
    private static final long serialVersionUID = -1616773050265562622L;
    Image image;
    int width = 500;
    int height = 400;

    public void paint(Graphics g) {
        // 用红色来填充清除指定的矩形。
        g.clearRect(0, 0, width, height);
        g.setColor(Color.red);
        double x, y, r;
        // 笛卡儿数学公式: (x*x+y*y-2ax)2=4a*a(x*x+y*y)
        for (int i = 0; i <= 90; i++)
            for (int j = 0; j <= 90; j++) {
                r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + height / 4;
                g.fillOval((int) x, (int) y, 2, 2);
            }
        g.drawImage(image, 0, 0, Color.BLACK, this);
    }
}