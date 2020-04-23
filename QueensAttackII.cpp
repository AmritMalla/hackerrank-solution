// You can read the description here https://link.medium.com/CuIsQKakU5

int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    int dist[8];

    dist[0] = c_q - 1;
    dist[1] = n - r_q;
    dist[2] = n - c_q;
    dist[3] = r_q - 1;

    dist[4] = min(dist[0],dist[1]);
    dist[5] = min(dist[1],dist[2]);
    dist[6] = min(dist[2],dist[3]);
    dist[7] = min(dist[3],dist[0]);

    int x, y;
    while(--k>=0){
        y = obstacles[k][0] - r_q;
        x = obstacles[k][1] - c_q;

        if(x == 0){
            if(y>0){
                dist[1] = min(dist[1],y-1);
            }else{
                dist[3] = min(dist[3],-(y+1));
            }
        }else if(y == 0){
            if(x>0){
                dist[2] = min(dist[2],x-1);
            }else{
                dist[0] = min(dist[0],-(x+1));
            }
        }else{
            float m = (float)y/x;
            if(m == 1.0 ){
                if(x>0){
                    dist[5] = min(dist[5],x-1);
                }else{
                    dist[7] = min(dist[7],-y -1);
                }
            }else if ( m == -1.0) {
                if(x>0){
                    dist[6] = min(dist[6],x -1);
                }else{
                    dist[4] = min(dist[4],y -1);
                }
            }
            else {
                continue;
            }
        }
    }
    int res = 0;
    for(int i = 0;i<8;i++){
        res+=dist[i];
    }
    return res;
}
