import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Window;
import java.awt.KeyboardFocusManager;
import javax.imageio.ImageIO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.jna.Native;


import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;


// getAllWindows

public class main {

    private static final int MAX_TITLE_LENGTH = 1024;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

    String current = "", past = "";

    public void robo()
    {
        try {
            Calendar now = Calendar.getInstance();
            char[] buffer = new char[MAX_TITLE_LENGTH * 2];
            HWND hwnd = User32.INSTANCE.GetForegroundWindow();
            User32.INSTANCE.GetWindowText(hwnd, buffer, MAX_TITLE_LENGTH);
            System.out.println("Active window title: " + Native.toString(buffer));
            current = Native.toString(buffer);

            if(!past.equals(current)){
                past = Native.toString(buffer);
                RECT rect = new RECT();
                User32.INSTANCE.GetWindowRect(hwnd, rect);
                System.out.println("rect = " + rect);
                System.out.println(formatter.format(now.getTime()));
                Robot robot = new Robot();
                BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ImageIO.write(screenShot, "JPG", new File("D:\\workflowTest\\" + formatter.format(now.getTime()) + ".jpg"));
            }


        }catch(Exception e){
            System.err.println(e);
        }
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
