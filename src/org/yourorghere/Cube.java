/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author deivi
 */
public class Cube
{

    private GL gl;
    public float x;
    public float y;
    public float z;
    public float w; //Ancho
    public float h; //Alto
    public float d; //Profundidad
    public float r; //Rojo
    public float g; //Verde
    public float b; //Azul
    public float angle; //Angulo de rotacion

    public Cube(GL gl, float x,
            float y,
            float z,
            float w,
            float h,
            float d,
            float r,
            float g,
            float b,
            float angle
    )
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.r = r;
        this.g = g;
        this.b = b;
        this.angle = angle;
    }

    public void DrawCube(float a)
    {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z); //Trasladamos el eje de puntos al centro
        gl.glRotatef(angle, 0, 1, 0); //
        gl.glTranslatef(-x, -y, -z); //Nos permite volver al origen

        gl.glBegin(GL.GL_QUADS);//Cara Frontal
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y - h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);//Cara Trasera
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);//Cara Izquierda
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);//Cara Derecha
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y - h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);//Cara Arriba
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);//Cara Abajo
        gl.glColor3f(r, g, b);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);
        gl.glEnd();

        gl.glPopMatrix();
    }

    public void DrawCube()
    {

        DrawCube(0);
    }

    public float getAngle()
    {
        return angle;
    }

    public void setAngle(float angle)
    {
        this.angle = angle;
    }

    /**
     * @return the x
     */
    public float getX()
    {
        return x;
    }

    /**
     * @return the y
     */
    public float getY()
    {
        return y;
    }

    /**
     * @return the z
     */
    public float getZ()
    {
        return z;
    }

    public float getD()
    {
        return d;
    }

}
