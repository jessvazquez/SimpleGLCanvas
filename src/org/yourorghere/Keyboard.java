/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author deivi
 */
class Keyboard implements KeyListener
{

    private GLCanvas canvas;
    public boolean[] keybuffer;

    GLU glu = new GLU();

    Keyboard(GLCanvas canvas)
    {
        this.canvas = canvas;
        keybuffer = new boolean[256];
    }

    public void keyTyped(KeyEvent e)
    {

        if (keybuffer['w'])
        {
            //  GLRenderer.jugador.avanzar();
        }
        if (keybuffer['a'])
        {
            //  GLRenderer.jugador.avanzar();
        }
        if (keybuffer['s'])
        {
            //  GLRenderer.jugador.avanzar();
        }
        if (keybuffer['d'])
        {
            //  GLRenderer.jugador.avanzar();
        }
        if (e.getKeyChar() == 'p')
        {
            GLRenderer.option = 1;
            if (e.getKeyChar() == 'o')
            {
                GLRenderer.option = 2;
            }
        }

    }

    public void keyPressed(KeyEvent e)
    {
        keybuffer[e.getKeyChar()] = true;
    }

    public void keyReleased(KeyEvent e)
    {
        keybuffer[e.getKeyChar()] = false;

    }

}
