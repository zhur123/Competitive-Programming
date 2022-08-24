#include <iostream>
using namespace std;

int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a%b);
}

int main(){
	int w, h;
    cin >> w >> h;
    int factor = gcd(w, h);
    w /= factor;
    h /= factor;
    if(w==h){
        cout << 2 << endl;
    }else if(w%2 == 0){
        cout << 1 << endl;
    }else{
        if(h%2 == 0){
            cout << 3 << endl;
        }else{
            cout << 2 << endl;
        }
    }
	return 0;
}

