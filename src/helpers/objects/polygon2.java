package src.helpers.objects;

import java.util.ArrayList;
import java.util.LinkedList;

public class polygon2 {
    ArrayList<vector2> vertexes;
    public polygon2(ArrayList<vector2> vertexes)
    {
        if(vertexes.size() < 3)
        {
            throw new IllegalArgumentException("polygons must have at least 3 vertexes");
        }
        this.vertexes = vertexes;
    }
    public polygon2(LinkedList<vector2> vertexes)
    {
        if(vertexes.size() < 3)
        {
            throw new IllegalArgumentException("polygons must have at least 3 vertexes");
        }
        this.vertexes = new ArrayList<>(vertexes);
    }



}
