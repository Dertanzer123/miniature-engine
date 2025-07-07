package src.modules;

import src.helpers.objects.Edge2;
import src.helpers.objects.plane;
import src.helpers.objects.triangle;

import java.util.ArrayList;
import java.util.Iterator;

public class EdgeCreationModule {
    EdgeCreationModule() {
    }

    public void createEdges(ArrayList<triangle> triangleList, float planeDistance, ArrayList<Edge2>[] edgelists) {
        //assuming that the planes are parallel to the x-y plane for now
        Iterator<triangle> triangleIterator = triangleList.iterator();

        while (triangleIterator.hasNext()) {
            triangle triangle1 = triangleIterator.next();
            int layer = (int) ((triangle1.getminz() + (planeDistance - (triangle1.getminz() % planeDistance))) / planeDistance);
            for (float pz = triangle1.getminz() + (planeDistance - (triangle1.getminz() % planeDistance)); pz <= triangle1.getmaxz(); pz += planeDistance) {
                Edge2 edge = triangle1.getParallelIntersection(pz);
                if (edge != null) {
                    edgelists[layer].add(edge);
                }
                layer++;
            }
        }


    }


}
