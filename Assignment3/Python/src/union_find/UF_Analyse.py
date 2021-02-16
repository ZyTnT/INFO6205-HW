import matplotlib.pyplot as plt

with open('F:\\Assignment3\\generationNum.txt') as f:
    data = f.read()
data = data.split(",")
del data[10000]

x_list = []
for i in range(9999, -1, -1):
    x_list.append(i)

plt.scatter(x_list, data)
plt.xlabel("the number of objects (n)")
plt.ylabel("the number of pairs (m)")
plt.show()

