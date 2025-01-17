package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.animation.Animation;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener
{

    public static Laberinto l;
    public static Gamer jugador;
    public static float cx, cy, cz;
    public static float cux, cuy, cuz;
    public float lim_sup_x, lim_sup_z;
    public float lim_inf_x, lim_inf_z;
    public static int option; //opcion de camara para poder entrar al laberinto
//    public static Camera cam;

    public void main()
    {

        Frame ventana = new Frame("OGL APP"); //Metodo clase Frame

        ventana.setSize(1000, 700);//Tamano De La ventana
        ventana.addWindowListener(new WindowAdapter()
        { //Manejador de ventanas de abrir y cerrar

            public void WindowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        GLCanvas canvas = new GLCanvas(); //Obj de tipo canvas que nos permite dibujar
        ventana.add(canvas);

        canvas.addGLEventListener(new GLRenderer());

        //Creamos la animacion 
        //Con un objeto que se ejecute a 60 FPS
        Animator animador = new FPSAnimator(canvas, 60);
        animador.add(canvas);
        animador.start();

        ventana.setVisible(true);

        //Pulsacion de teclas 
        Keyboard keylistener = new Keyboard(canvas);
        canvas.addKeyListener(keylistener);
    }

    public void init(GLAutoDrawable drawable)
    {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

//        Camera cam = new Camera(1, 0, -2, 0, 90, 0,
//                70, (float) Display.getWidth() / (float) Display.getHeight(), 0.3f, 500);
        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
        gl.glEnable(gl.GL_DEPTH_TEST);//Generamos test de profundidad.

        l = new Laberinto(gl, 0.0f, 0.0f, 0f, 1f, 1f, 1, 1f, 1f, 1f);//Generamos nuevo laberinto.
        jugador = new Gamer(gl, 0, 0.4f, 2f, 0.03f, 0.01f, 0.01f, 1f, 1f, 1f);
        cx = 1f;
        cx = 1f;
        cy = 10f;
        cz = 0f;

        // cam = new Camera(1, 0, -2, 0, 90, 0, gl);
        option = 1;
        lim_sup_x = 4f;
        lim_sup_z = 2.75f;
        lim_inf_x = -1f;
        lim_inf_z = -2f;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0)
        { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable)
    {
//        GL gl = drawable.getGL();
//        GLU glu = new GLU();
//        // Clear the drawing area
//        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
//        // Reset the current matrix to the "identity"
//        gl.glLoadIdentity();
//
//        // Move the "drawing cursor" around
//        //  gl.glTranslatef(-1.5f, 0.0f, -6.0f);
//        glu.gluLookAt(cx, cy, cz, 0f, 0f, 0f, 0f, 1f, 0f);
////        GLUT glut;
////        glut = new GLUT();
////        gl.glTranslatef(cux, cuy, cuz);
////        glut.glutSolidCube(0.4f);
//
//        l.DrawFloor();
//        jugador.drawGamer();
//        // Flush all drawing operations to the graphics card
//        //gl.glFlush();
        update();
        render(drawable);
    }

    public void update()
    {
        jugador.update();
    }

    public void render(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
//        float light_ambient[] =
//        {
//            0.9f, 0.9f, 0.9f, 1.0f
//        };
//        float light_diffuse[] =
//        {
//            0.3f, 0.3f, 0.3f, 1.0f
//        };
//        float light_specular[] =
//        {
//            0.0f, 0.0f, 0.0f, 0.0f
//        };
//        float light_position[] =
//        {
//            1.0f, 1.5f, 1.0f, 0.0f
//        };
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
//        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);

        l.DrawFloor();
        jugador.drawGamer();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45f, 1f, 0.2f, 20f);
        switch (option)
        {
            case 1:
                glu.gluLookAt(cx, cy, cz, 0f, 0f, 0f, 0f, 1f, 0f);

                break;
            case 2:
                glu.gluLookAt(jugador.getX(), jugador.getY() - 0.1f,
                        jugador.getZ(), jugador.getX() + Math.cos(jugador.angle)
                        * 2.0f, jugador.getY(), jugador.getZ(), jugador.getX(),
                        jugador.getY() - 0.1f, jugador.getZ());
                break;
            default:
                System.out.println("Bienvenido! :D");
        }

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

}
