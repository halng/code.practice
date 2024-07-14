#include<iostream>
#include<cstdlib> // Add this line to include the <cstdlib> header

using namespace std;

int sub(int a, int b) {
    return a - b;
}

int main(int argc, char* argv[]) { // Modify the main() function to accept command-line arguments
    int a = atoi(argv[1]);
    int b = atoi(argv[2]);
    cout << sub(a, b);
    return 0;
}