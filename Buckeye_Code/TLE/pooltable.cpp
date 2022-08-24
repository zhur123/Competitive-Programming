#include <bits/stdc++.h>
using namespace std;

int main(){
	int w, h;
    cin >> w >> h;
    int x = 0, y = h;
    int dx = 1, dy = -1;
    while(not(x == 0 && y == 0) and not(x == w && y == 0) and not(x == w && y == h)){
        int distX = w - x;
        int distY = h - y;
        if(dx < 0){
            distX = x;
        }
        if(dy < 0){
            distY = y;
        }
        
        if(distX < distY){
            x += dx * distX;
            y += dy * distX;
            dx = -dx;
        }else{
            x += dx * distY;
            y += dy * distY;
            dy = -dy;
        }
    }
    if(x == 0 && y == 0){
        cout << 3 << endl;
    }else if(x == w && y == 0){
        cout << 2 << endl;
    }else if(x == w && y == h){
        cout << 1 << endl;
    }
	return 0;
}

