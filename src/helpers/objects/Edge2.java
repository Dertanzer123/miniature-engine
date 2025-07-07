package src.helpers.objects;

public class Edge2 {
    public vector2 v1;
    public vector2 v2;
    Edge2(vector2 v1, vector2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    Edge2(vector3 v1, vector3 v2) {
        this.v1 = new vector2(v1.x, v1.y);
        this.v2 = new vector2(v2.x, v2.y);
    }
}
