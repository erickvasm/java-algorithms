# Chapter 3: Algorithm Design

## Dynamic Programming

### Rod Cutting Problem

**Problem**: Given a rod of length `n` and an array `prices[]` where `prices[i]` is the value of a rod of length `i + 1`, find the optimal way to cut the rod to maximize profit.

**Recurrence formula**:
$$ r(n) = \max\_{1 \leq i \leq n} (prices[i] + r(n-i)) $$

**Key concept**: For each length `i`, evaluate all possible cuts and choose the one that maximizes the sum between the cut value and the optimal solution for the remainder.  
**Complexity**: $O(n^2)$

---

### Matrix Chain Multiplication

**Problem**: Given a sequence of matrices, determine the optimal multiplication order to minimize the total number of scalar multiplications.  
**Input**: An array `p[]` where the i-th matrix has dimensions `p[i-1] × p[i]`.

**Recurrence formula**:
$$ m[i,j] = \min\_{i \leq k < j} (m[i,k] + m[k+1,j] + p[i-1] \cdot p[k] \cdot p[j]) $$

**Strategy**: Test all possible split points `k` and choose the minimum cost combination.  
**Complexity**: $O(n^3)$

---

### Longest Common Subsequence (LCS)

**Problem**: Given two strings, find the longest subsequence common to both (not necessarily contiguous).

**Recurrence formula**:

$$
\text{LCS}(i,j) =
\begin{cases}
0 & \text{if } i=0 \text{ or } j=0 \\
\text{LCS}(i-1,j-1) + 1 & \text{if } x[i] = y[j] \\
\max(\text{LCS}(i-1,j), \text{LCS}(i,j-1)) & \text{otherwise}
\end{cases}
$$

**Complexity**: $O(m \times n)$

---

## Greedy Algorithms

### Core Principles

1. **Incremental construction**: Solution built step-by-step
2. **Locally optimal choice**: At each step, select the seemingly best option
3. **Optimality verification**: Doesn't always guarantee global optimum (requires proof)

---

### Huffman Coding

**Problem**: Construct an optimal binary code given character frequencies.

**Strategy**:

1. Create nodes for each character
2. Use priority queue to build binary tree by combining lowest-frequency nodes
3. Assign `0`/`1` to left/right branches

**Complexity**: $O(n \log n)$

---

### The Knapsack Problem

**Fractional Version (Greedy)**  
**Strategy**: Select items with highest value/weight ratio first  
**Complexity**: $O(n \log n)$ (due to sorting)

**0/1 Version (DP)**  
**Recurrence formula**:
$$ dp[i][w] = \max(dp[i-1][w], dp[i-1][w-w_i] + v_i) $$  
**Complexity**: $O(n \times W)$

---

## Other Design Strategies

### Divide and Conquer

**Steps**:

1. Divide into subproblems
2. Solve recursively
3. Combine solutions

**Examples**:

- MergeSort ($O(n \log n)$)
- Binary Search ($O(\log n)$)

**Master Theorem**:
$$ T(n) = aT\left(\frac{n}{b}\right) + f(n) $$

---

### Backtracking

**Use Case**: Exhaustive search with pruning  
**Examples**: N-queens, Sudoku  
**Complexity**: Exponential (improved with pruning)

---

### Branch and Bound

**Difference from Backtracking**: Uses bounds to prune non-optimal branches  
**Applications**: TSP, Knapsack

---

### Randomized Algorithms

**Types**:

- **Monte Carlo**: Fast, possible error
- **Las Vegas**: Always correct, variable runtime

**Example**: QuickSort with random pivot ($O(n \log n)$ expected)

---

### Strategy Comparison

| Strategy           | Typical Use Case          | Complexity           |
| ------------------ | ------------------------- | -------------------- |
| Divide and Conquer | Recursive problems        | $O(n \log n)$        |
| Backtracking       | Exhaustive search         | Exponential          |
| Branch and Bound   | Optimization with pruning | Improved exponential |
| Randomized         | Probabilistic solutions   | Case-dependent       |
