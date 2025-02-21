package src;

public class vector3 {
    public float x;
    public float y;
    public float z;


    vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public vector3 add(vector3 v) {
        return new vector3(x+v.x,y+v.y,z+v.z);

    }

    public vector3 scale(float f) {
        return new vector3(x*f,y*f,z*f);
    }
    public float dot(vector3 v) {
        return x*v.x+y*v.y+z*v.z;
    }
    public vector3 cross(vector3 v) {
        return new vector3(y*v.z-z*v.y,z*v.x-x*v.z,x*v.y-y*v.x);
    }
    public float length() {
        return (float) Math.sqrt(x*x+y*y+z*z);
    }
    public vector3 normalize() {

        float l = length();
     if(l==0)
     {
         return new vector3(0,0,0);
     }
        return new vector3(x/l,y/l,z/l);
    }
    public vector3 reverse() {
        return new vector3(-x,-y,-z);
    }


}
