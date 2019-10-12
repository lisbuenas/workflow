import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

    public void robo() throws Exception
    {
        Calendar now = Calendar.getInstance();
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", new File("I:\\workflowTest\\"+formatter.format(now.getTime())+".jpg"));
        System.out.println(formatter.format(now.getTime()));
    }

    public static void main(String[] args) throws Exception
    {
        main s2i = new main();
        while(1==1)
        {
            s2i.robo();
            Thread.sleep(10000);
        }
    }
}
