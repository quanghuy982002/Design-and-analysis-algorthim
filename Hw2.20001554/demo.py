import random
import time
import matplotlib.pyplot as plt

def selection_sort(arr):
    n = len(arr)
    for i in range(n-1):
        min_idx = i
        for j in range(i+1, n):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]


n_list = [1000, 5000, 10000, 20000, 30000]
time_list = []


for n in n_list:
    arr = [random.randint(0, 100000) for i in range(n)]
    start_time = time.time()
    selection_sort(arr)
    end_time = time.time()
    time_list.append(end_time - start_time)

# chart
plt.plot(n_list, time_list, '-o')
plt.xlabel('Size of array')
plt.ylabel('Time (s)')
plt.title('Selection Sort')
plt.show()
