# Task 3: Debugging Script
# Problem Statement
The provided Bash/Python script is meant to perform specific computations on an integer input (n). However, there are bugs in the script that need to be identified and fixed.

# Computation Rules:
If n is less than 10: Calculate its Square.
If n is between 10 and 20: Calculate the factorial of (n-10).
If n is greater than 20: Calculate the sum of all integers between 1 and (n-20).
# Debugging Process
# Review the Script:

Carefully examine the provided Bash/Python script to understand its structure and logic.

# Identify Bugs:

Execute the script with different inputs to observe any unexpected behavior. Identify areas where the script deviates from the expected computation rules.

# Debugging Steps:

Bug 1: Corrected line: changed "out = out - lim" to "out = out + lim"

Bug 2: Corrected line: changed "out = out / 2" to "out = out // 2"


# Testing:

Test the script with various inputs to ensure that it now produces the correct output according to the computation rules.

# code: 
```bash
def compute(n):
    if n < 10:
        out = n ** 2
    elif 10 <= n <= 20:
        out = 1
        for i in range(1, n-10+1):
            out *= i
    else:
        lim = n - 20
        out = (lim * (lim + 1)) // 2
    print(out)

n = int(input("Enter an integer: "))
compute(n)
```
# output:
```bash
Enter an integer: 10
1
```
