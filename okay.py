def counts(str , t):
    cou = str.count(t)
    return cou

str = ['apple', 'banana', 'apple', 'cherry', 'apple', 'date', 'apple']
t = 'apple'

res = counts(str ,t )
print(f"the string '{t}' occurs '{res}' in times")
