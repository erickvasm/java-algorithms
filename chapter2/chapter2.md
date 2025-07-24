# Chapter 2: Sorting

## Insertsort

**Idea**: It simulates how we sort cards in our hand.  
We assume we have an array `a[]` of size `n`.  
For each element `a[i]`, it is inserted in the correct position within the subarray `a[0:i]`, shifting elements to the right as needed.

**Pseudocode implementation with two loops**:

- One loop to advance `i`.
- Another to compare and swap `a[j]` with `a[j+1]` if necessary.

**Outer loop invariant**: The first `i` elements are already sorted.  
**Improvement**: The number of assignments can be reduced by temporarily storing `a[i]` and performing only shifts until the correct position is found.

Then the difference between two indices gives you the number of cells between them. So for example the subarray `a[2:5]`, containing the elements from `a[2]` included to `a[5]` excluded, has `$5-2 = 3$` elements, namely `a[2] = "F"`, `a[3] = "E"` and `a[4] = "A"`.

**Analogy**:  
Imagine you are playing cards and you have to sort them in your hand.

- You take the first card and put it in your hand.
- You take the next card and put it in the right place, comparing it with the ones you already have.
- Repeat this with all the cards.

**How does it work?**  
Suppose you have this arrangement: `[8, 3, 5, 1]`

**Step by step**:

1. Start from the second element (3) and compare it with the previous one (8).
   - Since `$3 < 8$`, swap them.
   - Result: `[3, 8, 5, 1]`
2. Take the 5:
   - Compare with 8 → swap.
   - Compare with 3 → no swap.
   - Result: `[3, 5, 8, 1]`
3. Take the 1:
   - Compare with 8, 5, and 3, swapping back to the beginning.
   - End result: `[1, 3, 5, 8]`

**Pseudocode**:

```

for i = 1 to n-1:
j = i - 1
while j >= 0 and a[j] > a[j+1]:
swap(a[j], a[j+1])
j = j - 1

```

**Java code**:

```java
public static void insertSort(int[] a) {
    int n = a.length;
    for (int i = 1; i < n; i++) {
        int key = a[i]; // el valor a insertar
        int j = i - 1;
        // Mueve los elementos mayores que key hacia la derecha
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        // Inserta el valor en la posición correcta
        a[j + 1] = key;
    }
}
```

**Computational Complexity**  
Abstract modeling and growth rates. Assumptions:

- We only care about the worst case.
- Constants are ignored; asymptotic growth is what matters.
- It doesn't matter if the estimation fails for small input sizes.
- The analysis is done abstractly, without physical limitations.

**Notations O, Θ, and Ω**

- **Big-O (O)**: Upper bound.  
  `$f(n) \in O(g(n)) \Leftrightarrow \exists k, N > 0 : \forall n > N, 0 \leq f(n) \leq k \cdot g(n)$`  
  "f grows at most like g"  
  Example: Insertsort in worst case compares each number with all previous → `$O(n^2)$` operations.

- **Theta (Θ)**: Tight bound (both upper and lower).  
  `$f(n) \in \Theta(g(n)) \Leftrightarrow \exists k_1, k_2, N > 0 : \forall n > N, k_1 \cdot g(n) \leq f(n) \leq k_2 \cdot g(n)$`  
  "f grows exactly like g"  
  Example: If InsertSort always needs approximately `$n^2$` steps → `$\Theta(n^2)$`.

- **Omega (Ω)**: Lower bound.  
  "f grows at least like g"  
  Example: If InsertSort receives an already sorted array, it's linear → `$\Omega(n)$`.

| Notation | What it measures | How to think about it |
| -------- | ---------------- | --------------------- |
| O()      | Maximum growth   | Up to this limit      |
| Θ()      | Exact growth     | Equal to this         |
| Ω()      | Minimal growth   | At least this         |

**Common Errors**:

- Saying `$f(n)=O(g(n))$` is technically incorrect (should be `$f(n) \in O(g(n))$`).

---

## Mergesort

**What is Mergesort?**  
A divide-and-conquer algorithm:

1. Divide the array into two halves.
2. Sort each half recursively.
3. Merge the two sorted halves.

**Cost**: Always `$O(n \log n)$`.

**Java code**:

```java
public static void mergeSort(int[] a, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }
}
```

---

## Quicksort

**What is it?**  
Efficient sorting using a pivot:

1. Choose a pivot.
2. Partition into elements `< pivot` and `> pivot`.
3. Recursively sort each partition.

**Time complexity**:

- Best case: `$O(n \log n)$` (balanced partitions).
- Worst case: `$O(n^2)$` (unbalanced partitions).

---

## HeapSort

**How it works**:

1. Convert the array to a max-heap.
2. Repeatedly extract the maximum to sort.

**Cost**: `$O(n \log n)$` in all cases.

---

## Linear-time Sorting

Algorithms that run in `$O(n)$` time:

1. **Counting Sort**: Counts occurrences of each number.
2. **Radix Sort**: Sorts digit by digit.
3. **Bucket Sort**: Divides into buckets and sorts each.

**Limitations**: Only work under specific conditions (e.g., limited integer range).
