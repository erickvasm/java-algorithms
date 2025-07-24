# Chapter 1: What’s the point of all this

## What is an algorithm?

A recipe for solving a problem (step by step):

- Can you prove your algorithm is correct?
- Is your algorithm simple enough that you can run it with pencil and paper?

---

### DNA Sequences

**Problem**: Find how similar two DNA sequences are.  
Each sequence is like a string of letters (A, C, G, T).  
We want to find the **Longest Common Subsequence (LCS)**.

A subsequence means you can remove letters (but not change their order).

**Example**:

- If `S = AGTGTACCCAT`:
  - `AGTAAT` is a valid subsequence (some letters skipped).
  - `AAG` or `TCG` are not (they change the order or insert letters).

> The goal of the algorithm is to find the longest such subsequence between two strings.

---

### Initial challenge: How long would it take to compare all possible subsequences?

#### Total Number of Possible Subsequences (Exercise 0)

For a string of length $n$, the total number of subsequences (including the empty string) is:

$$
2^n
$$

So:

- For string $X$, there are $2^n$ possible subsequences.
- For string $Y$, there are $2^m$ possible subsequences.

Comparing all subsequences of $X$ with all subsequences of $Y$ would result in:

$$
2^n \times 2^m = 2^{n + m}
$$

**Example**:  
For the string `"abc"` (length 3), the set of all subsequences is:  
`{ "", "a", "b", "c", "ab", "ac", "bc", "abc" }`  
In total:

$$
2^3 = 8
$$

---

### Runtime (Brute Force)

An algorithm that compares all possible combinations would take **exponential time**:

$$
O(2^{n + m})
$$

This is inefficient and unfeasible, even for relatively small values like $n = 30$.

**Example**:

- If $n = 10$ and $m = 10$:

$$
2^{10 + 10} = 2^{20} \approx 1,\!000,\!000 \text{ comparisons}
$$

---

### Best-Seller List

Imagine a store like Amazon with **millions of products**.  
Every minute, it updates the list of the **top 100 best-selling items**.  
But hundreds of products are sold **every second**.

How can this be done quickly?

- Should we sort everything again every minute? → Too slow
- Or can we keep the data sorted as sales happen? → Much more efficient

This example introduces a key idea: **evaluating the performance** of different algorithms.

#### Response

We **shouldn’t** sort everything every minute — it’s too slow.

Instead, we can keep the data sorted **as sales happen** using efficient data structures like:

- **Heaps** (e.g., a min-heap of top 100 items)
- **Hash maps + balanced trees** for fast updates

This way, we only update what’s necessary, making it **fast even with millions of products**.

---

### Database Indexing

Think of a massive database (like a bank’s or auction site’s).  
It contains **millions of records** and many **indexes**:

- By name, date, amount, and so on.

Since everything doesn’t fit in **RAM**, indexes are stored on **disk**.  
Reading from disk is slow, so we need **data structures** (like **trees** or **B-trees**) that allow **fast searches** without reading the whole file.

---

### Important Questions When Designing Algorithms

The instructor suggests thinking like a scientist and asking key questions:

1. **What is the algorithm?**
   - What steps solve the problem?
   - What data structures are needed?

2. **Is it correct?**
   - Does it always return the correct answer?
   - Can I prove it mathematically?

3. **How fast is it?**
   - How long does it take for 10, 1,000, or a million data points?
   - How does the computer type affect it?

4. **Which algorithm is better?**
   - Sometimes, there’s more than one way to solve a problem.
   - We must compare speed, memory usage, and scalability.

---

> The goal of this course is to learn how to answer these questions for **any algorithm**, not just memorize solutions.
