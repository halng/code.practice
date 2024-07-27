#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int sub(int a, int b) {
    return a - b;
}

int main(int argc, char* argv[]) { // Modify the main() function to accept command-line arguments
    ifstream inputFile;
    inputFile.open("./problem-1/INPUT"); // Open the input file
    int a, b;
    inputFile >> a >> b; // Read the values from the file
    inputFile.close(); // Close the input file
    cout << sub(a, b);
    return 0;
}