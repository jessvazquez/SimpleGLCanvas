/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 *
 * @author deivi
 */
public class Laberinto
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

    public Cube piso, p1, p2, p3, p4, p41, p21;
    public Cube pz1, pz2, pz3, pz4, pz5, pz6, pz7;
    public Cube p1z, p2z, p3z, p4z, p5z, p6z, p7z, p8z;
    public Cube px1, px2, px3, px4, px5, px6;
    public Cube p1x, p2x, p3x, p4x, p5x, p6x, p7x, p8x;

    public ArrayList<Cube> paredesX;
    public ArrayList<Cube> paredesY;

    public Laberinto(GL gl, float x,
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

        piso = new Cube(gl, x, y, z, w * 4, h / 5, d * 4, 0, 0f, 1f, 1f);
        p1 = new Cube(gl, x - w * 2f, y + h / 2, z, w / 20, h, d * 4, 0, 0f, 1f, 1f);
        p2 = new Cube(gl, x - 0.5f, y + h / 2, z - d * 2, w * 3, h, d / 20, 0, 0f, 1f, 1f);
        p3 = new Cube(gl, x + w * 2, y + h / 2, z, w / 20, h, d * 4, 0, 0f, 1f, 1f);

    }

}
