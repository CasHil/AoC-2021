with open("input-1.txt") as f:    
    first = int(f.readline())
    second = int(f.readline())
    third = int(f.readline())
    count = 0
    for l in f:
        curr = int(l)
        if first + second + third < second + third + curr:
            count += 1
        first = second
        second = third
        third = curr
    print(count)