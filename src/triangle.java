package src;

public class triangle {
    private vector3 a;
    private vector3 b;
    private vector3 c;


public triangle(vector3 a, vector3 b, vector3 c) {
    this.a = a;
    this.b = b;
    this.c = c; }
    public vector3 getNormal() {
        return a.cross(b.cross(c)).normalize();
    }
public edge[] getEdges() {
    return new edge[]{new edge(a, b), new edge(b, c), new edge(c, a)};
}

    public float getLowestZ() {
        return Math.min(Math.min(a.z, b.z), c.z);
    }
    public float getHighestZ() {
        return Math.max(Math.max(a.z, b.z), c.z);
    }

}
