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
    public ArrayList<Cube> paredesZ;

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
        p1 = new Cube(gl, x - w * 2f, y + h / 2, z, w / 20, h, d * 4, 0, 0f, 1f, 1f); //Paredes laterales
        p2 = new Cube(gl, x - 0.5f, y + h / 2, z - d * 2, w * 3, h, d / 20, 0, 0f, 1f, 1f);
        p3 = new Cube(gl, x + w * 2, y + h / 2, z, w / 20, h, d * 4, 0, 0f, 1f, 1f);
        p4 = new Cube(gl, x - 1.2f, y + h / 2, z + d * 2, w * 1.6f, h, d / 20, 0, 0f, 1f, 1f);
        p41 = new Cube(gl, x + 1.2f, y + h / 2, z + d * 2, w * 1.6f, h, d / 20, 0, 0f, 1f, 1f);

        //Paredes Laterales de la parte superior
        pz1 = new Cube(gl, x - 1.3f, y + h / 2, z + 1.3f, w * 1.4f, h, d / 20, 0, 1f, 1f, 0f);
        pz2 = new Cube(gl, x - 1.3f, y + h / 2, z + 1f, w / 2, h, d / 20, 0, 1f, 1f, 0f);
        pz3 = new Cube(gl, x - 1.3f, y + h / 2, z + 0.5f, w * 0.6f, h, d / 20, 0, 1f, 1f, 0f);
        pz4 = new Cube(gl, x - 1.1f, y + h / 2, z, w + 0.2f, h, d / 20, 0, 1f, 1f, 0f);
        pz5 = new Cube(gl, x - 0.75f, y + h / 2, z - 0.5f, w + 0.5f, h, d / 20, 0, 1f, 1f, 0f);
        pz6 = new Cube(gl, x - 0.6f, y + h / 2, z - 0.8f, w * 0.6f, h, d / 20, 0, 1f, 1f, 0f);
        pz7 = new Cube(gl, x - 1.2f, y + h / 2, z - 1f, w * 0.6f, h, d / 20, 0, 1f, 1f, 0f);

        //Paredes laterales parte inferior
        p1z = new Cube(gl, x + 1.2f, y + h / 2, z + 1.5f, w + 0.5f, h, d / 20, 0, 1f, 0f, 1f);
        p2z = new Cube(gl, x + 1.5f, y + h / 2, z + 1f, w / 2f, h, d / 20, 0, 1f, 0f, 1f);
        p3z = new Cube(gl, x + 0.75f, y + h / 2, z + 0.25f, w * 1.5f, h, d / 20, 0, 1f, 0f, 1f);
        p4z = new Cube(gl, x + 1.6f, y + h / 2, z - 0.25f, w * 0.8f, h, d / 20, 0, 1f, 0f, 1f);
        p5z = new Cube(gl, x + 0.5f, y + h / 2, z - 0.25f, w * 0.5f, h, d / 20, 0, 1f, 0f, 1f);
        p6z = new Cube(gl, x + 0.5f, y + h / 2, z - 1f, w * 1.5f, h, d / 20, 0, 1f, 0f, 1f);
        p7z = new Cube(gl, x + 0.2f, y + h / 2, z - 1.5f, w * 1.5f, h, d / 20, 0, 1f, 0f, 1f);
        p8z = new Cube(gl, x + 1.5f, y + h / 2, z - 1.5f, w / 2f, h, d / 20, 0, 1f, 0f, 1f);

        //Paredes horizontales parte superior
        px1 = new Cube(gl, x - 0.6f, y + h / 2, z + 0.6f, w / 20, h, d * 1.2f, 0, 1f, 1f, 1f);/////////////////////////??????????????????
        px2 = new Cube(gl, x - 1.6f, y + h / 2, z + 0.4f, w / 20f, h, d * 1.2f, 0, 1f, 1f, 1f);
        px3 = new Cube(gl, x - 1.5f, y + h / 2, z + 0.8f, w / 20f, h, d * 0.6f, 0, 1f, 1f, 1f);
        px4 = new Cube(gl, x - 0.9f, y + h / 2, z - 1.4f, w / 20f, h, d + 0.2f, 0, 1f, 1f, 1f);
        px5 = new Cube(gl, x, y + h / 2, z + 0.5f, w / 20f, h, d * 1, 0, 1f, 1f, 1f);

        //Paredes horizontales parte inferior
        p1x = new Cube(gl, x + 0.75f, y + h / 2, z + 1.1f, w / 20, h, d * 1.1f, 0, 1f, 1f, 1f);/////////////////////////??????????????????
        p2x = new Cube(gl, x + 1.4f, y + h / 2, z + 0.8f, w / 20, h, d / 2, 0, 1f, 1f, 1f);
        p3x = new Cube(gl, x + 0.3f, y + h / 2, z - 0.25f, w / 20, h, d / 2, 0, 1f, 1f, 1f);
        p4x = new Cube(gl, x + 1f, y + h / 2, z - 0.6f, w / 20, h, d, 0, 1f, 1f, 1f);
        p5x = new Cube(gl, x - 0.1f, y + h / 2, z - 1.6f, w / 20, h, d * 0.8f, 0, 1f, 1f, 1f);
        p6x = new Cube(gl, x + 1.8f, y + h / 2, z - 1.6f, w / 20, h, d * 0.8f, 0, 1f, 1f, 1f);

        paredesX = new ArrayList<Cube>();
        paredesX.add(px1);
        paredesX.add(px2);
        paredesX.add(px3);
        paredesX.add(px4);
        paredesX.add(px5);
        paredesX.add(p1x);
        paredesX.add(p2x);
        paredesX.add(p3x);
        paredesX.add(p4x);
        paredesX.add(p5x);
        paredesX.add(p6x);
        paredesX.add(p1);
        paredesX.add(p3);

        paredesZ = new ArrayList<Cube>();
        paredesX.add(pz1);
        paredesX.add(pz2);
        paredesX.add(pz3);
        paredesX.add(pz4);
        paredesX.add(pz5);
        paredesX.add(pz6);
        paredesX.add(pz7);
        paredesX.add(p1z);
        paredesX.add(p2z);
        paredesX.add(p3z);
        paredesX.add(p4z);
        paredesX.add(p5z);
        paredesX.add(p6z);
        paredesX.add(p7z);
        paredesX.add(p8z);
        paredesX.add(p2);
        paredesX.add(p4);
        paredesX.add(p41);

    }

    public void DrawFloor()
    {
        for (Cube v : paredesX)
        {
            v.DrawCube();
        }
        for (Cube v : paredesZ)
        {
            v.DrawCube();
        }
        piso.DrawCube();
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getZ()
    {
        return z;
    }

    public float getW()
    {
        return w;
    }

}
