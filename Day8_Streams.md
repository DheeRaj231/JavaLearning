# 📘 Java Streams & Functional Programming Handbook

This expanded handbook gives deeper explanations, clearer breakdowns, and more examples for thorough understanding.
### Based on Your Uploaded PDFs
Includes: Stream API, Map/Filter/Reduce/Sorted, Method Reference, Constructor Reference, Optional Class, Parallel Stream

---
# 1️⃣ Stream API (Java 8)
Streams provide a **functional way** to process collections.

### ✔ Key Characteristics
- Stream is in `java.util.stream` package.
- Does **not** modify original collection.
- Supports **pipeline processing**.
- Intermediate operations are **lazy**.
- A stream can be used **only once**.

### ✔ Stream Pipeline Structure
1. **Source Stage** – `list.stream()`
2. **Intermediate Stage** – `filter()`, `map()`, `sorted()`
3. **Terminal Stage** – `forEach()`, `collect()`, `reduce()`

### ✔ Common Stream Methods
| Method | Purpose |
|--------|---------|
| `filter(Predicate)` | Filters elements |
| `map(Function)` | Transforms elements |
| `sorted()` | Sorts elements |
| `reduce()` | Reduces to a single result |
| `collect()` | Converts to list, set, map |
| `findFirst()` | Returns first element |
| `toArray()` | Converts stream to array |

### ✔ Example
```java
List<Integer> nums = Arrays.asList(4,5,7,3,2,6);

int result = nums.stream()
        .filter(n -> n % 2 == 0)   // 4,2,6
        .map(n -> n * 2)           // 8,4,12
        .reduce(0, (c,e) -> c + e); // 24

System.out.println(result);
```
Output:
```
24
```

---
# 2️⃣ Map, Filter, Reduce, Sorted
## 🔹 FILTER — Select elements
fileciteturn1file1
```java
nums.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```
Output:
```
4
2
6
```

## 🔹 MAP — Transform elements
fileciteturn1file1
```java
nums.stream()
    .map(n -> n * 2)
    .forEach(System.out::println);
```
Output:
```
8 10 14 6 4 12
```

## 🔹 REDUCE — Combine into one
fileciteturn1file1
```java
int sum = nums.stream().reduce(0, (a,b) -> a + b);
```

## 🔹 SORTED — Natural or custom order
```java
nums.stream().sorted().forEach(System.out::println);             // natural
nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); // custom
```

---
# 3️⃣ Method Reference
fileciteturn1file2
A shorthand for calling methods using `::` operator.

### ✔ Key Forms
1. **Static method** → `ClassName::methodName`
2. **Instance method of object** → `obj::method`
3. **Instance method of type** → `String::toUpperCase`
4. **Constructor reference** → `ClassName::new`

### ✔ Example – Convert to uppercase
```java
List<String> names = Arrays.asList("Navin", "Harsh", "John");

List<String> uNames = names.stream()
        .map(String::toUpperCase)
        .toList();
```

### ✔ forEach with method reference
```java
uNames.forEach(System.out::println);
```

---
# 4️⃣ Constructor Reference
fileciteturn1file0
Used to create objects more cleanly.

### ✔ Syntax
```
ClassName::new
```

### ✔ Example
Student class (from PDF):
```java
class Student {
    private String name;
    public Student(String name) { this.name = name; }
}
```

### ✔ Using constructor reference
```java
List<String> names = Arrays.asList("Navin", "Harsh", "John");

List<Student> students = names.stream()
        .map(Student::new)
        .toList();
```

---
# 5️⃣ Optional Class
fileciteturn1file3
Prevents **NullPointerException**.

### ✔ Purpose
- Represent value present / absent
- Avoid null checks
- Works with `findFirst()`, `max()`, etc.

### ✔ Common Methods
| Method | Meaning |
|--------|---------|
| `isPresent()` | value exists |
| `orElse(default)` | default value |
| `orElseGet(supplier)` | lazy default |
| `orElseThrow()` | custom exception |

### ✔ Example
```java
Optional<String> name = names.stream()
        .filter(n -> n.contains("x"))
        .findFirst();

System.out.println(name.orElse("Not Found"));
```
Output:
```
Not Found
```

---
# 6️⃣ Parallel Stream
fileciteturn1file4
Used for **multi-threaded** stream processing.

### ✔ How to create
```java
list.parallelStream()
stream.parallel()
```

### ✔ When to use
✔ Large datasets
✔ CPU-intensive operations
✔ Independent tasks

### ✔ When NOT to use
❌ Small collections
❌ Requires ordering
❌ Shared mutable state

### ✔ Example
```java
nums.parallelStream()
    .map(n -> n * 2)
    .forEach(System.out::println);
```

(Note: Output order is not guaranteed.)

---
# 📌 Final Summary
| Topic | Purpose |
|-------|----------|
| Stream API | Functional collection processing |
| Filter | Select items |
| Map | Transform items |
| Reduce | Aggregate items |
| Sorted | Sort stream elements |
| Method Reference | Cleaner lambda syntax |
| Constructor Reference | Clean object creation |
| Optional | Avoid null problems |
| Parallel Stream | Multi-threaded processing |

---

