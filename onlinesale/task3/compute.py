def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1, n-10):
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out + lim  # Corrected line: changed '-' to '+'
        out = out // 2    # Corrected line: changed '/' to '//'
    print(out)


n = int(input("Enter an integer: "))
compute(n)


# output: 
# Enter an integer: 10
# 1