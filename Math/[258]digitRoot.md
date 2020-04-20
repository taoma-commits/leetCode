# Digital Root Formula

The *digital root* $\mathrm{dr}_b(n)$of a natural number $n$ in a given number base $b$ is the single digit obtained by an iterative process of summing digits, on each iteration using the result from the previous iteration to compute a digit sum.
***
### Existence of digital root
??
***
### Digital root formula
\[
\mathrm{dr}_b(n) = \begin{cases}
0, &n = 0\\
1 + ((n - 1)\mod (b - 1)), & n \neq 0
\end{cases}
\]
***
**Proof of the formula**
Suppose $n = d_0 + d_1 b + d_2 b^2 +\cdots + d_k b^k$.
\[\begin{aligned}
n & \equiv (d_0 + d_1 1 + d_2 \cdot 1^2 + \cdots + d_k 1^k)\mod (b-1)\\
& \equiv \left(\sum_{i = 1}^k d_i\right) \mod (b - 1)\\
\end{aligned}
\]
Deduce that $n$ and the sum of digits of $n$ have the same image through the ring homomorphism $\Z \rightarrow \Z / (b-1)$. If $n$ is a single-digit positive number of base $b$, then $$(n \mod (b - 1)) = \mathrm{dr}_b(n)$$ for $n = 1, \cdots, b - 2$ and $$((b-1) \mod(b-1)) = 0 \neq \mathrm{dr}_b(b - 1).$$
Note that for $(b - 1) \nmid n$,
\[1 + ((n - 1)\mod (b - 1)) = n \mod (b - 1)\]
and
\[1 + ((b-1)\mod (b-1)) = b - 1.\]
The second line of the formula is proved. Obviously, $\mathrm{dr}_{b}(0) = 0$.
***
The formula in Java is simply ```1 + (n - 1) / (d - 1)``` because in Java ```-1 / (d - 1) == -1``` and this takes care of the zero case.
