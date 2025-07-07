package src.modules;

import src.helpers.objects.Edge2;
import src.helpers.objects.polygon2;
import src.helpers.objects.vector2;
import src.interfaces.moduleInterfaces.edgemerger;

import java.util.ArrayList;
import java.util.LinkedList;

public class EdgeMergerModule implements edgemerger {
    public EdgeMergerModule() {
    }
    public void mergeEdges(ArrayList<Edge2>[] edgeList, ArrayList<polygon2>[] polygons) {
        for (int i = 0; i < edgeList.length; i++) {//assuming edgelists are full and polygon arraylists are created
            ArrayList<Edge2> edgeList1 = edgeList[i];
            vector2 frontvertex;
            vector2 backvertex;
            LinkedList<vector2> vertexes = new LinkedList<>();
            vertexes.add(edgeList1.getFirst().v1);
            vertexes.add(edgeList1.getFirst().v2);
            frontvertex = vertexes.getFirst();
            backvertex = vertexes.getLast();
            edgeList1.removeFirst();


            int index=0;
            while (!edgeList1.isEmpty()) {
                if(vertexes.size()>2 && frontvertex.equals(backvertex))
                {
                    polygons[i].add(new polygon2(vertexes));//this statement creates the polygon from buffer if it is connected then clear the buffers for nwe polygons at that layer.
                    vertexes.clear();
                    vertexes.add(edgeList1.getFirst().v1);
                    vertexes.add(edgeList1.getFirst().v2);
                    frontvertex = vertexes.getFirst();
                    backvertex = vertexes.getLast();
                    edgeList1.removeFirst();
                }
                else if (frontvertex.equals(edgeList1.get(index).v1))//this 4 statements check if the new edge is connected to the previous edges and if it is then it is added to the edge cloud in buffer
                {
                    vertexes.addFirst(edgeList1.get(index).v2);
                    frontvertex = vertexes.getFirst();
                    edgeList1.remove(index);
                }
                else if (frontvertex.equals(edgeList1.get(index).v2))
                {
                    vertexes.addFirst(edgeList1.get(index).v1);
                    frontvertex = vertexes.getFirst();
                    edgeList1.remove(index);
                }
                else if (backvertex.equals(edgeList1.get(index).v1))
                {
                    vertexes.addLast(edgeList1.get(index).v2);
                    backvertex = vertexes.getLast();
                    edgeList1.remove(index);
                }
                else if (backvertex.equals(edgeList1.get(index).v2))
                {
                    vertexes.addLast(edgeList1.get(index).v1);
                    backvertex = vertexes.getLast();
                    edgeList1.remove(index);

                }

                else {//and if the edge is not connected to the previous edges then it is skiped for now
                 index++;
                 if (index == edgeList1.size())
                 {
                     index = 0;
                 }
                }//todo add a control to check if no edges added to buffer for one full cycle then clear the buffer and take new edges

            }
            if(vertexes.size()>2 && frontvertex.equals(backvertex))// this statement cheks if thel leftover edges are connected polygon
            {
                polygons[i].add(new polygon2(vertexes));

            }
            vertexes.clear();




        }

    }
}
