package src;

public class edge {
    private vector3 a;
    private vector3 b;

    edge(vector3 a, vector3 b) {
        this.a = a;
        this.b = b;
    }
    public vector3[] getOverlapWithPlane(vector3 p, vector3 n) {
        float EPSILON = 0.0001f;
        // Check if the edge is parallel to the plane
        boolean isParallel = Math.abs(a.add(b.reverse()).dot(n)) < EPSILON;

        // Calculate the intersection parameter t
        float t = n.dot(p.add(a.reverse())) / n.dot(b.add(a.reverse()));

        // Check if the intersection is within the boundary of the segment
        boolean isInBoundary = 0 <= t && t <= 1;

        // If not parallel and within boundary, return the intersection point
        if (!isParallel && isInBoundary) {
            vector3 overlap = a.add((a.add(b.reverse())).scale(t));
            return new vector3[]{overlap};
        }

        // If parallel and lies on the plane, return both points of the edge
        if (isParallel && Math.abs(n.dot(a.add(p.reverse()))) < EPSILON) {
            return new vector3[]{a, b};
        }

        // If no overlap, return null
        return null;
    }


}
