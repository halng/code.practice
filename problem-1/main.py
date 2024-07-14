import sys


def sub(num1, num2):
    return num1 - num2


if __name__ == "__main__":
    num1 = int(sys.argv[1])
    num2 = int(sys.argv[2])
    result = sub(num1, num2)
    print(result)
