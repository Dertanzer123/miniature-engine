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

    public float getminz() {
        return Math.min(v1.z, Math.min(v2.z, v3.z));
    }

    public float getmaxz() {

        return Math.max(v1.z, Math.max(v2.z, v3.z));
    }

    public Edge2 getParallelIntersection(float planeZ) {
        if (v1.z > planeZ && v2.z > planeZ && v3.z > planeZ) {
            return null;
        } else if (v1.z < planeZ && v2.z < planeZ && v3.z < planeZ) {
            return null;
        } else {
            vector3 intersection1 = getIntersection(v1, v2, planeZ);
            vector3 intersection2 = getIntersection(v2, v3, planeZ);
            vector3 intersection3 = getIntersection(v3, v1, planeZ);
            if (intersection1 == null) {
                intersection1 = intersection3;
            } else if (intersection2 == null) {
                intersection2 = intersection3;
            }


            return new Edge2(intersection1, intersection2);


        }

    }

    private vector3 getIntersection(vector3 va, vector3 vb, float planeZ) {
        if (va.z > planeZ && vb.z > planeZ) {
            return null;
        } else if (va.z < planeZ && vb.z < planeZ) {
            return null;
        } else {
            float x = (((va.x - vb.x) / (va.z - vb.z)) * (planeZ - vb.z)) + vb.x;
            float y = (((va.y - vb.y) / (va.z - vb.z)) * (planeZ - vb.z)) + vb.y;
            return new vector3(x, y, planeZ);
        }
    }
}
