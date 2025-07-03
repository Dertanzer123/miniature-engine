package src.helpers.objects;

public class triangle {
    public vector3 v1;
    public vector3 v2;
    public vector3 v3;
    public triangle(vector3 v1, vector3 v2, vector3 v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    public float getminz()
    {
        return Math.min(v1.z, Math.min(v2.z, v3.z));
    }
    public float getmaxz()
    {

        return Math.max(v1.z, Math.max(v2.z, v3.z));
    }
}
