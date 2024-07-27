def sub(num1, num2):
    return num1 - num2


if __name__ == "__main__":
    # Read data from file INPUT
    with open("./problem-1/INPUT", "r") as f:
        num1 = int(f.readline().strip())
        num2 = int(f.readline().strip())

    result = sub(num1, num2)
    print(result)
