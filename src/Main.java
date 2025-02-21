package src;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {
    ArrayList<triangle> triangles;
    ArrayList<ArrayList<edge>> boundries;//note for later //store the boundries in a disk if the geometry is too big
    float printbounry=10f;
    float printstep=0.1f;

    public static void main(String[] args) {





    }

    void parseSTL(String filePath) throws Exception {// add a filter for triangles that are having duplicate vertices
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        // Read the STL header (80 bytes, usually unused text)
        System.out.println("Name:");
        for (int i = 0; i < 80; i++) {
            System.out.print((char) bis.read());
        }

        // Read the number of triangles (4-byte integer, Little-Endian)
        int triangleCount = 0;
        for (int i = 0; i < 4; i++) {
            triangleCount |= (bis.read() << (i * 8)); // Little-Endian order
        }
        System.out.println("\nTriangle count: " + triangleCount);
              // Loop through each triangle
        for (int i = 0; i < triangleCount; i++) {
            // Skip normal vector (3 floats = 12 bytes)
            bis.readNBytes(12);

            // Read 3 vertices (each vertex = 3 floats = 12 bytes)
            for (int j = 0; j < 3; j++) {
                int b1 = bis.read();
                int b2 = bis.read();
                int b3 = bis.read();
                int b4 = bis.read();

                int floatBits = (b4 << 24) | (b3 << 16) | (b2 << 8) | (b1);
                float x = Float.intBitsToFloat(floatBits);

                b1 = bis.read();
                b2 = bis.read();
                b3 = bis.read();
                b4 = bis.read();
                floatBits = (b4 << 24) | (b3 << 16) | (b2 << 8) | (b1);
                float y = Float.intBitsToFloat(floatBits);

                b1 = bis.read();
                b2 = bis.read();
                b3 = bis.read();
                b4 = bis.read();
                floatBits = (b4 << 24) | (b3 << 16) | (b2 << 8) | (b1);
                float z = Float.intBitsToFloat(floatBits);

                System.out.print(x + " " + y + " " + z + " , ");
                triangles.add(new triangle(new vector3(x,y,z),new vector3(x,y,z),new vector3(x,y,z)));
            }
            System.out.println();

            // Skip attribute byte count (2 bytes)
            bis.readNBytes(2);
        }
        bis.close();
    }
    void constructPlaneBoundry()
    {
        float eps=1e-6f;
        for(float z=0;z<printbounry;z+=printstep)
        {
            boundries.add(new ArrayList<>());
        }

        vector3 n = new vector3(0,0,1);

        for(triangle t:triangles)
        {
            for(float z=0;t.getHighestZ()-z>eps;z+=printstep)
            {
                if(Math.abs(z - t.getLowestZ()) < eps)
                {

                }
                else{
                    vector3 p = new vector3(0,0,z);


                    vector3 a =null;
                    vector3 b =null;
                    for(edge e:t.getEdges())
                    {
                        vector3[] overlap = e.getOverlapWithPlane(p,n);
                        if(overlap!=null)
                        {
                            if(overlap.length==2)
                            {
                                System.out.println(overlap[0]+" "+overlap[1]);
                                a=overlap[0];
                                b=overlap[1];
                                break;
                            }
                            else
                            {
                                if(a==null)
                                {
                                    a=overlap[0];
                                }
                                else
                                {
                                    b=overlap[0];
                                }
                                System.out.println(overlap[0]);
                            }
                        }

                    }
                    if(a!=null && b!=null)
                    {
                        boundries.get((int)(z/printstep)).add(new edge(a,b));

                    }
                }

            }
        }
    }

}
