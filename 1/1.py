f = open("input-1.txt", "r")
prev = int(f.readline())
count = 0
for l in f:
    curr = int(l)
    if prev < curr:
        count += 1
    prev = curr
print(count)