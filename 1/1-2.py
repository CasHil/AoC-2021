with open("input-1.txt") as f:    
    first, second, third = int(f.readline()), int(f.readline()), int(f.readline())
    count = 0
    for l in f:
        curr = int(l)
        if first + second + third < second + third + curr:
            count += 1
        first, second, third = second, third, curr
    print(count)