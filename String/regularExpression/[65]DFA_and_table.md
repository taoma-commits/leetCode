 # Notes on LeetCode [65] Valid Number

## State diagram of the deterministic finite automata (DFA)

```mermaid
graph LR
    0 -- digit --> 2 -- digit --> 2 -- ' ' --> 8(8):::c
    0 -- ' ' --> 0 -- '+/-' --> 1 -- digit --> 2(2):::c -- Exp --> 5 -- digit --> 7(7):::c -- ' ' --> 8 -- ' ' --> 8
    0 -- '.' --> 3 -- digit --> 4(4):::c -- digit --> 4 -- Exp --> 5 -- '+/-' --> 6 -- digit --> 7 -- digit --> 7
    1 -- '.' --> 3
    2 -- '.' --> 4 -- ' ' --> 8;
    classDef c fill:#f96;
```

## Table-driven approach

|State\Step|' '|+/-|digit |'.'|Exp|other|  
|--|:-:|:-:|:-:|:-:|:-:|:-:|
| 0| 0| 1| 2| 3|-1|-1|
| 1|-1|-1| 2| 3|-1|-1|
| 2| 8|-1| 2| 4| 5|-1|
| 3|-1|-1| 4|-1|-1|-1|
| 4| 8|-1| 4|-1| 5|-1|
| 5|-1| 6| 7|-1|-1|-1|
| 6|-1|-1| 7|-1|-1|-1|
| 7| 8|-1| 7|-1|-1|-1|
| 8| 8|-1|-1|-1|-1|-1|
