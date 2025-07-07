package src.interfaces.moduleInterfaces;

import src.helpers.objects.Edge2;
import src.helpers.objects.triangle;

import java.util.ArrayList;

public interface edgecreationmodule {

    public void createEdges(ArrayList<triangle> triangleList, float planeDistance, ArrayList<Edge2>[] edgelists);
}
