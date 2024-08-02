package leetcode_days.daily.D20240709;

public class S3102 {
    final int INF = Integer.MAX_VALUE;
    public int minimumDistance(int[][] points) {
        int maxX=-INF,maxXnext = -INF,maxY=-INF,maxYnext=-INF;
        int minX=INF,minXnext=INF,minY=INF,minYnext=INF;
        for(int[] point:points){
            int ex = point[0]+point[1];
            int ey = point[1]-point[0];
            if(ex>maxX){
                maxXnext = maxX;
                maxX = ex;
            }else if(ex>maxXnext){
                maxXnext = ex;
            }
            if(ey>maxY){
                maxYnext = maxY;
                maxY = ey;
            }else if(ey>maxYnext){
                maxYnext = ey;
            }
            if(ex<minX){
                minXnext = minX;
                minX = ex;
            }else if(ex < minXnext){
                minXnext = ex;
            }
            if(ey<minY){
                minYnext = minY;
                minY = ey;
            }else if(ey<minYnext){
                minYnext = ey;
            }
        }
        int res = Math.max(maxX-minX,maxY-minY);
        for(int[] point:points){
            int ex = point[0]+point[1];
            int ey = point[1]-point[0];
            int dx = ((ex==maxX?maxXnext:maxX) - (ex==minX?minXnext:minX));
            int dy = ((ey==maxY?maxYnext:maxY) - (ey==minY?minYnext:minY));
            res = Math.min(res,Math.max(dx,dy));
        }
        return res;
    }

    public static void main(String[] args) {
        S3102 s3102 = new S3102();
        System.out.println(s3102.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}));
    }
}
