import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO



        if (B.length == 0) {
            return null;
        }

        if (B.length == 1) {
            Building b = B[0];
            Point top = new Point(b.l, b.h);
            Point bottom = new Point(b.r,0);

            ArrayList<Point> importantpoints = new ArrayList<>();
            importantpoints.add(top);
            importantpoints.add(bottom);

            return importantpoints;

        }

        int halfLength = B.length / 2;

        Building[] L = new Building[halfLength];
        Building[] R = new Building[B.length - halfLength];

        System.arraycopy(B,0,L,0,halfLength);
        System.arraycopy(B,halfLength,R,0,B.length-halfLength);

        List<Point> splitL = skyline(L);
        List<Point> splitR = skyline(R);


        return merge(splitL, splitR);


    }

    public static List<Point> merge(List<Point> A, List<Point> B) {


        Point topA = A.get(0);
        Point bottomA = A.get(1);

        Point topB = B.get(0);
        Point bottomB = B.get(1);

        int heightLastA = 0;
        int heightLastB = 0;



        ArrayList<Point> mergedPoints = new ArrayList<>();

        while (!(A.isEmpty()) || !(B.isEmpty())) {


            // split buildings
            if (topA.x < topB.y) {
                int maxHeight = topA.y;
                if (topA.y < heightLastB) {
                    maxHeight = heightLastB;
                }
                heightLastA = topA.y;
                mergedPoints.add(topA);
                A.remove(0);
                A.remove(0);



            } else if (topA.x > topB.x) {
                int maxHeight = topB.y;
                if (topB.y < heightLastA) {
                    maxHeight = heightLastA;
                }
                heightLastB = topB.y;
                mergedPoints.add(topB);
                B.remove(0);
                B.remove(0);

            } else {
                int maxHeight = 0;
                if (topA.y > topB.y) {
                    mergedPoints.add(topA);
                    heightLastA = topA.y;
                    heightLastB = topB.y;
                    A.remove(0);
                    B.remove(0);
                    A.remove(0);
                    B.remove(0);

                }

            }

            while (!A.isEmpty()) {
                mergedPoints.add(topA);
                A.remove(0);
                A.remove(0);
            }

            while (!B.isEmpty()) {
                mergedPoints.add(topB);
                B.remove(0);
                B.remove(0);
            }

            for (int i =0; i<mergedPoints.size(); i++) {
                int j = i+1;
                while(j< mergedPoints.size() && mergedPoints.get(j).y == mergedPoints.get(i).y) {
                    mergedPoints.remove(j);
                    mergedPoints.remove(j);
                    j++;
                }
            }




        }

        return mergedPoints;

    }


}
